/* Structure of BST tree Node
class Node {
    public int data;
    public Node left;
    public Node right;
    public Node(int val) {
        data = val;
        left = right = null;
    }
};*/
class Solution {
    public void range(Node root,int low,int high,ArrayList<Integer>arr){
        if(root==null){
            return;
        }
        if(root.data>=low && root.data<=high){
            arr.add(root.data);
            range(root.left,low,high,arr);
            range(root.right,low,high,arr);
        }
        else if(root.data>low && root.data>high){
             range(root.left,low,high,arr);
        }else{
             range(root.right,low,high,arr);
        }
    }
    public ArrayList<Integer> nodesInRange(Node root, int low, int high) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        range(root,low,high,ans);
        Collections.sort(ans);
        return ans;
    }
}