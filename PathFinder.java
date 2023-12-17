import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class PathFinder {
   
    private Tile food = new Tile(0, 0);
    private int tileSize;
    private int xVelocity = 0;
    private int yVelocity = 0;


    PathFinder(int tileSize){
        this.tileSize = tileSize;
    }

    public void MoveToBestTile(Tile food, Tile head){
        this.food = food;

        // Gets the neighbors of the head
        Neighbors neighbors = new Neighbors(head);
        Directions bestDirection = neighbors.CalculateHeuristics(food);

        System.out.println(bestDirection);
        if (bestDirection == Directions.LEFT && xVelocity != -1){
            xVelocity = -1;
            yVelocity = 0;
        } else if (bestDirection == Directions.RIGHT && xVelocity != 1){
            xVelocity = 1;
            yVelocity = 0;
        } else if (bestDirection == Directions.UP && yVelocity != -1){
            xVelocity = 0;
            yVelocity = -1;
        } else if (bestDirection == Directions.DOWN && yVelocity != 1){
            xVelocity = 0;
            yVelocity = 1;
        }

        head.x += xVelocity;
        head.y += yVelocity;

    }
}
 