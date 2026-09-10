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
    public void inorder(Node root,ArrayList<Integer> arr){
        if(root==null){
            return;
        }
        inorder(root.left,arr);
        arr.add(root.data);
        inorder(root.right,arr);
    }
    public ArrayList<Integer> merge(Node r1, Node r2) {
        // code here
        ArrayList<Integer>arr=new ArrayList<>();
        inorder(r1,arr);
        inorder(r2,arr);
        Collections.sort(arr);
        return arr;
    }
}