package Map;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Arrays;

public class Map {

    public Image img;

    private boolean[][] Placable = new boolean[20][15];
    private boolean[][] Occupied = new boolean[20][15];


    public Map()
    {
        Arrays.fill(Placable, true);
        Arrays.fill(Occupied, false);
        for(int i=0; i<20; i++) Placable[i][2] = false;
        for(int i=0; i<20; i++) Placable[i][3] = false;
        for(int i=0; i<20; i++) Placable[i][4] = false;
        for(int i=0; i<2; i++) Placable[i][5] = false;
        for(int i=0; i<19; i++) Placable[i][6] = false;
        for(int i=0; i<19; i++) Placable[i][7] = false;
        for(int i=0; i<19; i++) Placable[i][8] = false;
        for(int i=16; i<19; i++) Placable[i][9] = false;
        for(int i=16; i<19; i++) Placable[i][10] = false;
        for(int i=0; i<19; i++) Placable[i][11] = false;
        for(int i=0; i<19; i++) Placable[i][12] = false;
        for(int i=0; i<19; i++) Placable[i][13] = false;
    }

    public boolean available(int X, int Y)
    {
        if(Placable[X][Y]==true && Occupied[X][Y]==false) return true;
        else return false;
    }

    public void occupy(int X, int Y)
    {
        Occupied[X][Y]=true;
    }

    public void release(int X, int Y)
    {
        Occupied[X][Y]=false;
    }

}
