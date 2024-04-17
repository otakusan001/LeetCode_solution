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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key){
            if(root.left == null && root.right == null) return null;
            if(root.left != null && root.right == null) return root.left;
            if(root.left == null && root.right != null) return root.right;
            if(root.left != null && root.right != null){
                TreeNode curr = root.right;
                while(curr.left != null ) curr = curr.left;
                curr.left = root.left;
                return root.right;
            }
        }
        if(key < root.val) root.left = deleteNode(root.left, key);
        if(key > root.val) root.right = deleteNode(root.right, key);
        return root;
    }
}
