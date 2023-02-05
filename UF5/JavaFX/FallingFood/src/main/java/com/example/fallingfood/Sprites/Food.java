package com.example.fallingfood.Sprites;

import com.example.fallingfood.FallingFoodApplication;
import com.example.fallingfood.FallingFoodController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Food extends ImageView {

    private final double velocidad;
    private final int puntos;
    private Image imagen;
    private final FoodType tipoFruta;

    private boolean recogida;
    private boolean isBomb;

    public Food(int puntos, double velocidad, boolean isBomb) {
        this.tipoFruta = randomFoodType();
        this.velocidad = velocidad;
        this.puntos = puntos;
        this.isBomb = isBomb;
        if (isBomb){
            setImage(new Image(Objects.requireNonNull(FallingFoodApplication.class.getResource("food/bomb.png")).toExternalForm()));
        }else{
            setImageType();
            setImage(imagen);
        }
        setX(Math.random()* FallingFoodController.root.getWidth()-20);
        this.recogida = false;
    }

    public ImageView makeHitbox(){
        int width = (int) imagen.getWidth();
        int height = (int) imagen.getHeight();

        WritableImage wImage = new WritableImage(width, height);
        PixelReader reader = imagen.getPixelReader();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color color = reader.getColor(x, y);
                if (color.getOpacity() > 0) {
                    wImage.getPixelWriter().setColor(x, y, Color.WHITE);
                }
            }
        }
        return new ImageView(wImage);
    }

    //Getters y Setters


    public boolean isBomb() {
        return isBomb;
    }

    public int getPuntos() {
        return puntos;
    }

    public FoodType getTipoFruta() {
        return tipoFruta;
    }

    public void setRecogida(boolean recogida) {
        this.recogida = recogida;
    }

    public boolean isRecogida() {
        return recogida;
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

    public void setImageType() {
        switch (getTipoFruta()) {
            case CEREZA -> this.imagen = new Image(Objects.requireNonNull(FallingFoodApplication.class.getResource("food/cereza.png")).toExternalForm());
            case ENSALADA -> this.imagen = new Image(Objects.requireNonNull(FallingFoodApplication.class.getResource("food/ensalada.png")).toExternalForm());
            case FRESA -> this.imagen = new Image(Objects.requireNonNull(FallingFoodApplication.class.getResource("food/fresa.png")).toExternalForm());
            case JAMON -> this.imagen = new Image(Objects.requireNonNull(FallingFoodApplication.class.getResource("food/jamon.png")).toExternalForm());
            case PIZZA -> this.imagen = new Image(Objects.requireNonNull(FallingFoodApplication.class.getResource("food/pizza.png")).toExternalForm());
            case WRAP -> this.imagen = new Image(Objects.requireNonNull(FallingFoodApplication.class.getResource("food/wrap.png")).toExternalForm());
        }
    }

    //Método para actualizar la posición de la fruta
    public void moverFruta() {
        setY(getY() + velocidad);
    }
}