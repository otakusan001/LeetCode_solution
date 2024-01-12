import java.util.Stack;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> parentheses = new Stack<Character>();
        if(s.length() % 2 != 0) return false;
        for(int i = 0; i < s.length();i++){
            if(s.charAt(i) == '(') parentheses.push(')');
            else if(s.charAt(i) == '[') parentheses.push(']');
            else if(s.charAt(i) == '{') parentheses.push('}');
            else if(parentheses.empty() || s.charAt(i) != parentheses.pop()) return false;
        }
        if(parentheses.empty()) return true;
        else return false;
    }
}
