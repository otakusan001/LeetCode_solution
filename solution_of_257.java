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
    public List<String> binaryTreePaths(TreeNode root) { 
        List<String> paths = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        if(root == null) return paths;
        travesalNode(root, result, paths);
        return paths;

    }
    private void travesalNode(TreeNode curr, List<Integer> result, List<String> paths){
        result.add(curr.val);
        if(curr.left == null && curr.right == null){
            StringBuilder sb = new StringBuilder();
            for(int i = 0;i < result.size() - 1;i++){
                sb.append(result.get(i).toString());
                sb.append("->");
            }
            sb.append(result.get(result.size() - 1).toString());
            paths.add(sb.toString());
        } 
        if(curr.left != null){
            travesalNode(curr.left, result, paths);
            result.remove(result.size()-1);
        }
        if(curr.right != null){
            travesalNode(curr.right, result, paths);
            result.remove(result.size()-1);
        }
    }
}
