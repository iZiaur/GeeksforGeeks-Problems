class Solution {
    
    
    public void dfs(int start,ArrayList<ArrayList<Integer>> adjnew, boolean visitednew[]){
        visitednew[start]=true;
        
        ArrayList<Integer>temp=adjnew.get(start);
        
        for(int i=0;i<temp.size();i++){
            if(!visitednew[temp.get(i)]){
                dfs(temp.get(i),adjnew,visitednew);
            }
        }
    }
    
    public void toposort(int start,ArrayList<ArrayList<Integer>> adj,boolean visited[],Stack<Integer>st){
        
        
        visited[start]=true;
        ArrayList<Integer>temp=adj.get(start);
        
        for(int i=0;i<temp.size();i++){
            if(!visited[temp.get(i)]){
                toposort(temp.get(i),adj,visited,st);
            }
        }
        
        st.push(start);
    }
    public int countSCC(int V, int[][] edges) {
        // code here
        // adj list
        
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
        }
        
        boolean visited[]=new boolean[V];
        Stack<Integer>st=new Stack<>();
        //toposort
        for(int i=0;i<V;i++){
            if(!visited[i]){
                toposort(i,adj,visited,st);
            }
        }
        
       // making a transpose graph;
        ArrayList<ArrayList<Integer>> adjnew=new ArrayList<>();
        for(int i=0;i<V;i++){
            adjnew.add(new ArrayList<>());
        }
        
        
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            adjnew.get(v).add(u);
        }
        
        boolean visitednew[]=new boolean[V];
        //popping element from stack and doing a dfs
        
        int count=0;
        
       while(!st.isEmpty()){
           int start=st.pop();
           if(!visitednew[start]){
               count++;
               dfs(start,adjnew,visitednew);
           }
       }
       
       return count;
        
       
       
    }
}