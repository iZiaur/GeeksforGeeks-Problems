class Solution {
    
    public void bfsutil(int start,List<List<Integer>> adj,boolean [] visited){
        Queue<Integer>q=new LinkedList<>();
        q.offer(start);
        visited[start]=true;
        while(!q.isEmpty()){
            Integer curr=q.remove();
            List<Integer> temp=adj.get(curr);
            for(int i=0;i<temp.size();i++){
                if(!visited[temp.get(i)]){
                    visited[temp.get(i)]=true;
                    q.add(temp.get(i));
                }
            }
        }
    }
    int countConnected(int V, ArrayList<ArrayList<Integer>> edges) {
        // code here
    boolean visited[]=new boolean[V];
    List<List<Integer>> adj=new ArrayList<>();
    for(int i=0;i<V;i++){
        adj.add(new ArrayList<>());
    }
    for(ArrayList<Integer> edge:edges){
        int u=edge.get(0);
        int v=edge.get(1);
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    int ans=0;
    for(int i=0;i<V;i++){
        if(!visited[i]){
            ans++;
            bfsutil(i,adj,visited);
        }
    }
    
    
    return ans;
    }
}