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
import java.util.Arrays;
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0) return null;
        if(inorder.length == 1) return new TreeNode(inorder[0]);
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        int i;
        for(i = 0;i < inorder.length;i++){
            if(inorder[i] == root.val) break;
        }
        int[] left_in = Arrays.copyOfRange(inorder, 0, i);
        int[] right_in = Arrays.copyOfRange(inorder, i+1, inorder.length);
        int[] left_post = Arrays.copyOfRange(postorder, 0, i);
        int[] right_post = Arrays.copyOfRange(postorder,i, postorder.length - 1);
        root.left = buildTree(left_in, left_post);
        root.right = buildTree(right_in, right_post);
        return root;
    }
}
