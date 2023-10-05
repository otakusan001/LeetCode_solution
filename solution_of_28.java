class Solution {
    public void getNext(int[] next, String needle){
        int j = 0;
        next[0] = 0;
        for(int i = 1; i < needle.length();i++){
            while(j > 0 && needle.charAt(i) != needle.charAt(j)) j = next[j-1];
            if(needle.charAt(i) == needle.charAt(j)) j++;
            next[i] = j;
        }
    }

  //KMP解法
    public int strStr(String haystack, String needle) {
        int[] next = new int[needle.length()];
        getNext(next, needle);
        int j = 0;int flag = 0;
        for(int i = 0; i < haystack.length();i++){
            if(j < needle.length() && haystack.charAt(i) == needle.charAt(j)) {
                if(j == 0) flag = i;
                j++;
            }
            else if(j > 0){
                j = next[j-1];
                flag = i - j;
                i -= 1;
            }  
            if(j == needle.length()) return flag; 
        }
        return -1;
    }
/*
//暴力解法
    public int strStr(String haystack, String needle) {
        int i;int j;int flag;
        for(i = 0;i < haystack.length();i++){
            flag = i;
            for(j = 0; j < needle.length();j++){
                if(i+j < haystack.length() && needle.charAt(j) == haystack.charAt(i+j)) continue;
                else break;
            }
            if(j == needle.length()) return flag;
        }
        return -1;
    }
*/
}
