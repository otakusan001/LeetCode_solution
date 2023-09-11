class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, j, sum = 0;
        int minlength = 0;
        for(j = 0; j < nums.length; j++){
            sum += nums[j];
            while(sum >= target){
                int sub = j - i + 1;
                if(minlength == 0) minlength = sub;
                if(sub < minlength) minlength = sub;
                sum -= nums[i];
                i++;
            }
        }
        return minlength;
    }
}
