/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}
*/

class Solution {
    public int minValue(Node root) {
        // code here
        Node curr=root;
        if(curr==null){
            return 0;
        }
        int ans=Integer.MAX_VALUE;
        while(curr!=null){
            ans=Math.min(curr.data,ans);
            curr=curr.left;
            
        }
        
        return ans;
    }
}