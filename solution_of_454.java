import java.util.HashMap;

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map12 = new HashMap<>();
        int count = 0;
        for(int i = 0; i < nums1.length; i++)
            for(int j = 0; j < nums2.length; j++){
                if(map12.containsKey(nums1[i] + nums2[j])){
                    map12.compute(nums1[i] + nums2[j], (key, value) -> value+1);
                    continue;
                }
                map12.put(nums1[i] + nums2[j], 1);
            }
        for(int i = 0; i < nums3.length; i++)
            for(int j = 0; j < nums4.length; j++){
                int target = 0 - (nums3[i] + nums4[j]);
                if(map12.containsKey(target)) count += map12.get(target);
            }
        return count;
    }
}
