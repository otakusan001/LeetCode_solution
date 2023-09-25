class Solution {
    private char[] reverse(char[] temp, int left, int right){
        while(left < right){
            temp[left] ^= temp[right];
            temp[right] ^= temp[left];
            temp[left] ^= temp[right];
            left++;right--;
        } 
        return temp;
    }
    public String reverseWords(String s) {
        char[] temp = s.toCharArray();
        int fast = 0;int slow = 0;
        //去除多余空格
        while(fast < temp.length){
            if(temp[fast] != ' ') {
                if(slow != 0) temp[slow++] = ' ';
                while(fast < temp.length && temp[fast] != ' ') temp[slow++] = temp[fast++];
            }
            fast++;
        }
        // 翻转去除多余空格后的字符串
        temp = Arrays.copyOfRange(temp, 0, slow);
        temp = reverse(temp, 0, temp.length - 1);
        //翻转单独单词
        slow = 0;fast = 0;
        while(fast < temp.length){
            if(fast == temp.length-1) {
                temp = reverse(temp, slow, fast);
                }
            if(temp[fast] == ' '){
                temp = reverse(temp, slow, fast-1);
                slow = fast+1;
            }
            fast++;
        }
        return new String(temp);
    }
}
