/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public void solve(Node root,int arr[],int k){
        if(root==null){
            return;
        }
        if(root.data<=k){
            arr[0]=root.data;
        }
        if(k>=root.data){
            solve(root.right,arr,k);
        }else{
            solve(root.left,arr,k);
        }
    }
    public int findMaxFork(Node root, int k) {
        // code here.
    if(root==null){
        return 0;
    }
    
    int arr[]={-1};
    
    solve(root,arr,k);
    
    return arr[0];
    
    
    
    
    }
}