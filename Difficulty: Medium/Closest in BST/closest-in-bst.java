/* Structure of a Binary Search Tree node
class Node {
    int data;
    Node left, right;

    public Node(int val)
    {
        data = val;
        left = right = null;
    }
} */

class Solution {
    public void solve(Node root,int k,int arr[]){
        if(root==null){
            return;
        }
        
        arr[0]=Math.min(arr[0],Math.abs(root.data-k));
        
        solve(root.left,k,arr);
        solve(root.right,k,arr);
    }
    public int minDiff(Node root, int k) {
        // code here
        int arr[]={Integer.MAX_VALUE};
        solve(root,k,arr);
        return arr[0];
    }
}