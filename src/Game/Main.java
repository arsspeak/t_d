package Game;

import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage)
    {
        Game game = new Game();

        Canvas cv = new Canvas();
        GraphicsContext gc;

        gc = cv.getGraphicsContext2D();
        game.drawEverything(gc);

        stage.show();
    }
}
