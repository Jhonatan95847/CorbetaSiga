package co.com.colcomercio.siga.utils;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.annotations.Subject;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EjecutarConsultaSQL implements Task {

    private final String host;
    private final int puerto;
    private final String baseDeDatos;
    private final String usuario;
    private final String contrasena;
    private final String consulta;

    public EjecutarConsultaSQL(String host, int puerto, String baseDeDatos, String usuario, String contrasena, String consulta) {
        this.host = host;
        this.puerto = puerto;
        this.baseDeDatos = baseDeDatos;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.consulta = consulta;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String url = String.format("jdbc:mysql://%s:%d/%s", host, puerto, baseDeDatos);
        try (Connection connection = DriverManager.getConnection(url, usuario, contrasena);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(consulta)) {

            if (resultSet.next()) {
                String resultado = resultSet.getString(1);
                actor.remember("resultadoConsultaSQL", resultado); // Guardar el resultado en la memoria del actor
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static EjecutarConsultaSQL conParametros(String host, int puerto, String baseDeDatos, String usuario, String contrasena, String consulta) {
        return instrumented(EjecutarConsultaSQL.class, host, puerto, baseDeDatos, usuario, contrasena, consulta);
    }
}