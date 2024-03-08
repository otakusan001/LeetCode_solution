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
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> array = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.offer(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                while(size-- > 0){
                    TreeNode temp = queue.poll();
                    array.add(temp.val);
                    //System.out.println(array);
                    if(temp.left != null) queue.offer(temp.left);
                    if(temp.right != null) queue.offer(temp.right);
                    //size--;
                }
                //System.out.println(array);
                result.add(new ArrayList<>(array));
                array.clear();
            }
            
        }
        return result;
    }
}
