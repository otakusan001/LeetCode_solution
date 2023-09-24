class Solution {
    private char[] reverseK(char[] t, int left, int right){
      while(left < right){
        t[left] ^= t[right];
        t[right] ^= t[left];
        t[left] ^= t[right];
        left++;right--;
      }
      return t;
    }
    public String reverseStr(String s, int k) {
        char[] t = s.toCharArray();
        for(int i = 0; i < t.length; i += 2*k){
          if(i + k > t.length) {
            t = reverseK(t, i, t.length-1);break;
          }
          t = reverseK(t, i, i+k-1);
        }
        return new String(t);
    }
}
