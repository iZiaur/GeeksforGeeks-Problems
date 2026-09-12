/*
Definition for Node
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
    public int inOrderSuccessor(Node root, Node k) {
        // code here
        Node suc=null;
        
        while(root!=null){
            
        
        if(root.data<=k.data){
            root=root.right;
        }else{
            suc=root;
            root=root.left;
        }
        }
        
        if(suc==null) return -1;
        
        return suc.data;
    }
}