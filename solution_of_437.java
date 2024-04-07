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
    private Queue<TreeNode> queue = new LinkedList<>();
    //private ArrayList<Integer> path = new ArrayList<>();
    private int count_path = 0;
    public int pathSum(TreeNode root, int targetSum) {
        //System.out.println(Integer.MAX_VALUE);
        //System.out.println(Integer.MIN_VALUE);
        //legal_num = targetSum;
        long target = targetSum;
        if(root == null) return 0;
        if(root.left == null && root.right == null && root.val != targetSum) return 0;
        queue.offer(root);
        while(queue.size() != 0){
            TreeNode curr = queue.poll();
            if(curr.left != null) queue.offer(curr.left);
            if(curr.right != null) queue.offer(curr.right);
            //System.out.println(curr.val);
            findPath(curr, target - curr.val);
            //path.clear();
        }
        return count_path;
    }

    private void findPath(TreeNode root, long targetSum){
        //path.add(root.val);
        //if(targetSum == 0 && checkLegal(path, legal_num)) {
        if(targetSum == 0) {
            count_path++;
            //System.out.print(path);
        }
        if(root.left == null && root.right == null && targetSum != 0) return;

        if(root.left != null){
            findPath(root.left, targetSum - root.left.val);
            //path.remove(path.size() - 1);
        } 
        if(root.right != null) {
            findPath(root.right, targetSum - root.right.val);
            //path.remove(path.size() - 1);
        }
    }
}
