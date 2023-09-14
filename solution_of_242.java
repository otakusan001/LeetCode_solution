//哈希解法
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] hash = new int[26];
        //int base = Integer.valueOf('a');
        //int test;
        for(int i = 0; i < s.length();i++){
            hash[s.charAt(i) - 'a']++;
        }
        for(int j = 0;j < t.length();j++){
            hash[t.charAt(j) - 'a']--;
        }
        for(int k = 0; k < 26; k++){
            if(hash[k] != 0) return false;
        }
        return true;

    }
}
