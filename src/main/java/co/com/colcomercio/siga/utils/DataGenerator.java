package co.com.colcomercio.siga.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataGenerator {

    public static String DataGeneratorDate(){
        // Obtener la fecha y hora actuales
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Formatear la fecha y hora como una cadena
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String formattedDateTime = currentDateTime.format(formatter);

        // Generar un nombre de usuario
        return formattedDateTime;
    }

}
