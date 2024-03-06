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
//递归解法
class Solution {
    ArrayList<Integer> result = new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root != null){
            result.add(root.val);
            if(root.left != null) preorderTraversal(root.left);
            if(root.right != null) preorderTraversal(root.right);
        }
    return result;    
    }
}

/*迭代法
import java.utils.Stack
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<>();
        if(root != null){
            st.push(root);
            while(!st.empty()){
                TreeNode temp = st.peek();
                st.pop();
                if(temp != null){
                    result.add(temp.val);
                    st.push(temp.right);
                    st.push(temp.left);
                }
            }

        }
        return result;    
    }
}
*/
