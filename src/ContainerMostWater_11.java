public class ContainerMostWater_11 {
    class Solution {
        public int maxArea(int[] height) {
            // BF
            int max =0;
            for (int i=0;i<height.length;i++){
                for(int j=i+1;j<height.length;j++){
                    int l = j-i;
                    int ht = Math.min(height[i],height[j]);
                    max = Math.max(max,l*ht);
                }
            }
            return max;
        }
    }

    class Solution2 {
        public int maxArea(int[] height) {
            // two pointers
            int max = 0;
            int start = 0;
            int end = height.length-1;
            while (start < end){
                max = Math.max(max,(end-start)*Math.min(height[start],height[end]));
                if (height[start] < height[end])
                    start++;
                else
                    end --;
            }
            return max;
        }
    }
}
