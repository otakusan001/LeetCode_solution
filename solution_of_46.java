class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtracking(nums);
        return res;
    }
    private int[] used = new int[21];
    private void backtracking(int[] nums){
        if(path.size() == nums.length){
            res.add(new ArrayList(path));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(used[nums[i]+10] == 1) continue;
            //System.out.println(path);
            path.add(nums[i]);
            used[nums[i]+10] = 1;
            backtracking(nums);
            used[path.getLast()+10] = 0;
            path.removeLast();
            //System.out.println(path);

        }
    }
}
