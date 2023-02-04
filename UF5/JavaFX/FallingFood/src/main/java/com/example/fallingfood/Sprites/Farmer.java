package com.example.fallingfood.Sprites;

import javafx.scene.input.KeyCode;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Farmer extends ImageView {
    private Circle forma;
    private double velocidad;
    private Image imagen;

    //Constructor
    public Farmer(double velocidad, Image imagen) {
        this.forma = new Circle(20);
        this.velocidad = velocidad;
        this.imagen = imagen;
        setImage(imagen);
        forma.setStrokeWidth(2);
        forma.setStroke(Color.BLACK);
    }


    //Getters y Setters
    public double getVelocidad() {
        return velocidad;
    }
    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }
    public Image getImagen() {
        return imagen;
    }
    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }
    public Circle getForma() {
        return forma;
    }


    //Método para moverse con las flechas del teclado
    public void moverFarmer(KeyCode tecla) {
        if (tecla == KeyCode.LEFT) {
            setX(getX() - velocidad);
        } else if (tecla == KeyCode.RIGHT) {
            setX(getX() + velocidad);
        }
    }
}