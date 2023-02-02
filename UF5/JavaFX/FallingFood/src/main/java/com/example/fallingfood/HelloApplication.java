package com.example.fallingfood;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

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
        Image earth = new Image( "earth.png" );
        Image sun   = new Image( "sun.png" );
        Image space = new Image( "space.png" );
        final long startNanoTime = System.nanoTime();
        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;
                double x = 232 + 128 * Math.cos(t);
                double y = 232 + 128 * Math.sin(t);
                // background image clears canvas
                gc.drawImage( space, 0, 0 );
                gc.drawImage( earth, x, y );
                gc.drawImage( sun, 196, 196 );
            }
        }.start();
        theStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}



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