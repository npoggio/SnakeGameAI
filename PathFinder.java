import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class PathFinder {
   
    private Tile food = new Tile(0, 0);
    private int tileSize;


    PathFinder(int tileSize){
        this.tileSize = tileSize;
    }

    public void MoveToBestTile(Tile food, Tile head){
        this.food = food;

        // Gets the neighbors of the head
        Neighbors neighbors = new Neighbors(head);
        
    }
}
