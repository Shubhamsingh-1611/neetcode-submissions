

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }
        
        // Process Root, then Left, then Right (Preorder)
        sb.append(root.val).append(",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // Convert the string array into a Queue for easy O(1) sequential consumption
        String[] nodesArray = data.split(",");
        Queue<String> nodesQueue = new LinkedList<>(Arrays.asList(nodesArray));
        return deserializeHelper(nodesQueue);
    }

    private TreeNode deserializeHelper(Queue<String> nodesQueue) {
        // Retrieve and remove the next value from the front of the queue
        String currentVal = nodesQueue.poll();
        
        // Base case: If it's our null marker, return null
        if (currentVal.equals("null")) {
            return null;
        }

        // Create the current root node
        TreeNode root = new TreeNode(Integer.parseInt(currentVal));
        
        // Recursively build Left and Right subtrees in the exact same preorder sequence
        root.left = deserializeHelper(nodesQueue);
        root.right = deserializeHelper(nodesQueue);

        return root;
    }
}
