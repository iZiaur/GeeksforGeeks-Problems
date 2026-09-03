/* Definition for Node
class Node
{
    int data;
    Node left;
    Node right;
    Node(int val)
    {
        this.data = val;
        left = null;
        right = null;
    }
}
*/

class Solution {
    
    public void isLeaf(Node root,ArrayList<Integer> arr){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            arr.add(root.data);
            return;
        }
        isLeaf(root.left,arr);
        isLeaf(root.right,arr);
    }
    
    public boolean findpath(Node root,Integer target,ArrayList<Integer> path){
        if(root==null){
            return false;
        }
        path.add(root.data);
        if(root.data==target){
            return true;
        }
        
        boolean left=findpath(root.left,target,path);
        boolean right=findpath(root.right,target,path);
        
        if(left||right){
            return true;
        }
        
        path.remove(path.size()-1);
        return false;
    }
    public ArrayList<ArrayList<Integer>> paths(Node root) {
        
        // code here
         ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
         if(root==null){
             return arr;
         }
        ArrayList<Integer> leaf=new ArrayList<>();
        isLeaf(root,leaf);
       
        for(int i=0;i<leaf.size();i++){
            ArrayList<Integer> pathfirst=new ArrayList<>();
            findpath(root,leaf.get(i),pathfirst);
            arr.add(pathfirst);
        }
        
        
        
       
        
        
        
        
        return arr;
    }
}