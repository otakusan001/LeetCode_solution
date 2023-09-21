import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length-3; i++){
            if((long) nums[i] > (long) target && (long) nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int k = i+1; k < nums.length-2; k++){                
                if((long) nums[i] + nums[k] > (long) target && (long) nums[i] + nums[k] > 0) break;                 
                if(k > i+1 && nums[k] == nums[k-1]) continue;
                int left = k + 1;
                int right = nums.length - 1;
                while(left < right){
                    if(nums[i] + nums[k] + nums[left] + nums[right] > target) right--;
                else if(nums[i] + nums[k] + nums[left] + nums[right] < target) left++;
                else{
                    result.add(Arrays.asList(nums[i], nums[k], nums[left], nums[right]));
                    while(left < right && nums[left] == nums[left+1]) left++;
                    while(left < right && nums[right] == nums[right-1]) right--;
                    left++;right--;
                }
                }  
            }

        }    
        return result;
    }
}
