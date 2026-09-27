class Solution {
    static int time=0;
    
    public static void dfsutil(int curr,int parent, List<List<Integer>> adj,int[]dt,int[]low,boolean visited[], HashSet<Integer>ans){
        
        visited[curr]=true;
        dt[curr]=low[curr]=++time;
        int children=0;
        List<Integer>temp=adj.get(curr);
        
        for(int i=0;i<temp.size();i++){
            int neighbour=temp.get(i);
            
            if(neighbour==parent) continue;
            
            else if(visited[neighbour]){
                low[curr]=Math.min(low[curr],dt[neighbour]);
            }else{
                dfsutil(neighbour,curr,adj,dt,low,visited,ans);
                low[curr]=Math.min(low[curr],low[neighbour]);
                if(parent!=-1 && dt[curr]<=low[neighbour]){
                    ans.add(curr);
                }
                children++;
            }
            if(parent==-1 && children>1){
                ans.add(curr);
            }
        }
    }
    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        boolean visited[]=new boolean[V];
        int dt[]=new int[V];
        int low[]=new int[V];
        HashSet<Integer>ans=new HashSet<>();
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfsutil(i,-1,adj,dt,low,visited,ans);
            }
        }
        ArrayList<Integer> list=new ArrayList<>();
        for(Integer e:ans){
            list.add(e);
        }
        if(ans.size()==0){
            list.add(-1);
            return list;
        }
        
        // for(Integer e:ans){
        //     list.add(e);
        // }
        return list;
    }
}