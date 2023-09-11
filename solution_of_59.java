class Solution {
    public int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        int start = 0, count = 1, offset = 0, i, j;
        while(offset++ < n / 2){
            for(j = start; j < n - offset; j++) nums[start][j] = count++;
            for(i = start; i < n - offset; i++) nums[i][j] = count++;
            for(;j > start; j--) nums[i][j] = count++;
            for(;i > start; i--) nums[i][j] = count++;
            start++;
        }
        if(n % 2 == 1) nums[start][start] = count;
        return nums;
    }
}
