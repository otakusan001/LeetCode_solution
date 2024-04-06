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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return result;
        path.add(root.val);
        findPath(root, targetSum - root.val);
        return result;
    }
    private List<List<Integer>> result = new ArrayList<>();
    private ArrayList<Integer> path = new ArrayList<>();
    private void findPath(TreeNode root, int targetSum){
        
        if(root.left == null && root.right == null && targetSum == 0) {
            //System.out.print(path);
            result.add(new ArrayList<>(path));
            return;
        }
        if(root.left == null && root.right == null && targetSum != 0) {
            return;
        }
        if(root.left != null){
            path.add(root.left.val);
            findPath(root.left, targetSum - root.left.val);
            path.remove(path.size() - 1);
        }
        if(root.right != null){
            path.add(root.right.val);
            findPath(root.right, targetSum - root.right.val);
            path.remove(path.size() - 1);
        }
    }
}
