/* Definition for Node
class Node {
    int data;
    Node left;
    Node right;
    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
} */

class Solution {
    static int sumBT(Node root) {
        // code here
        if(root==null){
            return 0;
        }
        
        int lh=sumBT(root.left);
        int rh=sumBT(root.right);
        
        int sum=lh+rh+root.data;
        
        return sum;
    }
}