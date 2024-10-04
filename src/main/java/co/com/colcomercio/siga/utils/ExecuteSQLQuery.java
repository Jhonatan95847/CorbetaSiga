package co.com.colcomercio.siga.utils;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.annotations.Subject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ExecuteSQLQuery implements Task {

    private final String query;
    private final String dbUrl;
    private final String dbUsername;
    private final String dbPassword;
    private final String resultKey;

    public ExecuteSQLQuery(String query, String dbUrl, String dbUsername, String dbPassword, String resultKey) {
        this.query = query;
        this.dbUrl = dbUrl;
        this.dbUsername = dbUsername;
        this.dbPassword = dbPassword;
        this.resultKey = resultKey;
    }

    @Override
    @Subject("execute SQL query")
    public <T extends Actor> void performAs(T actor) {
        String result = "";
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            if (resultSet.next()) {
                result = resultSet.getString(1); // Almacena el primer valor del resultado
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        actor.remember(resultKey, result); // Guarda el resultado como una variable en el actor
    }

    public static ExecuteSQLQuery with(String query, String dbUrl, String dbUsername, String dbPassword, String resultKey) {
        return instrumented(ExecuteSQLQuery.class, query, dbUrl, dbUsername, dbPassword, resultKey);
    }
}