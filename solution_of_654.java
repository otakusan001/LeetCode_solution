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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length);
    }

    private TreeNode buildTree(int[] nums, int leftBorder, int rightBorder){
        //System.out.print(leftBorder);
        //System.out.println(rightBorder);
        if(rightBorder - leftBorder == 1) return new TreeNode(nums[leftBorder]);
        int maxNum = Integer.MIN_VALUE;
        int maxIndex = leftBorder;
        for(int i = leftBorder;i < rightBorder;i++){
            if(nums[i] > maxNum) {
                maxNum = nums[i];
                maxIndex = i;
            }
        }
        //System.out.println(maxIndex);
        TreeNode curr = new TreeNode(maxNum);
        if(maxIndex > leftBorder) curr.left = buildTree(nums, leftBorder, maxIndex);
        if(maxIndex < rightBorder - 1) curr.right = buildTree(nums, maxIndex + 1, rightBorder);
        return curr;
    }
}
