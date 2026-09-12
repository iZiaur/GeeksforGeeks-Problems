/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        left = right = null;
    }
} */

class Solution {
    public void solve(Node root,int arr[],int k){
        if(root==null){
            return;
        }
        
        if(root.data>=k){
            arr[0]=root.data;
        }
        
        if(k<=root.data){
            solve(root.left,arr,k);
        }
        else{
            solve(root.right,arr,k);
        }
    }
    int findCeil(Node root, int x) {
        // code here
    if(root==null){
        return 0;
    }
    
    int arr[]={-1};
    solve(root,arr,x);
    
    return arr[0];
    }
}