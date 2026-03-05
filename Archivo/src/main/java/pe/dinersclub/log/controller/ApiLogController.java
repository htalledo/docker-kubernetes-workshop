package pe.dinersclub.log.controller;

import org.springframework.web.bind.annotation.*;
import java.nio.file.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/log")
public class ApiLogController {

    @PostMapping("/send")
    public String send(@RequestBody LogRequest logRequest) {
        String message = logRequest.getMessage();
        if (message == null) {
            throw new IllegalArgumentException("El parámetro 'message' es obligatorio.");
        }

        try {
            Path dirPath = Paths.get("/tmp/data/log");
            if (!Files.exists(dirPath)) {
                Files.createDirectories(dirPath);
            }

            // Crea o abre un archivo txt con el nombre de la fecha actual
            String dateStr = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
            Path filePath = dirPath.resolve(dateStr + ".txt");

            // Agrega un salto de línea al final del mensaje para separar los logs
            String contentToWrite = message + System.lineSeparator();

            Files.writeString(filePath, contentToWrite, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            System.out.println("Log escrito exitosamente en: " + filePath.toString());
            return "Log escrito exitosamente en: " + filePath.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al escribir en el archivo: " + e.getMessage();
        }
    }
}

class LogRequest {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
