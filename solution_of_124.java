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
    public int maxPathSum(TreeNode root) {
        int record = Integer.MIN_VALUE;
        if(root == null) return 0;
        queue.offer(root);
        while(queue.size() != 0){
            int leftTree = Integer.MIN_VALUE;
            int rightTree = Integer.MIN_VALUE;
            TreeNode curr = queue.poll();
            if(curr.left != null) {
                queue.offer(curr.left);
                leftTree = findPath(curr.left, curr.left.val, leftTree);    
            }
            if(curr.right != null) {
                queue.offer(curr.right);
                rightTree = findPath(curr.right, curr.right.val, rightTree);
            }
            /*
            System.out.print(leftTree);
            System.out.print(' ');
            System.out.print(rightTree);
            System.out.print(' ');
            System.out.print(curr.val);
            System.out.print(' ');
            */
            int now = getMaxNum(curr.val, leftTree, rightTree);
            //int now = Math.max(curr.val, Math.max(leftTree, Math.max(rightTree, Math.max(leftTree + curr.val,  Math.max(rightTree + curr.val, leftTree + curr.val + rightTree)))));
            //System.out.println(now);
            if(now > record) record = now;
        }
        return record;
    }
    private Queue<TreeNode> queue = new LinkedList<>();
    private int findPath(TreeNode root, int res, int subTreeMax){
        if(res > subTreeMax) subTreeMax = res;
        if(root.left != null){
            subTreeMax = findPath(root.left, res + root.left.val, subTreeMax);
        }
        if(root.right != null){
            subTreeMax = findPath(root.right, res + root.right.val, subTreeMax);
        }
        return subTreeMax;
    }
    private int getMaxNum(int nodeVal, int leftTree, int rightTree){

        if(leftTree == Integer.MIN_VALUE && rightTree == Integer.MIN_VALUE) return nodeVal;
        if(leftTree == Integer.MIN_VALUE) return Math.max(nodeVal, Math.max(rightTree, rightTree + nodeVal));
        if(rightTree == Integer.MIN_VALUE) return Math.max(nodeVal, Math.max(leftTree, leftTree + nodeVal));

        return Math.max(nodeVal, Math.max(leftTree, Math.max(rightTree, Math.max(leftTree + nodeVal,  Math.max(rightTree + nodeVal, leftTree + nodeVal + rightTree)))));
    }
}
