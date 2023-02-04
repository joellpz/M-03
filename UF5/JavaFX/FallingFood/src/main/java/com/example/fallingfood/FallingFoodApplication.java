package com.example.fallingfood;


import com.example.fallingfood.Sprites.Fruta;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class FallingFoodApplication extends Application {
    private FallingFoodController controlador;
    public static int width = 800;
    public static int height = 800;
    public static Scene mainScene;
    //Inicializa el juego
    @Override
    public void start(Stage stage) {

        //Agrega las frutas y el agricultor al grupo de escena
        controlador = new FallingFoodController();
        stage.setScene(controlador.getScene());
        stage.show();

        //Crea la escena y la muestra en la ventana
       /* mainScene = new Scene(root, width, height, Color.SKYBLUE);
        stage.setScene(mainScene);
        stage.show();

        //Agrega el manejador de eventos para el teclado
        mainScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                controlador.getAgricultor().moverFarmer(event.getCode());
            }
        });*/
    }

    public static void main(String[] args) {
        launch(args);
    }
}


