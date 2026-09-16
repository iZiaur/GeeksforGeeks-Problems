class Solution {
    
    public boolean dfsutil(List<List<Integer>> adj,int start,boolean[] visited,boolean stack[]){
        visited[start]=true;
        stack[start]=true;
        List<Integer> temp=adj.get(start);
        for(int i=0;i<temp.size();i++){
            int neighbour=temp.get(i);
            if(stack[neighbour]){
                return true;
            }
            if(!visited[neighbour] && dfsutil(adj,neighbour,visited,stack)){
                return true;
            }
        }
        
        stack[start]=false;
        return false;
    }
    public boolean isCyclic(int V, int[][] edges) {
        
        // code here
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < V; i++) {
        adj.add(new ArrayList<>());
    }
    for (int[] edge : edges) {
        adj.get(edge[0]).add(edge[1]); 
    }
    boolean visited[]=new boolean[V];
    boolean stack[]=new boolean [V];
    
    for(int i=0;i<visited.length;i++){
        if(!visited[i]){
            if(dfsutil(adj,i,visited,stack)){
                return true;
            }
        }
    }
    
    return false;
    }
}