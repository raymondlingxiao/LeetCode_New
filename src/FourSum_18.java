public class FourSum_18 {
    class Solution {
        /**
         * 类同于3 sum，固定两个元素即可
         * */
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            List<List<Integer>> result = new LinkedList<>();
            if (nums.length < 4)
                return result;
            for (int i=0;i<nums.length-3;i++){
                if (i>0 && nums[i] == nums[i-1] )
                    continue;
                for (int j=i+1;j<nums.length-2;j++){
                    if (j>i+1 && nums[j] == nums[j-1])
                        continue;
                    int s = j+1;
                    int k = nums.length-1;
                    int goal = target - nums[i] - nums[j];

                    while (s < k){
                        if (nums[s] + nums[k] == goal){
                            result.add(Arrays.asList(nums[i],nums[j],nums[s],nums[k]));
                            s ++;
                            k --;
                            while (s < k && nums[s] == nums[s-1]) s++;
                            while (s < k && nums[k] == nums[k+1]) k--;
                        }
                        else if (nums[s] + nums[k] < goal)
                            s ++;
                        else
                            k--;
                    }
                }
            }
            return result;

        }
    }
}
