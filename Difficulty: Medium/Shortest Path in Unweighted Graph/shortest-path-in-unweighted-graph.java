class Solution {
    static class Pair{
        int v;
        int wt;
        
        public Pair(int v,int wt){
            this.v=v;
            this.wt=wt;
        }
    }
    
    static class Edge{
        int node;
        int wt;
        
        public Edge(int node,int wt){
            this.node=node;
            this.wt=wt;
        }
    }
    public int shortestPath(int V, int[][] edges, int src, int dest) {
        // code here
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int [] edge:edges){
            int u=edge[0];
            int v=edge[1];
            int wt=1;
            adj.get(u).add(new Pair(v,wt));
            adj.get(v).add(new Pair(u,wt));
        }
        
        boolean visited[]=new boolean[V];
        int dist[]=new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        PriorityQueue<Edge>pq=new PriorityQueue<>((a,b)->a.wt-b.wt);
        pq.offer(new Edge(src,0));
        
        while(!pq.isEmpty()){
            Edge e=pq.poll();
            if(!visited[e.node]){
                visited[e.node]=true;
                ArrayList<Pair> temp=adj.get(e.node);
                for(int i=0;i<temp.size();i++){
                 Pair p=temp.get(i);
                 int v=p.v;
                 int wt=p.wt;
                 if(dist[e.node]+wt<dist[v]){
                     dist[v]=dist[e.node]+wt;
                     pq.offer(new Edge(v,dist[v]));
                 }
                }
            }
        }
        
        if(dist[dest]==Integer.MAX_VALUE) return -1;
        
        return dist[dest];
    }
}