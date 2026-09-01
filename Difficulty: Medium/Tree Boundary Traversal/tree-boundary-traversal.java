/* Node Structure
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {
    public static boolean isLeaf(Node root){
        return root.left==null && root.right==null;
    }
    public static void addleft(Node root,ArrayList<Integer>res){
        Node curr=root.left;
        while(curr!=null){
            
        
        if(!isLeaf(curr)){
            res.add(curr.data);
        }
        if(curr.left!=null){
            curr=curr.left;
        }else{
            curr=curr.right;
        }
        }
    }
    
    public static void addleaf(Node root,ArrayList<Integer> res){
        if(isLeaf(root)){
            res.add(root.data);
            return;
        }
        if(root.left!=null){
            addleaf(root.left,res);
        }
        if(root.right!=null){
            addleaf(root.right,res);
        }
    }
    
    public static void addRight(Node root,ArrayList<Integer> res){
        ArrayList<Integer>temp=new ArrayList<>();
        Node curr=root.right;
        while(curr!=null){
            
        
        if(!isLeaf(curr)){
            temp.add(curr.data);
        }
        if(curr.right!=null){
            curr=curr.right;
        }else{
            curr=curr.left;
        }
        }
        Collections.reverse(temp);
        for(int i=0;i<temp.size();i++){
            res.add(temp.get(i));
        }
    }
    public ArrayList<Integer> boundaryTraversal(Node root) {
        // code here
        ArrayList<Integer> arr=new ArrayList<>();
        if(root==null){
            return arr;
            
        }
        
        if(!isLeaf(root)){
            arr.add(root.data);
        }
        addleft(root,arr);
        addleaf(root,arr);
        addRight(root,arr);
        return arr;
    }
}