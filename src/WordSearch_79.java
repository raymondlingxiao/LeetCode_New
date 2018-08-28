public class WordSearch_79 {
    class Solution {
        // visited 是为了防止反向重复probe
        private boolean[][] visited;
        public boolean exist(char[][] board, String word) {
            char[] words = word.toCharArray();
            visited = new boolean[board.length][board[0].length];
            for (int i=0;i<board.length;i++){
                for (int j=0;j<board[0].length;j++){
                    if (board[i][j] == words[0])
                        // 这里与helper结合达到回溯到上一个状态，准备从下一个节点开始重新进行
                        if (helper(i,j,words,0,board))
                            return true;
                }
            }
            return false;
        }

        private boolean helper(int row, int col, char[] words,int index, char[][] board){
            if (index == words.length)
                return true;
            if (row<0||col<0||row>=board.length||col>=board[0].length||index<0||index>=words.length||words[index] !=board[row][col] || visited[row][col] == true)
                return false;
            if (board[row][col] == words[index]){
                /**
                 * 如果下一个节点是需要的节点，探测他的四周的节点，一旦是死路，回溯到最初的状态
                 * */
                index ++;
                visited[row][col] = true;
                if (helper(row,col+1,words,index,board)||
                        helper(row,col-1,words,index,board)||
                        helper(row+1,col,words,index,board)||
                        helper(row-1,col,words,index,board))
                    return true;
                index--;
                visited[row][col] = false;
                return false;
            }
            else
                return false;
        }
    }
}
