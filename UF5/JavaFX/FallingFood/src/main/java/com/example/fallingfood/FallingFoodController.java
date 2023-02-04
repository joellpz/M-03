package com.example.fallingfood;

import com.example.fallingfood.Sprites.Farmer;
import com.example.fallingfood.Sprites.Fruta;
import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;

public class FallingFoodController {
    private Farmer agricultor;
    private List<Fruta> frutas = new ArrayList<>();
    private AnimationTimer animacion;

    public FallingFoodController() {
        //Crea el agricultor
        Image imagenAgricultor = new Image(FallingFoodController.class.getResource("cesta.png").toExternalForm());
        agricultor = new Farmer(5, imagenAgricultor);
        agricultor.setX(400);
        agricultor.setY(650);

        //Crea las frutas
        frutas.add(new Fruta(10,1));
        frutas.add(new Fruta(20, 2));

        //Inicia el bucle de animación
        animacion = new AnimationTimer() {
            @Override
            public void handle(long now) {
                //Mueve las frutas hacia abajo
                for (Fruta fruta : frutas) {
                    fruta.moverFruta();
                    detectarChoque(fruta);
                }
            }
        };
        animacion.start();
    }

    //Detectar si una fruta toca con el agricultor
    private void detectarChoque(Fruta fruta) {
        Circle shapeFruta = fruta.getForma();
        Circle shapeAgricultor = agricultor.getForma();
        if (shapeFruta.getBoundsInParent().intersects(shapeAgricultor.getBoundsInParent())) {
            shapeFruta.setVisible(false);
            System.out.println("CHO");
        }
    }


    public Farmer getAgricultor() {
        return agricultor;
    }

    public List<Fruta> getFrutas() {
        return frutas;
    }
}
