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
            return Math.round(p.x) == Math.round(this.x) && Math.round(p.y) == Math.round(this.y);
        }
        return false;
    }

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "Position [x=" + x + ", y=" + y + "]";
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

    public Position() {
        this.x = 0;
        this.y = 0;
    }
}
