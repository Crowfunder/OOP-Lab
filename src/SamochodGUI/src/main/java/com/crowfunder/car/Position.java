package com.crowfunder.car;

import static java.lang.Math.pow;

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
            int radius = 10;
            return pow(p.x-this.x, 2) + pow(p.y-this.y, 2) < pow(radius,2);
        }
        return false;
    }

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void setX(float x) {
        this.x = x;
    }
    public void setY(float y) {
        this.y = y;
    }

    public void posEqualize() {
        x = Math.round(this.x);
        y = Math.round(this.y);
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
