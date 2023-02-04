package com.example.fallingfood.Sprites;

import com.example.fallingfood.HelloApplication;
import javafx.scene.image.Image;

public class Food extends Sprite {

    private int points;
    private FoodType type;
    Image image;

    public Food(int points, FoodType type) {
        this.points = points;
        this.type = type;
        setImage();
    }

    public Food(int points) {
        this.points = points;
        this.type = randomFoodType();
        setImage();
    }

    private FoodType randomFoodType() {
        switch ((int) ((Math.random() * 6) + 1)) {
            case 1 -> {
                return FoodType.CEREZA;
            }
            case 2 -> {
                return FoodType.ENSALADA;
            }
            case 3 -> {
                return FoodType.FRESA;
            }
            case 4 -> {
                return FoodType.JAMON;
            }
            case 5 -> {
                return FoodType.PIZZA;
            }
            case 6 -> {
                return FoodType.WRAP;
            }
            default -> {
                return null;
            }
        }
    }

    public FoodType getType() {
        return type;
    }

    public void setImage() {
        System.out.println(Food.class.getResource("cereza.png").toExternalForm());
        switch (getType()) {
            case CEREZA -> this.image = new Image(Food.class.getResource("cereza.png").toExternalForm());
            case ENSALADA -> this.image = new Image(Food.class.getResource("ensalada.png").toExternalForm());
            case FRESA -> this.image = new Image(Food.class.getResource("fresa.png").toExternalForm());
            case JAMON -> this.image = new Image(Food.class.getResource("jamon.png").toExternalForm());
            case PIZZA -> this.image = new Image(Food.class.getResource("pizza.png").toExternalForm());
            case WRAP -> this.image = new Image(Food.class.getResource("wrap.png").toExternalForm());
        }
    }
}
