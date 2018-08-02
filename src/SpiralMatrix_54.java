public class SpiralMatrix_54 {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> result = new ArrayList<>();
            if (matrix.length == 0)
                return result;
            int rowBegin = 0;
            int rowEnd = matrix.length-1;
            int colBegin = 0;
            int colEnd = matrix[0].length-1;


            while (rowBegin <= rowEnd && colBegin <=colEnd){
                // move to the right
                for (int i=colBegin;i<=colEnd;i++){
                    result.add(matrix[rowBegin][i]);
                }
                rowBegin ++;

                // move to the bottom
                for (int i=rowBegin;i<=rowEnd;i++){
                    result.add(matrix[i][colEnd]);
                }
                colEnd --;
                /**
                 * 此处需要注意的就是下面的两个if的条件,其真正目的是为了避免重复add元素
                 * 这里可以想成由于之前的begin和col都进行了变化,所以在再次使用他们之前
                 * 需要判断是否已经过界限了
                 * */
                // move to the left
                if (rowBegin <=rowEnd){
                    for (int i=colEnd;i>=colBegin;i--){
                        result.add(matrix[rowEnd][i]);
                    }
                }
                rowEnd --;

                //move to the top
                if (rowBegin<=rowEnd && colBegin <= colEnd){
                    for (int i=rowEnd;i>=rowBegin;i--){
                        result.add(matrix[i][colBegin]);
                    }
                }
                colBegin++;
            }

            return result;
        }
    }
}
