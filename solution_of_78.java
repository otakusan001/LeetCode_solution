class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private ArrayList<Integer> record = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList(record));
        if(nums.length == 0) return res;
        backtracking(nums, 0);
        return res;
    }
    private void backtracking(int[] nums, int startIndex){
        if(nums.length == startIndex ) {    
            //System.out.println(record);
            return;
        }
        for(int i = startIndex; i < nums.length; i++){
            record.add(nums[i]);
            res.add(new ArrayList(record));
            backtracking(nums, i+1);
            record.remove(record.size() - 1);
        }
    }
}
