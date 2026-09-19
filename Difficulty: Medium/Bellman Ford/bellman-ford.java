class Solution {
    static class EdgeInfo{
        int node;
        int wt;
        public EdgeInfo(int node,int wt){
            this.node=node;
            this.wt=wt;
        }
    }
    public ArrayList<Integer> bellmanFord(int V, int[][] edges, int src) {
        // code here
        
        ArrayList<ArrayList<EdgeInfo>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] edge:edges){
            int u=edge[0];
            int v=edge[1];
            int wt=edge[2];
            
            adj.get(u).add(new EdgeInfo(v,wt));
        }
        
        int [] dist=new int[V];
        for(int i=0;i<V;i++){
            if(i!=src){
                dist[i]=100000000;
            }
        }
        dist[src]=0;
        for(int k=0;k<V-1;k++){
        for(int i=0;i<V;i++){
            ArrayList<EdgeInfo> temp=adj.get(i);
            for(int j=0;j<temp.size();j++){
                EdgeInfo e=temp.get(j);
                int v=e.node;
                int wt=e.wt;
                
                if(dist[i]!=100000000 && dist[i]+wt<dist[v]){
                    dist[v]=dist[i]+wt;
                }
            }
        }
        }
        
        for(int i=0;i<V;i++){
            ArrayList<EdgeInfo> temp=adj.get(i);
            for(int j=0;j<temp.size();j++){
                EdgeInfo e=temp.get(j);
                int v=e.node;
                int wt=e.wt;
                
                if(dist[i]!=100000000 && dist[i]+wt<dist[v]){
                    ArrayList<Integer> neg=new ArrayList<>();
                    neg.add(-1);
                    return neg;
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
