package com.kukhotskovolets.base;

public enum Sport {
    BIATHLON("Biathlon"),
    SKIING("Skiing"),
    SKIJUMPING("Ski Jumping");

    private String sport;

    Sport(String sport) {
        this.sport = sport;
    }

    @Override
    public String toString() {
        return sport;
    }
}
