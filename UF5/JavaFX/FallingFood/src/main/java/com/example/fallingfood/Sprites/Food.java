package com.example.fallingfood.Sprites;

public class Food extends Sprite{
    private int points;
    private FoodType type;

    public Food(int points, FoodType type) {
        this.points = points;
        this.type = type;
    }
}
