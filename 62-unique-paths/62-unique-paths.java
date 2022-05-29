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
        if(grid[n][m] > 0)
            return grid[n][m];
        
        grid[m][n] = gridTraveller(m-1, n) + gridTraveller(m, n-1);
        grid[n][m] = grid[m][n];
        
        return grid[m][n];
    }
    
    public int uniquePaths(int m, int n) {
        int size = Math.max(m,n) + 1;
        grid = new int[size][size];
   
		return gridTraveller(m, n);
    }
}