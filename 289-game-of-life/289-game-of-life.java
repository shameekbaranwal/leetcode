class Solution {
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int columns = board[0].length;
        int[][] newBoard = new int[rows][columns];
        
        int[][] neighbours = {
            {-1, -1},
            {-1, 0},
            {-1, 1},
            {0, -1},
            {0, 1},
            {1, -1},
            {1, 0},
            {1, 1}
        };
    
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int numOfNeighboursAlive = 0;
                for (int k = 0; k < 8; k++) {
                    int newi = i + neighbours[k][0];
                    int newj = j + neighbours[k][1];
                    if (newi >= 0 && newi < rows && newj >= 0 && newj < columns) 
                        numOfNeighboursAlive += board[newi][newj];
                }
                if (board[i][j] == 0 && numOfNeighboursAlive == 3)
                    newBoard[i][j] = 1;
                if (board[i][j] == 1) {
                    if (numOfNeighboursAlive < 2 || numOfNeighboursAlive > 3)
                        newBoard[i][j] = 0;
                    else
                        newBoard[i][j] = 1;
                }
            }
        }
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++)
                board[i][j] = newBoard[i][j];
        }
    }
}