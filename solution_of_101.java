/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private boolean Symmetric(TreeNode right, TreeNode left){
        if(left == null && right != null) return false;
        else if(left != null && right == null) return false;
        else if(left == null && right == null) return true;
        else if(left.val != right.val) return false;
        else{
            boolean Right = Symmetric(right.right, left.left);
            boolean Left = Symmetric(right.left, left.right);
            return (Right && Left);
        }
    }
    public boolean isSymmetric(TreeNode root) {
        return Symmetric(root.right, root.left);
    }
}
