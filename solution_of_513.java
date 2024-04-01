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
    int depth = Integer.MIN_VALUE,curr_depth;
    int result;
    public int findBottomLeftValue(TreeNode root) {
        //if(root == null) return null;
        if(root.left == null && root.right == null) {
            if(depth < curr_depth){
                result = root.val;
                depth = curr_depth;
            }
        }
        if(root.left != null) {
            curr_depth++;
            findBottomLeftValue(root.left);
            curr_depth--;
        }
        if(root.right != null) {
            curr_depth++;
            findBottomLeftValue(root.right);
            curr_depth--;
        }
        return result;
    }
}`
