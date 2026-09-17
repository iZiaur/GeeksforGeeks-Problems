class Solution {
   
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here using kahs algorithm
    ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
    for(int i=0;i<V;i++){
        adj.add(new ArrayList<>());
    }
    
    for(int [] edge:edges){
        int u=edge[0];
        int v=edge[1];
        adj.get(u).add(v);
    }
    
    int[] indegree=new int[V];
    for(int i=0;i<adj.size();i++){
        ArrayList<Integer>temp=adj.get(i);
        for(int j=0;j<temp.size();j++){
            int num=temp.get(j);
            indegree[num]++;
        }
    }
    
    Queue<Integer> q=new LinkedList<>();
    for(int i=0;i<indegree.length;i++){
        if(indegree[i]==0){
            q.add(i);
        }
    }
    ArrayList<Integer>ans=new ArrayList<>();
    while(!q.isEmpty()){
        Integer curr=q.remove();
        ans.add(curr);
        ArrayList<Integer>temp=adj.get(curr);
        for(int i=0;i<temp.size();i++){
            indegree[temp.get(i)]--;
            if(indegree[temp.get(i)]==0){
                q.add(temp.get(i));
            }
        }
    }
    
    return ans;
    }
}