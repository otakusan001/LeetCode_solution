class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()) return false;
        int[] map = new int[26];
        for(char c : magazine.toCharArray()) map[c - 'a'] += 1;
        for(char c : ransomNote.toCharArray()) map[c - 'a'] -= 1;
        for(int i : map){
            if(i < 0) return false;
        }
        return true;
    }
}
