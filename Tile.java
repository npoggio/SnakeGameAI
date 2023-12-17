
public class Tile {

        public static final int MAX_WEIGHT = 1000000;

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