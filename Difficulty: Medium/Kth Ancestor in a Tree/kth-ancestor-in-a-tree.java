/* Definition for Node
class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int val) {
        data = val;
        left = right = null;
    }
};
*/

class Solution {
    public boolean getPath(Node root,int finder,ArrayList<Node> path){
        if(root==null){
            return false;
        }
        path.add(root);
        if(root.data==finder){
            return true;
        }
        
        boolean left=getPath(root.left,finder,path);
        boolean right=getPath(root.right,finder,path);
        
        if(left||right){
            return  true;
        }
        
        path.remove(path.size()-1);
        return false;
    }
    public int kthAncestor(Node root, int k, int node) {
        // code here
        ArrayList<Node> path=new ArrayList<>();
        getPath(root,node,path);
        
        
        int locatedindex=path.size()-1;
        
        if(k>=path.size()){
            return -1;
        }
        return path.get(locatedindex-k).data;
        
        
        
    }
}