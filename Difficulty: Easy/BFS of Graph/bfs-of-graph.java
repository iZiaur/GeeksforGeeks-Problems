class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
       ArrayList<Integer> arr=new ArrayList<>();
       Queue<Integer> q=new LinkedList<>();
       boolean visited[]=new boolean[adj.size()];
       
       q.add(0);
       while(!q.isEmpty()){
           Integer curr=q.remove();
           if(!visited[curr]){
               arr.add(curr);
               visited[curr]=true;
               ArrayList<Integer>temp=adj.get(curr);
               for(int i=0;i<temp.size();i++){
                   q.add(temp.get(i));
               }
           }
       }
       
       return arr;
    }
}