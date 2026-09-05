/* Structure of binary tree node
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}*/

class Solution {
    public Node markparent(Node root,HashMap<Node,Node> map,int target){
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        Node targetNode=null;
        while(!q.isEmpty()){
            Node curr=q.poll();
            if(curr.data==target){
                targetNode=curr;
            }
            if(curr.left!=null){
                map.put(curr.left,curr);
                q.add(curr.left);
            }
            if(curr.right!=null){
                map.put(curr.right,curr);
                q.add(curr.right);
            }
        }
        
        return targetNode;
    }
    
    public int minTime(Node root, int target) {
        // code here
    HashMap<Node,Node> parentmap=new HashMap<>();
    Node targetNode=markparent(root,parentmap,target);
    HashMap<Node,Boolean> visited=new HashMap<>();
    visited.put(targetNode,true);
    int counter=0;
    Queue<Node>q=new LinkedList<>();
    q.add(targetNode);
    while(!q.isEmpty()){
        int size=q.size();
        counter++;
        for(int i=0;i<size;i++){
            Node curr=q.poll();
            if(curr.left!=null && visited.get(curr.left)==null){
                q.add(curr.left);
                visited.put(curr.left,true);
            }
            if(curr.right!=null && visited.get(curr.right)==null){
                q.add(curr.right);
                visited.put(curr.right,true);
            }
            if(parentmap.get(curr)!=null && visited.get(parentmap.get(curr))==null){
                visited.put(parentmap.get(curr),true);
                q.add(parentmap.get(curr));
            }
        }
    }
    
    return counter-1;
        
    }
}