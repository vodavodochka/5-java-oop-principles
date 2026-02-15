package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {
        Logger logger = new Logger("test");
        logger.setLevel(Logger.Level.ERROR);
        logger.logMessage(Logger.Level.ERROR, "asdddasasdd");
    }
}
