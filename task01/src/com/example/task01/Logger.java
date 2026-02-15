package com.example.task01;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Logger {
    public enum Level {
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }

    private String name;
    private Level level = Level.DEBUG;

    private static ArrayList<Logger> loggers = new ArrayList<Logger>();


    public Logger (String name) {
        this.name = name;
    }

    public static Logger getLogger(String name) {
        for (Logger logger : loggers) {
            if (logger.name.equals(name)) {
                return logger;
            }
        }

        Logger logger = new Logger(name);
        loggers.add(logger);
        return logger;
    }

    public String getName() {
        return this.name;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return this.level;
    }

    private String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
        return dateFormat.format(new Date());
    }

    private String getCurrentTime() {
        SimpleDateFormat timeFormate = new SimpleDateFormat("HH:mm:ss");
        return timeFormate.format(new Date());
    }

    public void logMessage(Level level, String message) {
        if (level.ordinal() < this.level.ordinal()) {
            return;
        }

        String date = getCurrentDate();
        String time = getCurrentTime();

        String formatedMessage = String.format("[%s] %s %s %s - %s", level, date, time, this.name, message);
        System.out.println(formatedMessage);
    }

    public void debug(String message) {
        logMessage(Level.DEBUG, message);
    }

    public void debug(String template, Object... args) {
        String message = String.format(template, args);
        logMessage(Level.DEBUG, message);
    }

    public void info(String message) {
        logMessage(Level.INFO, message);
    }

    public void info(String template, Object... args) {
        String message = String.format(template, args);
        logMessage(Level.INFO, message);
    }

    public void warning(String message) {
        logMessage(Level.WARNING, message);
    }

    public void warning(String template, Object... args) {
        String message = String.format(template, args);
        logMessage(Level.WARNING, message);
    }

    public void error(String message) {
        logMessage(Level.ERROR, message);
    }

    public void error(String template, Object... args) {
        String message = String.format(template, args);
        logMessage(Level.ERROR, message);
    }

    public void log(Level level, String message) {
        logMessage(level, message);
    }

    public void debug(Level level, String template, Object... args) {
        String message = String.format(template, args);
        logMessage(level, message);
    }

}
