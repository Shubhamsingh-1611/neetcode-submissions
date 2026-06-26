

class Solution {

    public boolean dfs(int u, int n, ArrayList<Integer> graph[], boolean vis[], int parent) {
        vis[u] = true;
        for(int v : graph[u]) {
            if(!vis[v]) {
                if(dfs(v, n, graph, vis, u)) return true;
            } else if(v != parent) {
                return true; // Cycle detected
            }
        }
        return false;
    } 

    public boolean validTree(int n, int[][] edges) {
        // Optimization check: a tree with n nodes MUST have exactly n - 1 edges
        if (edges.length != n - 1) {
            return false;
        }

        ArrayList<Integer> graph[] = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int e[] : edges) {
            int u = e[0];
            int v = e[1];
            graph[u].add(v); 
            graph[v].add(u);
        }

        boolean vis[] = new boolean[n];
        
        // 1. If a cycle is detected starting from node 0, it's not a tree
        if (dfs(0, n, graph, vis, -1)) {
            return false;
        }

        // 2. Connectivity Check: Verify every single node was reached by the DFS
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                return false; // Graph is disconnected
            }
        }

        return true;
    }
}
