import java.util.HashSet;

class Solution {
    public boolean isHappy(int n) {
       HashSet<Integer> buffer = new HashSet<>();
       int sum = 0;
       int temp = 0;
       while(true){
           while(n != 0){
            temp = n%10;
            sum += temp * temp;
            n /= 10;
           }
           if(sum == 1) return true;
           if(buffer.contains(sum)) return false;
           else{
               buffer.add(sum);
               n = sum;
               sum = 0;
           }
       } 
    }
}
