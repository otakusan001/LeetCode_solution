class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path  = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return res;
    }
    private void backtracking(int[] nums, int startIndex){
        if(path.size() > 1) {
            res.add(new ArrayList(path));
        }
        int[] used = new int[201];
        for(int i = startIndex; i < nums.length; i++){
            //System.out.println(nums[i]);
            if(path.size() > 0 && nums[i] < path.peekLast()) continue;
            if(i > startIndex && used[nums[i]+100] == 1)  continue;
            path.add(nums[i]);
            //System.out.println(path);
            used[nums[i]+100] = 1;
            backtracking(nums, i+1);
            if(path.size() > 0) path.removeLast();
        }
    }
}
