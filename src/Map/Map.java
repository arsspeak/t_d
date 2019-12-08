package Map;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Map {
    Image img = new Image("map.png");

    public void draw(GraphicsContext gc)
    {
        gc.drawImage(img, 0, 0);
    }

    public boolean[][] Placable = new boolean[10][10]; // Quantize some coordinates then refer to this table
}
