package com.example.fallingfood;

import com.example.fallingfood.Sprites.Farmer;
import com.example.fallingfood.Sprites.Fruta;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {
    private Farmer agricultor;
    private List<Fruta> frutas = new ArrayList<>();
    private AnimationTimer animacion;

    //Inicializa el juego
    @Override
    public void start(Stage stage) {
        //Crea el agricultor
        Image imagenAgricultor = new Image(HelloApplication.class.getResource("cesta.png").toExternalForm());
        agricultor = new Farmer(5, imagenAgricultor);
        agricultor.setX(400);
        agricultor.setY(700);

        //Crea las frutas
        Image imagenManzana = new Image(HelloApplication.class.getResource("food/fresa.png").toExternalForm());
        Image imagenBanana = new Image(HelloApplication.class.getResource("food/pizza.png").toExternalForm());
        //frutas.add(new Fruta(1, 2, 10, imagenManzana));
        //frutas.add(new Fruta(2, 3, 20, imagenBanana));

        //Agrega las frutas y el agricultor al grupo de escena
        Group root = new Group();
        root.getChildren().add(agricultor);
        for (Fruta fruta : frutas) {
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
                agricultor.moverFarmer(event.getCode());
            }
        });

        //Inicia el bucle de animación
        animacion = new AnimationTimer() {
            @Override
            public void handle(long now) {
                //Mueve las frutas hacia abajo
                for (Fruta fruta : frutas) {
                    fruta.moverFruta();
                }
            }
        };
        animacion.start();
    }

    //Lanza la aplicación
    public static void main(String[] args) {
        launch(args);
    }
}
//   /* @Override
//    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();
//    }*/
//
//    @Override
//    public void start(Stage theStage)
//    {
//        theStage.setTitle( "FallingFood" );
//
//        Group root = new Group();
//        Scene theScene = new Scene( root );
//        theStage.setScene( theScene );
//
//        Canvas canvas = new Canvas( 512, 512 );
//        root.getChildren().add( canvas );
//
//        GraphicsContext gc = canvas.getGraphicsContext2D();
//
//        Image earth = new Image( HelloApplication.class.getResource("cesta.png").toExternalForm() );
//        Image sun   = new Image( HelloApplication.class.getResource("cesta.png").toExternalForm() );
//        Image space = new Image( HelloApplication.class.getResource("cesta.png").toExternalForm() );
//
//        System.out.println(HelloApplication.class.getResource("cesta.png").toExternalForm());
//        Food food = new Food(100);
//        Food food1 = new Food(100);
//        Food food2 = new Food(100);
//        Food food3 = new Food(100);
//
//        Timeline gameLoop = new Timeline();
//        gameLoop.setCycleCount( Timeline.INDEFINITE );
//
//        final long timeStart = System.currentTimeMillis();
//
//        KeyFrame kf = new KeyFrame(
//                Duration.seconds(0.017),                // 60 FPS
//                new EventHandler<ActionEvent>()
//                {
//                    public void handle(ActionEvent ae)
//                    {
//                        double t = (System.currentTimeMillis() - timeStart) / 1000.0;
//
//                        double x = 232 + 128 * Math.cos(t);
//                        double y = 232 + 128 * Math.sin(t);
//
//                        // Clear the canvas
//                        gc.clearRect(0, 0, 512,512);
//
//                        // background image clears canvas
//                        gc.drawImage( food.getImage(), 0, 0 );
//                        gc.drawImage( food1.getImage(), x, y );
//                        gc.drawImage( food2.getImage(), 196, 196 );
//                    }
//                });
//
//        gameLoop.getKeyFrames().add( kf );
//        gameLoop.play();
//
//        theStage.show();
//    }
//
//    public static void main(String[] args) {
//        launch();
//    }
//}

    /*@Override
    public void start(Stage theStage)
    {
        theStage.setTitle( "Timeline Example" );
        Group root = new Group();
        Scene theScene = new Scene( root );
        theStage.setScene( theScene );
        Canvas canvas = new Canvas( 512, 512 );
        root.getChildren().add( canvas );
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Image earth = new Image( HelloApplication.class.getResource("cesta.png").toExternalForm() );
        Image sun   = new Image( HelloApplication.class.getResource("cesta.png").toExternalForm() );
        Image space = new Image( HelloApplication.class.getResource("cesta.png").toExternalForm() );
        final long startNanoTime = System.nanoTime();
        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;
                double x = 232 + 128 * 0.3;
                double y = 232 + 128 * (t*0.03);
                // background image clears canvas
                gc.drawImage( space, 0, 0 );
                gc.drawImage( earth, x, y );
                gc.drawImage( sun, 196, 196 );
            }
        }.start();
        theStage.show();
    }*/


// Detecta los botoncitos de las flechas.
/*@Override
    public void start(Stage theStage)
    {
        theStage.setTitle( "Keyboard Example" );
        Group root = new Group();
        Scene theScene = new Scene( root );
        theStage.setScene( theScene );
        Canvas canvas = new Canvas( 512 - 64, 256 );
        root.getChildren().add( canvas );
        ArrayList<String> input = new ArrayList<String>();
        theScene.setOnKeyPressed(
                new EventHandler<KeyEvent>()
                {
                    public void handle(KeyEvent e)
                    {
                        String code = e.getCode().toString();
                        // only add once... prevent duplicates
                        if ( !input.contains(code) )
                            input.add( code );
                    }
                });
        theScene.setOnKeyReleased(
                new EventHandler<KeyEvent>()
                {
                    public void handle(KeyEvent e)
                    {
                        String code = e.getCode().toString();
                        input.remove( code );
                    }
                });
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Image left = new Image(HelloApplication.class.getResource("left.png" ).toExternalForm());
        Image leftG = new Image(  HelloApplication.class.getResource("leftG.png").toExternalForm());
        Image right = new Image(  HelloApplication.class.getResource("right.png" ).toExternalForm());
        Image rightG = new Image(  HelloApplication.class.getResource("rightG.png").toExternalForm());
        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
                // Clear the canvas
                gc.clearRect(0, 0, 512,512);
                if (input.contains("LEFT"))
                    gc.drawImage( leftG, 64, 64 );
                else
                    gc.drawImage( left, 64, 64 );
                if (input.contains("RIGHT"))
                    gc.drawImage( rightG, 256, 64 );
                else
                    gc.drawImage( right, 256, 64 );
            }
        }.start();
        theStage.show();
    }*/