/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;

    }
}
*/

class Solution {
    class Info{
        Node node;
        int hd;
        
        public Info(Node node, int hd){
            this.node=node;
            this.hd=hd;
        }
    }
    public ArrayList<Integer> bottomView(Node root) {
        // code here
        
        Queue<Info> q=new LinkedList<>();
        Map<Integer,Integer> map=new TreeMap<>();
        q.add(new Info(root,0));
        q.add(null);
        
        while(!q.isEmpty()){
            Info curr=q.remove();
            if(curr==null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                    continue;
                }
            }
            map.put(curr.hd,curr.node.data);
            if(curr.node.left!=null){
                q.add(new Info(curr.node.left,curr.hd-1));
            }
            if(curr.node.right!=null){
                q.add(new Info(curr.node.right,curr.hd+1));
            }
        }
        
        ArrayList<Integer> arr=new ArrayList<>();
        for(Integer i:map.values()){
            arr.add(i);
        }
        
        return arr;
        
    }
}