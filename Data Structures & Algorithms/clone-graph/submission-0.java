
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        
        // Map to keep track of original node -> cloned node mapping
        Map<Node, Node> visited = new HashMap<>();
        
        // Queue for BFS traversal
        Queue<Node> queue = new LinkedList<>();
        
        // Clone the root node and place it in the map
        visited.put(node, new Node(node.val));
        queue.add(node);
        
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            
            // Iterate through all the neighbors of the current node
            for (Node neighbor : curr.neighbors) {
                // If the neighbor hasn't been cloned yet
                if (!visited.containsKey(neighbor)) {
                    // Clone the neighbor and map it
                    visited.put(neighbor, new Node(neighbor.val));
                    // Add the original neighbor to queue to visit its neighbors later
                    queue.add(neighbor);
                }
                // Add the cloned neighbor to the cloned current node's neighbors list
                visited.get(curr).neighbors.add(visited.get(neighbor));
            }
        }
        
        return visited.get(node);
    }
}