/* Structure of a Binary Search Tree node
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
} */

class Solution {
    public void solvesuc(Node root,int key,Node []arr){
        if(root==null){
            return;
        }
        if(root.data>key){
            arr[0]=root;
            solvesuc(root.left,key,arr);
        }else{
            solvesuc(root.right,key,arr);
        }
        
    }
    
    public void solvepre(Node root,int key,Node[]arr){
        if(root==null) return;
        
        if(root.data<key){
            arr[0]=root;
            solvepre(root.right,key,arr);
        }else{
            solvepre(root.left,key,arr);
        }
    }
    public ArrayList<Node> findPreSuc(Node root, int key) {
        // code here
        ArrayList<Node>ans=new ArrayList<>();
        Node arr[]={null};
        solvepre(root,key,arr);
        
            ans.add(arr[0]);
       
        
        Node arr2[]={null};
        solvesuc(root,key,arr2);
        
            ans.add(arr2[0]);
    
        
        return ans;
        
    }
}