package entity;

import lombok.Getter;

public enum Color {
    RED ("Красный"), GREEN("Зеленый");

    private String color;

    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}


