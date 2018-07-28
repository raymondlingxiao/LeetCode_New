public class ThreeSumClosest_16 {
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int dif = Integer.MAX_VALUE;
            int sum = 0;
            if (nums.length < 3)
                return -1;
            for (int i=0;i+2<nums.length;i++){
                //skip
                if (i>0&&nums[i] == nums[i-1])
                    continue;
                int newTarget = target - nums[i];
                int s = i+1;
                int e = nums.length-1;
                while (s < e){
                    int temp = nums[s] + nums[e];
                    if (temp == newTarget )
                        return target;
                    if (temp < newTarget){
                        int sub = Math.abs(temp - newTarget);
                        if (sub < dif){
                            dif = sub;
                            sum = nums[i] + temp;
                        }
                        s++;
                    }
                    else{
                        int sub = Math.abs(temp - newTarget);
                        if (sub < dif){
                            dif = sub;
                            sum = nums[i] + temp;
                        }
                        e --;
                    }
                }
            }
            return sum;
        }
    }
}
