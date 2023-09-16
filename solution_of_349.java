class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] hasharray = new int[1005];
        int[] result = new int[1005];
        int count = 0;int count1 = 0;
        for(int i = 0; i < nums1.length; i++){
            hasharray[nums1[i]] = 1;
        }
        for(int j = 0; j < nums2.length; j++){
            if(hasharray[nums2[j]] == 1){
                result[nums2[j]] = 1;
            }
        }
        for(int l = 0; l < result.length; l++){
            if(result[l] == 1) count++;
        }
        int[] res = new int[count];
        for(int k = 0;k < result.length;k++){
            if(result[k] == 1) res[count1++] = k;
        }
        
        return res;
    }
}
