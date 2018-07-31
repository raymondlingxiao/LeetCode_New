public class ValidSudoku_36 {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i<9; i++){
            HashSet<Character> rows = new HashSet<Character>();
            HashSet<Character> columns = new HashSet<Character>();
            HashSet<Character> cube = new HashSet<Character>();
            for (int j = 0; j < 9;j++){
                if(board[i][j]!='.' && !rows.add(board[i][j]))
                    return false;
                if(board[j][i]!='.' && !columns.add(board[j][i]))
                    return false;
                // Remeber !!!!!!!!!!!!
                int RowIndex = 3*(i/3);
                int ColIndex = 3*(i%3);
                if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
                    return false;
            }
        }
        return true;
    }

    class Solution {
        public boolean isValidSudoku(char[][] board) {
            // Using strings
            Set<String> set = new HashSet<>();
            for (int i=0;i<9;i++){
                for (int j=0;j<9;j++){
                    char num = board[i][j];
                    if (num != '.'){
                        if (!set.add(num + "in row" + i)||
                                !set.add(num + "in col" + j)||
                                !set.add(num + "in block" + i/3 +"-"+j/3))
                            return false;
                    }
                }
            }
            return true;

        }
    }
}
