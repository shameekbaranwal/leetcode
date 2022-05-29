import java.util.Arrays;

class Solution {
    int[][] grid;
    
    int gridTraveller(int m, int n) {
        if (m <= 0 || n <= 0)
            return 0;
        if (m == 1 || n == 1)
            return 1;
        
        if(grid[m][n] > 0)
            return grid[m][n];
        
        grid[m][n] = gridTraveller(m-1, n) + gridTraveller(m, n-1);
        return grid[m][n];
    }
    
    public int uniquePaths(int m, int n) {
        grid = new int[m+1][n+1];
   
		return gridTraveller(m, n);
    }
}