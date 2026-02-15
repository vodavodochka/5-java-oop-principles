package com.example.task04;

import java.time.temporal.ChronoUnit;

public class Task04Main {
    public static void main(String[] args) {
        Logger logger = new Logger("TestLogger");

        ConsoleHandler consoleHandler = new ConsoleHandler();
        logger.addHandler(consoleHandler);

        FileHandler fileHandler = new FileHandler("text.txt");
        logger.addHandler(fileHandler);

        MemoryHandler memoryHandler = new MemoryHandler(new ConsoleHandler(), 2);
        logger.addHandler(memoryHandler);

        //RotationFileHandler rotationFileHandler = new RotationFileHandler(ChronoUnit.HOURS);
        //logger.addHandler(rotationFileHandler);

        logger.debug("Debug test");
        logger.info("Info test");
        logger.warning("Warning test");
        logger.error("error test");


        logger.info("MemoryHandler test");
    }
}
