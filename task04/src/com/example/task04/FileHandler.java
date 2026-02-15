package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements MessageHandler{

    private final String filename;

    public FileHandler(String filename) {
        this.filename = filename;
    }

    @Override
    public void log(String message) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(message + "\n");
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
