package com.crowfunder.car;

public class Position {
    float x;
    float y;
    public Position(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public Position() {
        this.x = 0;
        this.y = 0;
    }
}
