class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        int BOX_SIZE = 3;
        int BOARD_SIZE = BOX_SIZE * BOX_SIZE;
        
        // rule-1
        for (int i = 0; i < BOARD_SIZE; i++) {
            vector<bool> validity(BOARD_SIZE);
            
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == '.') continue;
                int value = board[i][j] - '0' - 1;
                if (validity[value]) return false;
                validity[value] = true;
            }
        }
        
        // rule-2
        for (int j = 0; j < BOARD_SIZE; j++) {
            vector<bool> validity(BOARD_SIZE);
            for (int i = 0; i < BOARD_SIZE; i++) {
                if (board[i][j] == '.') continue;
                int value = board[i][j] - '0' - 1;
                if (validity[value]) return false;
                validity[value] = true;
            }
        }
        
        // rule-3
        for (int k = 0; k < BOX_SIZE; k++) {
            for (int l = 0; l < BOX_SIZE; l++) {
                // selecting the (i,j)th sub-box
                vector<bool> validity(BOARD_SIZE);
                for (int i = k * BOX_SIZE; i < (k + 1) * BOX_SIZE; i++) {
                    for(int j = l * BOX_SIZE; j < (l + 1) * BOX_SIZE; j++) {
                        if (board[i][j] == '.') continue;
                        int value = board[i][j] - '0' - 1;
                        if (validity[value]) return false;
                        validity[value] = true;    }
                }
            }
        }
        
        return true;
    }
};