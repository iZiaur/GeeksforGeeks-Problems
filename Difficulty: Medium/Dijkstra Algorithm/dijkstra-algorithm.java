class Solution {
    
    static class Pair{
        int node;
        int path;
        
        public Pair(int node,int path){
            this.node=node;
            this.path=path;
        }
    }
    public ArrayList<Integer> dijkstra(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<Pair>> adj= new ArrayList<>();
        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int []edge :edges){
            int u=edge[0];
            int v=edge[1];
            int wt=edge[2];
            adj.get(u).add(new Pair(v,wt));
            adj.get(v).add(new Pair(u,wt));
        }
        
        int[] dist=new int[V];
        for(int i=0;i<V;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        
        boolean[] visited=new boolean[V];
        
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.path-b.path);
        pq.add(new Pair(src,0));
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            if(!visited[curr.node]){
                visited[curr.node]=true;
                ArrayList<Pair>temp=adj.get(curr.node);
                for(int i=0;i<temp.size();i++){
                    Pair neighbour=temp.get(i);
                    
                    int v=neighbour.node;
                    int wt=neighbour.path;
                    if(dist[curr.node]+wt<dist[v]){
                        dist[v]=dist[curr.node]+wt;
                        pq.add(new Pair(v,dist[v]));
                    }
                }
            }
        }
        
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<dist.length;i++){
            ans.add(dist[i]);
        }
        return ans;
    }
}