/* Structure for Tree Node
class Node {
    int data;
    Node left, right;

    // Constructor
    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
};
*/
class Solution {
    private int transform(Node root) {
        if (root == null) {
            return 0;
        }

        int leftSum = transform(root.left);
        int rightSum = transform(root.right);

        int oldVal = root.data;
        root.data = leftSum + rightSum;

        return oldVal + root.data;
    }
    public void toSumTree(Node root) {
        // code here
       transform(root);
    }
}