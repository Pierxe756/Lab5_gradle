package models;

public class Coordinates {
    private int x; //Значение поля должно быть больше -901
    private Float y; //Поле не может быть null

    public int getX() {
        return x;
    }

    public Float getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(Float y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
