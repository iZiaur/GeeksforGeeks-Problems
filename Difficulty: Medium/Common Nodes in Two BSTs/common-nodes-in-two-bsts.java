/* Structure of a Binary Search Tree node
class Node {
  public int data;
  public Node left;
  public Node right;

  public Node(int val) {
      data = val;
      left = right = null;
  }
};
*/

class Solution {
    public void inorder(Node r1,ArrayList<Integer>arr1){
        if(r1==null){
            return;
        }
        inorder(r1.left,arr1);
        arr1.add(r1.data);
        inorder(r1.right,arr1);
    }
    public ArrayList<Integer> findCommon(Node r1, Node r2) {
        // code here
        ArrayList<Integer> arr1=new ArrayList<>();
        inorder(r1,arr1);
        ArrayList<Integer>arr2=new ArrayList<>();
        inorder(r2,arr2);
        ArrayList<Integer>arr3=new ArrayList<>();
        
       HashSet<Integer> set=new HashSet<>(arr1);
       for(int i=0;i<arr2.size();i++){
           if(set.contains(arr2.get(i)))    arr3.add(arr2.get(i));
       }
       
       return arr3;
    }
}