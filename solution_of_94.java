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
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root != null){
            
            if(root.left != null) inorderTraversal(root.left);
            result.add(root.val);
            if(root.right != null) inorderTraversal(root.right);
        
        }
    return result;    
    }
}

/*迭代法
import java.util.Stack;
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur;
        if(root != null){
            cur = root;
            while(cur != null || !st.empty()){
                if(cur != null){
                    st.push(cur);
                    cur = cur.left;
                }
                else{
                    cur = st.pop();
                    result.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return result;    
    }
}
*/
