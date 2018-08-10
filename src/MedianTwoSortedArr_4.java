public class MedianTwoSortedArr_4 {
    class Solution {
        public double findMedianSortedArrays(int[] num1, int[] num2) {
            // 抓住median的左右两边的两个特性
            // 1.左边的max < 右边的min
            // 2.左右两边的长度相等

            int m = num1.length;
            int n = num2.length;
            // j = (m+n+1)/2 +i
            // j must: <=n
            if (m>n)
                return (findMedianSortedArrays(num2,num1));

            int iMin = 0;
            int iMax = m;
            while (iMin <= iMax){
                int i = (iMin + iMax)/2;
                int j = (m+n+1)/2-i;
                // i=m 单独处理边界
                if (i != 0 && j != n && num1[i-1] > num2[j])
                    iMax = i-1;
                else if (j != 0 && i != m && num2[j-1] > num1[i])
                    iMin = i+1;
                else{
                    // get 'mid'
                    int leftMax = 0;
                    if (i==0)
                        leftMax = num2[j-1];
                    else if (j == 0)
                        leftMax = num1[i-1];
                    else
                        leftMax = Math.max(num1[i-1],num2[j-1]);
                    // 奇数
                    if ((m+n)%2 == 1)
                        return leftMax;

                    int rightMin = 0;
                    if (i==m)
                        rightMin = num2[j];
                    else if(j == n)
                        rightMin = num1[i];
                    else
                        rightMin = Math.min(num1[i],num2[j]);

                    //偶数
                    return (leftMax+rightMin)/2.0 ;

                }
            }
            return 0.0;
        }
    }
}
