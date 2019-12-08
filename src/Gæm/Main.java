package Gæm;

import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.InputStream;

public class Main extends Application {
    @Override
    public void start(Stage stage)
    {
        Gæm game = new Gæm();
        Image bruh = new Image(InputStream.nullInputStream());


        Canvas cv = new Canvas();
        GraphicsContext gc;
        gc = cv.getGraphicsContext2D();
        
        stage.show();
    }
}
