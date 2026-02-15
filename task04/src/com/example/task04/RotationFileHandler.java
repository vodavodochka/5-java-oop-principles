package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler{

    private String filename;
    private ChronoUnit rotation;
    private LocalDateTime previosRotation;

    public RotationFileHandler(ChronoUnit rotation) {
        this.rotation = rotation;
        this.previosRotation = LocalDateTime.now();
        rotateFile();
    }

    private void rotateFile() {
        String time = previosRotation.format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH"));
        this.filename = time + ".txt";
    }


    @Override
    public void log(String message) {
        if (LocalDateTime.now().isAfter(previosRotation.plus(1, rotation))) {
            previosRotation = LocalDateTime.now();
            rotateFile();
        }

        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(message + "\n");
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
