package com.example.fallingfood.Sprites;

import com.example.fallingfood.FallingFoodApplication;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Fruta extends ImageView {

    private Circle forma;
    private double velocidad;
    private double puntos;
    private Image imagen;
    private boolean recogida;
    private FoodType tipoFruta;

    //Constructor
    public Fruta(FoodType tipoFruta, double velocidad, double puntos, Image imagen,double radio) {
        this.forma = new Circle(radio);
        this.tipoFruta = tipoFruta;
        this.velocidad = velocidad;
        this.puntos = puntos;
        this.imagen = imagen;
        this.recogida = false;
        setImage(imagen);
    }

    public Fruta(double puntos, double velocidad) {
        this.forma = new Circle(20);
        forma.setTranslateY(-100);
        forma.setTranslateX((int)(Math.random() * 700 + 50));
        this.forma.setStrokeWidth(5);
        this.forma.setStroke(Color.BLACK);
        this.tipoFruta = randomFoodType();
        this.velocidad = velocidad;
        this.puntos = puntos;
        setImage();
        this.recogida = false;
        setImage(imagen);
    }

    //Getters y Setters
    public double getVelocidad() {
        return velocidad;
    }
    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }
    public double getPuntos() {
        return puntos;
    }
    public void setPuntos(double puntos) {
        this.puntos = puntos;
    }
    public Image getImagen() {
        return imagen;
    }
    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }
    public boolean isRecogida() {
        return recogida;
    }
    public void setRecogida(boolean recogida) {
        this.recogida = recogida;
    }
    public FoodType getTipoFruta() {
        return tipoFruta;
    }
    public void setTipoFruta(FoodType tipoFruta) {
        this.tipoFruta = tipoFruta;
    }

    public Circle getForma() {
        return forma;
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

    public void setImage() {
        switch (getTipoFruta()) {
            case CEREZA -> this.imagen = new Image(FallingFoodApplication.class.getResource("food/cereza.png").toExternalForm());
            case ENSALADA -> this.imagen = new Image(FallingFoodApplication.class.getResource("food/ensalada.png").toExternalForm());
            case FRESA -> this.imagen = new Image(FallingFoodApplication.class.getResource("food/fresa.png").toExternalForm());
            case JAMON -> this.imagen = new Image(FallingFoodApplication.class.getResource("food/jamon.png").toExternalForm());
            case PIZZA -> this.imagen = new Image(FallingFoodApplication.class.getResource("food/pizza.png").toExternalForm());
            case WRAP -> this.imagen = new Image(FallingFoodApplication.class.getResource("food/wrap.png").toExternalForm());
        }
    }

    //Método para actualizar la posición de la fruta
    public void moverFruta() {
        setY(getY() + velocidad);
    }
}