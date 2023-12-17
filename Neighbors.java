import java.awt.SystemTray;
import java.util.ArrayList;
import java.util.List;

public class Neighbors{

    List<Tile> neighbors = new ArrayList<>();
    List<Tile> body;
    Tile left;
    Tile right;
    Tile up;
    Tile down;

    Neighbors(Tile head, List<Tile> body){
        this.left = new Tile (head.x - 1, head.y);
        this.right = new Tile (head.x + 1, head.y);
        this.up = new Tile (head.x, head.y - 1);
        this.down = new Tile (head.x, head.y + 1);

        neighbors.add(left);
        neighbors.add(right);
        neighbors.add(up);
        neighbors.add(down);

        this.body = body;
    }

    public void PrintCoordinates(){
        System.out.println("Left: " + left.CoordinatesAsString());
        System.out.println("Right: " + right.CoordinatesAsString());
        System.out.println("Up: " + up.CoordinatesAsString());
        System.out.println("Down: " + down.CoordinatesAsString());
    }
    public void PrintHeuristics(){
        System.out.println("Left Heuristic: " + left.distanceToFood);
        System.out.println("Right Heuristic: " + right.distanceToFood);
        System.out.println("Up Heuristic: " + up.distanceToFood);
        System.out.println("Down Heuristic: " + down.distanceToFood);
    }

    public Directions CalculateHeuristics(Tile food){   
        // Manhatten heuristic: |x2 - x1| + |y2 - y1|
        for (Tile neighbor : neighbors){
            if (IsNeighborInSnakeBody(neighbor)){
                neighbor.distanceToFood = Tile.MAX_WEIGHT;
            }
            else {
                neighbor.distanceToFood = Math.abs(food.x - neighbor.x) +  Math.abs(food.y - neighbor.y);
            }
        } 

        // Set to arbitrary highest heuristic value
        int smallestHeuristic = Tile.MAX_WEIGHT;
        Directions bestDirection = Directions.LEFT;

        for (int i = 0; i < neighbors.size(); i++){
            if (neighbors.get(i).distanceToFood < smallestHeuristic){
                smallestHeuristic = neighbors.get(i).distanceToFood;
                
                switch (i) {
                    case 0:
                        bestDirection = Directions.LEFT;
                        break;
                    case 1:
                        bestDirection = Directions.RIGHT;
                        break;
                    case 2:
                        bestDirection = Directions.UP;
                        break;
                    case 3:
                        bestDirection = Directions.DOWN;
                        break;     
                    default:
                        break;
                }
            }
        }
        return bestDirection;
    }

    private boolean IsNeighborInSnakeBody(Tile neighbor){
        
        for (Tile bodySegment : body){
            if (neighbor.x == bodySegment.x && neighbor.y == bodySegment.y){
                return true;
            }
        }
        return false;
    }
}  