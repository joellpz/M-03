package com.example.fallingfood.Sprites;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

public class Farmer extends ImageView {
    private double velocidad;
    private final Image imagen;

    private int score;

    //Constructor
    public Farmer(double velocidad, Image imagen) {
        this.velocidad = velocidad;
        this.imagen = imagen;
        setImage(this.imagen);
        this.score = 0;
    }

    //Getters y Setters
    public double getVelocidad() {
        return velocidad;
    }
    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    //Funcion que permite redcuir la HitBox a unicamente los pixeles de color. No acabo de funcionar pero por aqui la dejo.
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

    public void plusScore(int score) {
        this.score += score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    //    public Rectangle getBorderShape(){
//        border.setX(shape.getBoundsInParent().getMinX());
//        border.setY(shape.getBoundsInParent().getMinY());
//        border.setWidth(shape.getBoundsInParent().getWidth());
//        border.setHeight(shape.getBoundsInParent().getHeight());
//        border.setStroke(Color.BLACK);
//        border.setStrokeWidth(2);
//        return border;
//    }
//
//    public ImageView getBorderFarmer() {
//        shape.setX(getBoundsInParent().getMinX());
//        shape.setY(getBoundsInParent().getMinY());
//        return shape;
//    }

    //Método para moverse con las flechas del teclado
    public void moverFarmer(KeyCode tecla) {
        if (tecla == KeyCode.LEFT) {
            setX(getX() - velocidad);
        } else if (tecla == KeyCode.RIGHT) {
            setX(getX() + velocidad);
        }
    }
}