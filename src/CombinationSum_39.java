public class CombinationSum_39 {
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            dfsBackTrack(result,new ArrayList<>(),candidates,target,0);
            return result;

        }

        private void dfsBackTrack(List<List<Integer>> result, List<Integer> temp, int[] nums, int remain,int start){
            // exit point
            if (remain < 0)
                return;
            if (remain == 0)
                result.add(new ArrayList<>(temp));
            for (int i = start; i<nums.length;i++){
                temp.add(nums[i]);
                dfsBackTrack(result, temp, nums, remain-nums[i],i);
                // in the name of back track, must return to the previous version
                temp.remove(temp.size()-1);
            }
            return;
        }
    }
}
