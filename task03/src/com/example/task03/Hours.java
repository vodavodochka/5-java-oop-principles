package com.example.task03;

import java.sql.Time;

public class Hours implements TimeUnit {

    private long amount;

    public Hours(long amount) {
        this.amount = amount;
    }

    @Override
    public long toMillis() {
        return Math.round(amount * 60 * 60 * 10000);
    }

    @Override
    public long toSeconds() {
        return Math.round(amount * 60 * 60);
    }

    @Override
    public long toMinutes() {
        return Math.round(amount * 60);
    }

    @Override
    public long toHours() {
        return amount;
    }
}
