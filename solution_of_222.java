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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int left_hight = 0, right_hight = 0;
        TreeNode left_node = root.left, right_node = root.right;
        while(left_node != null){
            left_hight++;
            left_node = left_node.left;
        }
        while(right_node != null){
            right_hight++;
            right_node = right_node.right;
        }
        if(right_hight == left_hight) return (2 << right_hight) - 1;
        int left_count = countNodes(root.left);
        int right_count = countNodes(root.right);
        return (left_count+right_count+1);
    }
}
