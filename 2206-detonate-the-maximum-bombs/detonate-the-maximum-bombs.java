import java.util.*;

class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        
        // Step 1: Build graph
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        
        // Step 2: Create edges
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                
                long x1 = bombs[i][0], y1 = bombs[i][1], r1 = bombs[i][2];
                long x2 = bombs[j][0], y2 = bombs[j][1];
                
                long dx = x1 - x2;
                long dy = y1 - y2;
                
                // Check if j is within range of i
                if(dx * dx + dy * dy <= r1 * r1){
                    graph.get(i).add(j);
                }
            }
        }
        
        // Step 3: Try DFS from each bomb
        int max = 0;
        
        for(int i = 0; i < n; i++){
            boolean[] visited = new boolean[n];
            int count = dfs(i, graph, visited);
            max = Math.max(max, count);
        }
        
        return max;
    }
    
    private int dfs(int node, List<List<Integer>> graph, boolean[] visited){
        visited[node] = true;
        int count = 1;
        
        for(int neighbor : graph.get(node)){
            if(!visited[neighbor]){
                count += dfs(neighbor, graph, visited);
            }
        }
        
        return count;
    }
}