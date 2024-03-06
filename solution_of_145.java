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
//递归解法
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

/*
import java.utils.Stack
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<>();
        if(root != null){
            st.push(root);
            while(!st.empty()){
                TreeNode temp = st.peek();
                st.pop();
                if(temp != null){
                    result.add(temp.val);
                    st.push(temp.left);
                    st.push(temp.right);
                }
            }

        }
        ArrayList<Integer> new_list = new ArrayList<Integer>();
        for(Integer n : result){
            new_list.add(n);
        }
        Collections.reverse(new_list);
        return new_list;     
    }
}
*/
