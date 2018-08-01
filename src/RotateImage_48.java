public class RotateImage_48 {
    class Solution {
        public void rotate(int[][] matrix) {
            // move up to down
            for (int i=0;i<matrix.length/2;i++){
                for (int j=0;j<matrix.length;j++){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[matrix.length-1-i][j];
                    matrix[matrix.length-1-i][j] = temp;
                }
            }

            // swap by diago
            for (int i=0;i<matrix.length;i++){
                //此处注意从i的下一个开始,避免重复
                for (int j=i+1;j<matrix[i].length;j++){
                    if (i != j){
                        int temp = matrix[i][j];
                        matrix[i][j] = matrix[j][i];
                        matrix[j][i] = temp;
                    }
                }
            }
        }

    }
}
