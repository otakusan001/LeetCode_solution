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
    private List<Integer> res = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        countMode(root);
        int[] result = new int[res.size()];
        for(int i = 0;i < res.size();i++){
            result[i] = res.get(i);
        }
        return result;
    }
    private TreeNode pre;
    private int count, maxCount;
    private void countMode(TreeNode curr){
        if(curr == null) return;
        //System.out.print(curr.val);
        countMode(curr.left);
    
        //System.out.println(pre.val);
        if(pre != null && pre.val == curr.val) {
            count++;//System.out.println(count);
        }
        else {
            count = 1;
        }
        if(count == maxCount) res.add(curr.val);
        if(count > maxCount) {
            maxCount = count; 
            res.clear();
            res.add(curr.val);
        }
        pre = curr;
        countMode(curr.right);
        //System.out.print(maxCount);
        return;
    }
}
