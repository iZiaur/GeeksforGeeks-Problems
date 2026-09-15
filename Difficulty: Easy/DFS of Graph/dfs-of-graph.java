class Solution {
    
    public void dfs(int startnode,ArrayList<ArrayList<Integer>> adj,boolean [] visited,ArrayList<Integer> ans){
        
        visited[startnode]=true;
        ans.add(startnode);
        
        ArrayList<Integer> temp=adj.get(startnode);
        for(int i=0;i<temp.size();i++){
            if(!visited[temp.get(i)]){
                dfs(temp.get(i),adj,visited,ans);
            }
        }
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
    boolean visited[]=new boolean[adj.size()];
    
    ArrayList<Integer>ans=new ArrayList<>();
    
    dfs(0,adj,visited,ans);
    
    return  ans;
    }
}