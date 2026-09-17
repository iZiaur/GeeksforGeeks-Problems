class Solution {
    public void dfsutil(int start,ArrayList<ArrayList<Integer>> adj,boolean visited[],Stack<Integer> st){
        visited[start]=true;
        ArrayList<Integer>temp=adj.get(start);
        for(int i=0;i<temp.size();i++){
            if(!visited[temp.get(i)]){
                dfsutil(temp.get(i),adj,visited,st);
            }
        }
        
        st.push(start);
    }
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
    ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
    for(int i=0;i<V;i++){
        adj.add(new ArrayList<>());
    }
    
    for(int [] edge:edges){
        int u=edge[0];
        int v=edge[1];
        adj.get(u).add(v);
    }
    
    boolean visited[]=new boolean[V];
    Stack<Integer>st=new Stack<>();
    for(int i=0;i<V;i++){
        if(!visited[i]){
            dfsutil(i,adj,visited,st);
        }
    }
    
    ArrayList<Integer> ans=new ArrayList<>();
    while(!st.isEmpty()){
        ans.add(st.pop());
    }
    
    return ans;
    }
}