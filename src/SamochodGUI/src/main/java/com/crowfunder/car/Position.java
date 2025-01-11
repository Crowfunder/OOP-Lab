package com.crowfunder.car;

public class Position {
    float x;
    float y;

    @Override
    public boolean equals(Object position) {
        if (position == null) {
            return false;
        }
        if (position instanceof Position) {
            Position p = (Position) position;
            return p.x == this.x && p.y == this.y;
        }
        return false;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

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
