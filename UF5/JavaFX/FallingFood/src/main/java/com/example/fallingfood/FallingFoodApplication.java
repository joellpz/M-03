package com.example.fallingfood;


import com.example.fallingfood.Sprites.Fruta;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FallingFoodApplication extends Application {
    private FallingFoodController controlador;

    //Inicializa el juego
    @Override
    public void start(Stage stage) {
        controlador = new FallingFoodController();

        //Agrega las frutas y el agricultor al grupo de escena
        Group root = new Group();
        root.getChildren().add(controlador.getAgricultor());
        for (Fruta fruta : controlador.getFrutas()) {
            root.getChildren().add(fruta);
        }

        //Crea la escena y la muestra en la ventana
        Scene scene = new Scene(root, 800, 800, Color.SKYBLUE);
        stage.setScene(scene);
        stage.show();

        //Agrega el manejador de eventos para el teclado
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                controlador.getAgricultor().moverFarmer(event.getCode());
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}


