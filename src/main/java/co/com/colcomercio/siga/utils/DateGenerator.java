package co.com.colcomercio.siga.utils;

import org.joda.time.DateTime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateGenerator {

    public static String getTodayDate(){
        LocalDate todayDate = LocalDate.now().plusDays(1);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String todayDateFormatted = todayDate.format(dateFormat);
        return todayDateFormatted;
    }

    public static String getDateFolderInvoice(){
        return new DateTime().toString("ddMMyyyy", new Locale("es","CO"));
    }

    public static String getExpirationDate(){
        return new DateTime().plusMonths(1).toLocalDate().toString("MMyy");
    }

}