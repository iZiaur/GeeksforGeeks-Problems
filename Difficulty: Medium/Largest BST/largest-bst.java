/* Structure of a Binary Search Tree node
class Node {
    int data;
    Node left, right;
    public Node(int d) {
     data = d;
     left = right = null;
   }
} */

class Solution {
    
    class Info{
        boolean isBST;
        int size;
        int min;
        int max;
        public Info(boolean isBST,int size,int min,int max){
            this.isBST=isBST;
            this.size=size;
            this.min=min;
            this.max=max;
        }
    }
    
    public Info solve(Node root){
        if(root==null){
            return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        
        Info left=solve(root.left);
        Info right=solve(root.right);
        
       if (left.isBST && right.isBST && root.data > left.max && root.data < right.min) {
            int currentSize = left.size + right.size + 1;
            int currentMin = Math.min(root.data, left.min);
            int currentMax = Math.max(root.data, right.max);

            return new Info(true, currentSize, currentMin, currentMax);
        }
        
        return new Info(false,Math.max(left.size,right.size),0,0);
    
    
    }
    
    public int largestBst(Node root) {
        // code here
        
        return solve(root).size;
    
    }
}