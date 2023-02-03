package com.example.fallingfood;

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

public class HelloApplication extends Application {
   /* @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }*/

    @Override
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

        Timeline gameLoop = new Timeline();
        gameLoop.setCycleCount( Timeline.INDEFINITE );

        final long timeStart = System.currentTimeMillis();

        KeyFrame kf = new KeyFrame(
                Duration.seconds(0.017),                // 60 FPS
                new EventHandler<ActionEvent>()
                {
                    public void handle(ActionEvent ae)
                    {
                        double t = (System.currentTimeMillis() - timeStart) / 1000.0;

                        double x = 232 + 128 * Math.cos(t);
                        double y = 232 + 128 * Math.sin(t);

                        // Clear the canvas
                        gc.clearRect(0, 0, 512,512);

                        // background image clears canvas
                        gc.drawImage( space, 0, 0 );
                        gc.drawImage( earth, x, y );
                        gc.drawImage( sun, 196, 196 );
                    }
                });

        gameLoop.getKeyFrames().add( kf );
        gameLoop.play();

        theStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

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