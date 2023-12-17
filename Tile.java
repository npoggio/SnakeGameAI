
public class Tile {
        int x;
        int y;
        int distanceToFood;

        Tile(int x, int y) {
            this.x = x;
            this.y = y;
            distanceToFood = 0;
        }

        public String CoordinatesAsString(){
           return x + ", " + y;
        }
}  