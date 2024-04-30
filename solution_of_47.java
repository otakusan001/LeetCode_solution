class Solution {

    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        //boolean repeat = new boolean[nums.length];
        Arrays.sort(nums);
        backtracking(nums);
        return res;
    }

    private boolean[] used = new boolean[21];

    private void backtracking(int[] nums){
        if(path.size() == nums.length){
            res.add(new ArrayList(path));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1] && used[i-1] == false) continue;
            
            if(used[i] == false){
                used[i] = true;
                //System.out.println(path);
                path.add(nums[i]);
                backtracking(nums);
                path.removeLast();
                used[i] = false;
                //System.out.println(path);

            }
        }
    }
