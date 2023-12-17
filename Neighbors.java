public class Neighbors{
    Tile left;
    Tile right;
    Tile up;
    Tile down;

    Neighbors(Tile head){
        this.left = new Tile (head.x - 1, head.y);
        this.right = new Tile (head.x + 1, head.y);
        this.up = new Tile (head.x, head.y - 1);
        this.down = new Tile (head.x, head.y + 1);
    }

    public void PrintCoordinates(){
        System.out.println("Left: " + left.x + ", " + left.y);
        System.out.println("Right: " + right.x + ", " + right.y);
        System.out.println("Up: " + up.x + ", " + up.y);
        System.out.println("Down: " + down.x + ", " + down.y);
    }
    public void PrintHeuristics(){
        System.out.println("Left: " + left.distanceToFood);
        System.out.println("Right: " + right.distanceToFood);
        System.out.println("Up: " + up.distanceToFood);
        System.out.println("Down: " + down.distanceToFood);
    }

    public void CalculateHeuristics(Tile food){
         
        // Manhatten heuristic: |x2 - x1| + |y2 - y1|
        left.distanceToFood = Math.abs(food.x - left.x) +  Math.abs(food.y - left.y);
        right.distanceToFood = Math.abs(food.x - right.x) +  Math.abs(food.y - right.y);
        up.distanceToFood = Math.abs(food.x - up.x) +  Math.abs(food.y - up.y);
        down.distanceToFood = Math.abs(food.x - down .x) +  Math.abs(food.y - down.y);
    }
}