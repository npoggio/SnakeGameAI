import java.util.List;
import java.util.ArrayList;
public class GraphNode {
    
    public NodeState state;
    public List<GraphNode> neighbors;

    GraphNode(){
        this.state = NodeState.EMPTY;
        neighbors = new ArrayList<>();
    }
}
