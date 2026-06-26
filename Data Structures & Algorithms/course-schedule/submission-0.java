class Solution {
    public boolean canFinish(int numCourses, int[][] pre) {
        // Initialize the graph with numCourses, not pre.length
        ArrayList<Integer> graph[] = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // Track the incoming edges for each course
        int indegree[] = new int[numCourses];
        for(int ar[] : pre) {
            int course = ar[0];
            int prereq = ar[1];
            graph[prereq].add(course); // Edge from prereq to course
            indegree[course]++;
        }
        
        // Add all courses with no prerequisites to the queue
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }
        
        // Process the courses
        int visitedCourses = 0;
        while(!q.isEmpty()) {
            int u = q.poll();
            visitedCourses++;
            
            // Reduce indegree for all neighboring courses
            for(int v : graph[u]) {
                indegree[v]--;
                if(indegree[v] == 0) {
                    q.add(v);
                }
            }
        }
        
        // If we visited all courses, no cycle exists
        return visitedCourses == numCourses;
    }
}