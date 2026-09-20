class Solution {
    static int find(int x,int [] par){
        if(x==par[x]){
            return x;
        }
        return find(par[x],par);
    }
    
    static void union(int a,int b,int[] par,int [] rank){
        int parA=find(a,par);
        int parB=find(b,par);
        if(rank[parA]==rank[parB]){
            par[parB]=parA;
            rank[parA]++;
        }else if(rank[parA]<rank[parB]){
            par[parA]=parB;
        }else{
            par[parB]=parA;
        }
    }
    static int kruskalsMST(int V, int[][] edges) {
        // code here
        
    int[] par=new int[V];
    int [] rank=new int[V];
    for(int i=0;i<V;i++){
        par[i]=i;
    }
    Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));
    int ans=0;
    for(int i=0;i<edges.length;i++){
        int src=edges[i][0];
        int des=edges[i][1];
        int parA=find(src,par);
        int parB=find(des,par);
        if(parA!=parB){
            ans+=edges[i][2];
            union(src,des,par,rank);
        }
        
        
        
    }
    
    return ans;
    
    }
}
