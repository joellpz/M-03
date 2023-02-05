package com.example.fallingfood;

import com.example.fallingfood.Sprites.Farmer;
import com.example.fallingfood.Sprites.Food;
import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FallingFoodController {
    private final List<Food> foods = new ArrayList<>();
    private final Farmer farmer;
    public static final Pane root = new Pane();
    private final VBox vBox = new VBox();

    private final Scene scene = new Scene(root, 800, 600, Color.SKYBLUE);
    private final Text pointsText = new Text();
    private int level = 1;
    private boolean started = false;

    AnimationTimer animationTimer;
    Button btnStart = new Button();
    Text levelText = new Text("Level " + level);

    public FallingFoodController() {
        this.farmer = new Farmer(5, new Image(Objects.requireNonNull(FallingFoodController.class.getResource("cesta.png")).toExternalForm()));
        farmer.setX(root.getWidth()/2);
        farmer.setY(root.getHeight()-90);
        inicializarGUI();
    }
    private void vBoxPropieties(){
        vBox.setAlignment(Pos.CENTER);
        levelText.setFont(Font.font( "Helvetica", FontWeight.BOLD, 16));
        vBox.getChildren().addAll(levelText, btnStart);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);
        vBox.translateXProperty().bind(root.widthProperty().subtract(vBox.widthProperty()).divide(2));
        vBox.translateYProperty().bind(root.heightProperty().subtract(vBox.heightProperty()).divide(2));
        btnStart.setText("START");
        btnStart.setFont(Font.font( "Helvetica", FontWeight.NORMAL, 16));
        btnStart.setPadding(new Insets(5,10,5,10));
    }

    private void inicializarGUI() {
        root.getChildren().add(farmer);

        root.setBackground(new Background(new BackgroundImage((new Image(Objects.requireNonNull(getClass().getResource("grass.png")).toExternalForm())), BackgroundRepeat.SPACE, BackgroundRepeat.NO_REPEAT, new BackgroundPosition(Side.RIGHT,0,false,Side.BOTTOM,0,false),  new BackgroundSize(100, 100, true, true, true, false))));
        vBoxPropieties();
        btnStart.setOnAction(event -> {
            started = true;
            jugar();
            vBox.setVisible(false);
        });
        pointsText.setText("Points: " + farmer.getScore());
        pointsText.setFont(Font.font( "Helvetica", FontWeight.BOLD, 24));
        pointsText.setFill(Color.WHITE);
        pointsText.setY(20);
        root.getChildren().addAll(vBox, pointsText);
    }

    private void newLevel(boolean failed){
        level++;
        if (failed){
            level=0;
            levelText.setText("Has Perdido! Has acumulado " + farmer.getScore() + " puntos.");
            farmer.setScore(0);
        }else{
            levelText.setText("Level " + level);
        }
        vBox.setVisible(true);
        btnStart.setOnAction(event -> {
            started = true;
            jugar();
            vBox.setVisible(false);
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
                    for (Food food : foods) {
                        food.moverFruta();
                        comprobarColisiones(food);
                    }
                    if (comprobarFinNivel()) {
                        animationTimer.stop();
                        newLevel(false);
                    }
                }
            }
        };
        animationTimer.start();

        scene.setOnKeyPressed(event -> farmer.moverFarmer(event.getCode()));
    }

    private boolean comprobarFinNivel() {
        for (Food food : foods) {
            if (food.getBoundsInParent().intersects(0, 0, scene.getWidth(), scene.getHeight())) {
                return false;
            }
        }
        return true;
    }

    private void agregarFrutas() {
        foods.clear();
        for (int i = 0; i < level; i++) {
            foods.add(new Food(10, level,false));
            foods.add(new Food(20, 1.2 * level,false));
            foods.add(new Food(20, 1.2 * level,true));
            foods.add(new Food(20, 1.5 * level,false));
        }
        root.getChildren().addAll(foods);
    }

    //Detectar si una fruta toca con el agricultor
    private void comprobarColisiones(Food food) {
        if (food.getBoundsInParent().intersects(farmer.getBoundsInParent()) && !food.isRecogida()) {
            if (food.isBomb()) {
                animationTimer.stop();
                newLevel(true);
                root.getChildren().removeAll(foods);
            }else{
                food.setVisible(false);
                food.setRecogida(true);
                farmer.plusScore(food.getPuntos());
                foods.remove(food);
            }
            pointsText.setText("Points: " + farmer.getScore());
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
