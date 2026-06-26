

class Solution {
    
    // Helper DFS to traverse and mark all nodes in the current component
    private void dfs(int u, ArrayList<Integer> graph[], boolean vis[]) {
        vis[u] = true;
        for (int v : graph[u]) {
            if (!vis[v]) {
                dfs(v, graph, vis);
            }
        }
    }

    public int countComponents(int n, int[][] edges) {
        // 1. Build the adjacency list for the undirected graph
        ArrayList<Integer> graph[] = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int e[] : edges) {
            int u = e[0];
            int v = e[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        // 2. Track visited nodes and count components
        boolean vis[] = new boolean[n];
        int componentCount = 0;

        // 3. Iterate through every node
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                componentCount++;      // Found a new component
                dfs(i, graph, vis);    // Mark all nodes belonging to this component
            }
        }

        return componentCount;
    }
}
