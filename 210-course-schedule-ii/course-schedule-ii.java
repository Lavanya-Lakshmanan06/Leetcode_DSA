class Solution {
    public int[] findOrder(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            adj.get(edge[1]).add(edge[0]);
        }
        
        
        int[] ind = new int[V];
        for(int i = 0; i < V; i++){
            for(int n : adj.get(i)){
                ind[n]++;
            }
        }
        
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(ind[i] == 0){
                q.add(i);
            }
        }
        
        
        int[] arr = new int[V];
        int i = 0;
        
        while(!q.isEmpty()){
            int node = q.poll();
            arr[i++] = node;
            
            for(int neighbour : adj.get(node)){
                ind[neighbour]--;
                if(ind[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }
        
        
        if(i != V){
            return new int[0]; 
        }
        
        return arr;
    }
}