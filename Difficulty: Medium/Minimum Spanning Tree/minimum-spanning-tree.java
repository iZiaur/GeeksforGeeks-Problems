class Solution {
    static class Pair{
        int node;
        int cost;
        
        public Pair(int node,int cost){
            this.node=node;
            this.cost=cost;
        }
    }
    
    static class EdgeInfo{
        int node;
        int cost;
        
        public EdgeInfo(int node,int cost){
            this.node=node;
            this.cost=cost;
        }
        
    }
    public int spanningTree(int V, int[][] edges) {
        // code here
    boolean[] visited=new boolean[V];
    
    ArrayList<ArrayList<EdgeInfo>> adj=new ArrayList<>();
    for(int i=0;i<V;i++){
        adj.add(new ArrayList<>());
    }
    for(int [] edge:edges){
        int u=edge[0];
        int v=edge[1];
        int wt=edge[2];
        
        adj.get(u).add(new EdgeInfo(v,wt));
        adj.get(v).add(new EdgeInfo(u,wt));
    }
    
    PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.cost-b.cost);
    int ans=0;
    pq.add(new Pair(0,0));
    while(!pq.isEmpty()){
        Pair p=pq.poll();
        if(!visited[p.node]){
            visited[p.node]=true;
            ans+=p.cost;
            ArrayList<EdgeInfo>temp=adj.get(p.node);
            for(int i=0;i<temp.size();i++){
                EdgeInfo e=temp.get(i);
                int neighbour=e.node;
                int cost=e.cost;
                pq.add(new Pair(neighbour,cost));
                
            }
        }
    }
    
    
    return ans;
    }
}
