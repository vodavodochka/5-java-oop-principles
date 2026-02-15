package com.example.task04;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MemoryHandler implements MessageHandler{

    private ArrayList<String> buffer = new ArrayList<>();
    private MessageHandler handler;
    private int bufferLimit;

    public MemoryHandler(MessageHandler handler, int bufferLimit) {
        this.handler = handler;
        this.bufferLimit = bufferLimit;
    }

    @Override
    public void log(String message) {
        buffer.add(message);

        if (buffer.size() > bufferLimit) {
            send();
        }
    }

    public void send() {
        for (String message : buffer) {
            handler.log(message);
        }
        buffer.clear();
    }
}
