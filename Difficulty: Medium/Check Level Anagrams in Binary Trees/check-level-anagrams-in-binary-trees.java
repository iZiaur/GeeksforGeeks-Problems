/* Structure of binary tree Node
class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    public void levelorder(Node root,ArrayList<ArrayList<Integer>> adj){
        if(root==null){
            return;
        }
        
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            ArrayList<Integer>temp=new ArrayList<>();
            for(int i=0;i<size;i++){
                Node curr=q.remove();
                temp.add(curr.data);
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            Collections.sort(temp);
            adj.add(temp);
        }
    }
    public boolean areAnagrams(Node root1, Node root2) {
        // code here
        
        ArrayList<ArrayList<Integer>> adj1=new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj2=new ArrayList<>();
        levelorder(root1,adj1);
        levelorder(root2,adj2);
        if(adj1.size()!=adj2.size()) return false;
        for(int i=0;i<adj1.size();i++){
            
            if(!adj1.get(i).equals(adj2.get(i))) return false;
        }
        return true;
    }
}
