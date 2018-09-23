public class WallsAndGates_286 {
    /*
    此题利用终点来反推沿途的节点，并且更新他们的值
    利用每一个父节点都是大于子节点来避免死循环
    * */
    class Solution {
        public void wallsAndGates(int[][] rooms) {

            for (int i=0;i<rooms.length;i++){
                for (int j =0;j<rooms[0].length;j++){
                    if (rooms[i][j] == 0)
                        dfs(rooms,i,j,0);
                }
            }

        }

        // dfs
        private void dfs(int[][] rooms, int i, int j, int cur){
            // exit
            // use min value to avoid endless loop
            if (i<0||i>=rooms.length||j<0||j>=rooms[0].length||rooms[i][j] < cur)
                return;

            // update value
            rooms[i][j] = cur;

            dfs(rooms,i+1,j,cur+1);
            dfs(rooms,i-1,j,cur+1);
            dfs(rooms,i,j+1,cur+1);
            dfs(rooms,i,j-1,cur+1);

        }
    }
}
