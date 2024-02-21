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


import java.util.ArrayList;
import java.util.Collections;

class Solution {
    ArrayList<Integer> result = new ArrayList<Integer>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root != null){
            result.add(root.val);
            if(root.right != null) postorderTraversal(root.right);
            if(root.left != null) postorderTraversal(root.left);  
        }
    ArrayList<Integer> new_list = new ArrayList<Integer>();
    for(Integer n : result){
        new_list.add(n);
    }
    Collections.reverse(new_list);
    return new_list;    
    }
}
