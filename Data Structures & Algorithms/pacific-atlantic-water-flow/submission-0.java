

public class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }

        int m = heights.length;
        int n = heights[0].length;

        // Matrices to track cells reachable from each ocean
        boolean[][] pacificReachable = new boolean[m][n];
        boolean[][] atlanticReachable = new boolean[m][n];

        // 1. Run DFS from the top and bottom rows
        for (int c = 0; c < n; c++) {
            dfs(0, c, heights, pacificReachable);         // Top row (Pacific)
            dfs(m - 1, c, heights, atlanticReachable);    // Bottom row (Atlantic)
        }

        // 2. Run DFS from the left and right columns
        for (int r = 0; r < m; r++) {
            dfs(r, 0, heights, pacificReachable);         // Left column (Pacific)
            dfs(r, n - 1, heights, atlanticReachable);    // Right column (Atlantic)
        }

        // 3. Collect cells that can reach both oceans
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (pacificReachable[r][c] && atlanticReachable[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(int r, int c, int[][] heights, boolean[][] reachable) {
        // Mark the current cell as visited/reachable from this ocean
        reachable[r][c] = true;

        int m = heights.length;
        int n = heights[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            // Check boundaries
            if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                // To move to the neighbor, it must NOT be visited yet, 
                // and its height must be >= the current cell's height (climbing up)
                if (!reachable[nr][nc] && heights[nr][nc] >= heights[r][c]) {
                    dfs(nr, nc, heights, reachable);
                }
            }
        }
    }
}