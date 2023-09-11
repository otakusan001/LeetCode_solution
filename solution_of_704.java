class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while(low < high){
            int middle = (low + high) / 2;
            if(nums[middle] > target)  high = middle ;
            else if(nums[middle] < target) low = middle + 1;
            else return middle;
        }
        return -1;
    }
}
