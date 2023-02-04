package com.example.fallingfood;

import java.util.ArrayList;
import java.util.List;

import com.example.fallingfood.Sprites.Farmer;
import com.example.fallingfood.Sprites.Fruta;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class FallingFoodController {
    private List<Fruta> frutas = new ArrayList<>();
    private Farmer farmer;
    private Group root = new Group();
    private HBox hbBoton = new HBox();

    private Scene scene = new Scene(root, 800, 600, Color.SKYBLUE);
    private Text pointsText = new Text();
    private int level = 1;
    private boolean started = false;

    AnimationTimer animationTimer;
    Button btnStart = new Button();
    Text levelText = new Text("Level " + level);

    public FallingFoodController() {
        this.farmer = new Farmer(5, new Image(FallingFoodController.class.getResource("cesta.png").toExternalForm()));
        farmer.setX(400);
        farmer.setY(450);
        inicializarGUI();
    }

    private void inicializarGUI() {
        root.getChildren().add(farmer);
        hbBoton.setAlignment(Pos.CENTER);
        hbBoton.getChildren().addAll(levelText, btnStart);
        hbBoton.setAlignment(Pos.CENTER);
        hbBoton.setSpacing(10);
        hbBoton.setLayoutX(scene.getWidth()/2 - hbBoton.getWidth());
        hbBoton.setLayoutY(scene.getHeight()/2 - hbBoton.getHeight());
        btnStart.setText("START");
        btnStart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                started = true;
                jugar();
                hbBoton.setVisible(false);
            }
        });
        pointsText.setText("Points: " + farmer.getScore());
        pointsText.setFont(Font.font( "Helvetica", FontWeight.BOLD, 24 ));
        pointsText.setStroke(Color.WHITE);
        pointsText.setY(20);
        root.getChildren().addAll(hbBoton, pointsText);
    }

    private void newLevel(){
        level++;
        levelText.setText("Level " + level);
        hbBoton.setVisible(true);
        btnStart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                started = true;
                jugar();
                hbBoton.setVisible(false);
            }
        });
    }

    public Scene getScene() {
        return scene;
    }

    public void jugar() {
        farmer.setVelocidad(farmer.getVelocidad()*1.25);
        agregarFrutas();
        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (started) {
                    for (Fruta fruta : frutas) {
                        fruta.moverFruta();
                        comprobarColisiones(fruta);
                    }
                    if (comprobarFinNivel()) {
                        //started = false;
                    }
                }
            }
        };
        animationTimer.start();

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                farmer.moverFarmer(event.getCode());
            }
        });
    }

    private boolean comprobarFinNivel() {
        for (Fruta fruta : frutas) {
            if (fruta.getBoundsInParent().intersects(0, 0, scene.getWidth(), scene.getHeight())) {
                return false;
            }
        }
        animationTimer.stop();
        newLevel();
        return true;
    }


    private void agregarFrutas() {
        frutas.clear();
        for (int i = 0; i < level; i++) {
            frutas.add(new Fruta(10, level));
            frutas.add(new Fruta(20, 1.2 * level));
            frutas.add(new Fruta(20, 1.5 * level));
        }
        root.getChildren().addAll(frutas);
    }

    //Detectar si una fruta toca con el agricultor
    private void comprobarColisiones(Fruta fruta) {
        if (fruta.getBoundsInParent().intersects(farmer.getBoundsInParent()) && !fruta.isRecogida()) {
            fruta.setVisible(false);
            fruta.setRecogida(true);
            farmer.plusScore(fruta.getPuntos());
            pointsText.setText("Points: " + farmer.getScore());
            frutas.remove(fruta);
        }
    }
}
/*
import com.example.fallingfood.Sprites.Farmer;
import com.example.fallingfood.Sprites.Fruta;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class FallingFoodController {
    private Farmer agricultor;
    private Text pointsText;
    private List<Fruta> frutas = new ArrayList<>();
    private AnimationTimer animacion;

    private int level;

    public FallingFoodController(Stage stage) {
        this.level = 0;

        //Crea el agricultor
        Image imagenAgricultor = new Image(FallingFoodController.class.getResource("cesta.png").toExternalForm());
        agricultor = new Farmer(5, imagenAgricultor);
        agricultor.setX(400);
        agricultor.setY(650);

        //Crea el Marcador
        pointsText = new Text();
        pointsText.setFont(Font.font( "Helvetica", FontWeight.BOLD, 24 ));
        pointsText.setStroke(Color.WHITE);
        pointsText.setY(20);
        pointsText.setText("Points: "+agricultor.getScore());

        //Crea las frutas
        Rectangle rectangle = new Rectangle();
        newLevel();

        //Inicia el bucle de animación
        animacion = new AnimationTimer() {
            @Override
            public void handle(long now) {
                //Mueve las frutas hacia abajo
                for (Fruta fruta : frutas) {

                    detectarChoque(fruta);
                    if (fruta.getLayoutY() > FallingFoodApplication.mainScene.getHeight()) frutas.remove(fruta);
                }
            }
        };
        animacion.start();
    }

    private void startGame(){
        Pane root = new Pane();
    }

    private void newLevel(){
        level++;
        frutas.clear();
        for (int i = 0; i < level; i++) {
            frutas.add(new Fruta(10, (level / 3)));
            frutas.add(new Fruta(20, 2*(level/3)));
            frutas.add(new Fruta(20, 2.5*(level/3)));
        }

    }

    //Detectar si una fruta toca con el agricultor
    private void detectarChoque(Fruta fruta) {
        if (fruta.getBoundsInParent().intersects(agricultor.getBoundsInParent()) && !fruta.isRecogida()) {
            fruta.setVisible(false);
            fruta.setRecogida(true);
            agricultor.plusScore(fruta.getPuntos());
            pointsText.setText("Points: "+agricultor.getScore());
            System.out.println(agricultor.getScore());
            System.out.println("CHO");
        }
    }



    public Farmer getAgricultor() {
        return agricultor;
    }

    public List<Fruta> getFrutas() {
        return frutas;
    }

    public Text getPointsText(){return pointsText;}
}
*/
