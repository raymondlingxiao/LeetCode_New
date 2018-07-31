public class CombinationSum2_40 {
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(candidates);
            backTrack(result, new ArrayList<>(), candidates, target,0);
            return result;
        }

        private void backTrack(List<List<Integer>> result, List<Integer> temp, int[] nums, int remain, int start){
            if (remain < 0)
                return;
            if (remain == 0)
                result.add(new ArrayList<>(temp));

            for (int i=start;i<nums.length;i++){
                // speed up
                if (remain < nums[i])
                    break;
                if (i>start && nums[i] == nums[i-1])
                    continue;
                temp.add(nums[i]);
                backTrack(result,temp,nums,remain-nums[i],i+1);
                temp.remove(temp.size()-1);
            }
            return;
        }
    }
}
