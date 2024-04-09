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
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(val > root.val){
            TreeNode curr = new TreeNode(val);
            curr.left = root;
            return curr;
        }
        insertNode(root.right, root, val);
        return root;
    }
    private void insertNode(TreeNode curr, TreeNode previous, int val){
        if(curr == null) {
            previous.right = new TreeNode(val);
            return;
        }
        if(val > curr.val){
            TreeNode temp = new TreeNode(val);
            temp.left = curr;
            previous.right = temp;
            return;
        }
        insertNode(curr.right, curr, val);
        return;
    }
}
