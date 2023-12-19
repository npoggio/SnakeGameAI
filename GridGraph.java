public class GridGraph {
    
    private int rows;
    private int cols;
    GraphNode[][] grid;

    GridGraph(){

    }

    public void InitializeGrid(int rows, int cols){
        
        this.rows = rows;
        this.cols = cols;

        // Initialize all graph nodes
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                grid[i][j] = new GraphNode();
            }
        }

        // Connect nodes to their neighbors
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
            
                // If a node has another node above, add it to neighbors list
                if (i > 0){
                    grid[i][j].neighbors.add(grid[i - 1][j]);
                }
                // if a node has another node below it, add it to the neighbors list
                if (i < rows - 1){
                    grid[i][j].neighbors.add(grid[i + 1][j]);
                }
                // if a node has another node to its left, add it to the neighbors list
                if (j > 0) {
                    grid[i][j].neighbors.add(grid[i][j - 1]);
                }
                // if a node has another node to its right, add it to the neighbors list
                if (j < cols - 1) {
                    grid[i][j].neighbors.add(grid[i][j + 1]);
                }

            }
        }
    }
}
