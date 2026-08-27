/* A binary tree node
class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public boolean getDist(Node root, int a,ArrayList<Node> path1){
        if(root==null){
            return false;
        }
        
        path1.add(root);
        if(root.data==a){
            return true;
        }
        
        boolean left=getDist(root.left,a,path1);
        boolean right=getDist(root.right,a,path1);
        if(left||right){
            return true;
        }
        
        path1.remove(path1.size()-1);
        return false;
    }
    public int findDist(Node root, int a, int b) {
        // code here
        ArrayList<Node> path1=new ArrayList<>();
        ArrayList<Node> path2=new ArrayList<>();
        
        getDist(root,a,path1);
        getDist(root,b,path2);
        
        int i=0;
        for(;i<path1.size() && i<path2.size();i++){
            if(path1.get(i)!=path2.get(i)){
                break;
            }
        }
        
        int cindex=i-1;
        int aindex=path1.size()-1;
        int bindex=path2.size()-1;
        int count=(aindex-cindex)+(bindex-cindex);
       
        
        return count;
        
    }
}