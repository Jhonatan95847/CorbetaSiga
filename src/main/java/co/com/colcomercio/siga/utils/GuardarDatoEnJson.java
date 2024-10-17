package co.com.colcomercio.siga.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GuardarDatoEnJson {
    private static final Logger logger = LogManager.getLogger(GuardarDatoEnJson.class);

    // Método para guardar el dato capturado en un archivo JSON
    public static void guardarDatoEnJson(String clave, String valor, String rutaArchivo) {
        try {
            // Crear un ObjectMapper de Jackson
            ObjectMapper mapper = new ObjectMapper();

            // Crear un mapa para almacenar el dato (clave-valor)
            Map<String, String> datos = new HashMap<>();

            // Leer el archivo si ya existe para agregar el nuevo dato (si deseas preservar los datos anteriores)
            File archivoJson = new File(rutaArchivo);
            if (archivoJson.exists()) {
                datos = mapper.readValue(archivoJson, Map.class);
            }

            // Agregar el nuevo dato capturado
            datos.put(clave, valor);

            // Escribir el mapa actualizado en el archivo JSON
            mapper.writerWithDefaultPrettyPrinter().writeValue(archivoJson, datos);

            logger.info("Dato guardado exitosamente en el archivo JSON.");


        } catch (IOException e) {
            e.printStackTrace();  // Manejo de errores
        }
    }

    public static void main(String[] args) {
        // Capturar el dato desde la automatización
        String datoCapturado = "valorEjemplo";  // Suponiendo que este es el dato capturado
        String clave = "nombreDato";  // Puedes asignar una clave o ID para este dato

        // Ruta del archivo JSON donde se guardará el dato
        String rutaArchivoJson = "ruta/al/archivo.json";

        // Guardar el dato capturado en el archivo JSON
        guardarDatoEnJson(clave, datoCapturado, rutaArchivoJson);
    }
}
