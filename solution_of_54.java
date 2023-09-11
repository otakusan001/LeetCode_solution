class Solution {
    public static int minVal(int m, int n){
        if(m < n) return m;
        else return n;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length,n = matrix[0].length;
        //System.out.println(m);
        int count = 0;
        List<Integer> result = new ArrayList<Integer>();
        //int[] result = new int[m * n];
        if (m == 1){
            for(int k = 0; k < n; k++) result.add(matrix[0][k]); //result[count++] = matrix[0][k];
            return result;
        }
        else if(n == 1){
            for(int k = 0; k < m; k++) result.add(matrix[k][0]);//result[count++] = matrix[k][0];
            return result;            
        }
        int offset = 1, start = 0, loop = 0, i, j;
        int minval = minVal(m, n);
        while(loop < minval/2){
            for(j = start; j < n - offset; j++) result.add(matrix[start][j]);//result[count++] = matrix[start][j];
            for(i = start; i < m - offset; i++) result.add(matrix[i][j]);//result[count++] = matrix[i][j];
            for(;j > start; j--) result.add(matrix[i][j]);//result[count++] = matrix[i][j];
            for(;i > start; i--) result.add(matrix[i][j]);//result[count++] = matrix[i][j];
            start++;loop++;offset++;
            }
        if(m > n){
            //System.out.println("n flag");
            if((n - 2 * loop) == 1){   
                offset--;
                for(int k = start; k < m - offset; k++) result.add(matrix[k][start]);//result[count++] = matrix[k][start];
            }
        }
        else{
            //System.out.println("m flag");
            //System.out.println(m - 2 * (loop));
            if((m - 2 * loop) == 1){
                offset--;
                for(int k = start; k < n - offset; k++) result.add(matrix[start][k]);//result[count++] = matrix[start][k];
            } 
        }   
        return result;         
        }
        
        

}
