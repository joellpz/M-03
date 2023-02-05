package com.example.fallingfood;


import javafx.application.Application;
import javafx.stage.Stage;

public class FallingFoodApplication extends Application {
    //Inicializa el juego
    @Override
    public void start(Stage stage) {

        FallingFoodController controlador = new FallingFoodController();
        stage.setScene(controlador.getScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


