import java.util.Stack;
class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0;i < s.length();i++){
            if(!stack.empty() && s.charAt(i) == stack.peek()) stack.pop();
            else stack.push(s.charAt(i));
        }
        StringBuffer result = new StringBuffer();
        for(;!stack.empty();){
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }
}
