class Solution {
    
    public boolean dfs(List<List<Integer>> adj,boolean [] visited,int curr,int parent){
        
        visited[curr]=true;
        
        List<Integer> temp=adj.get(curr);
        
        for(int i=0;i<temp.size();i++){
            int neighbour=temp.get(i);
            if(!visited[neighbour]){
                if(dfs(adj,visited,neighbour,curr)){
                    return true;
                }
            }
            else if(visited[neighbour] && neighbour!=parent){
                return true;
            }
        }
        
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
    List<List<Integer>> adj=new ArrayList<>();
    for(int i=0;i<V;i++){
        adj.add(new ArrayList<>());
    }
    
    for(int[] edge:edges){
        int u=edge[0];
        int v=edge[1];
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    
    boolean visited[]=new boolean[V];
    
    for(int i=0;i<V;i++){
        if(!visited[i]){
            
            if(dfs(adj,visited,i,-1)) return true;
        }
    }
    
    return false;
    }
}