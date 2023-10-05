class Solution {
    public void getNext(int[] next, String s){
        int j = 0;
        next[0] = 0;
        for(int i = 1; i < s.length();i++){
            while(j > 0 && s.charAt(i) != s.charAt(j)) j = next[j-1];
            if(s.charAt(i) == s.charAt(j)) j++;
            next[i] = j;
        }
    }

    public boolean repeatedSubstringPattern(String s) {
        int[] next = new int[s.length()];
        getNext(next, s);
        if(s.length() <= 0) return false;
        if(next[s.length() -1] != 0 && s.length() % (s.length() - next[s.length() - 1]) == 0) return true;
        return false;
    }
}
