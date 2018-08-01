public class Permutation_46 {
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            boolean[] used = new boolean[nums.length];
            backTrack(result,new ArrayList<>(),nums,used);
            return result;

        }

        private void backTrack(List<List<Integer>> result, List<Integer> temp, int[] nums, boolean[] used){
            if (temp.size() == nums.length){
                result.add(new ArrayList<>(temp));
                return;
            }

            for (int i=0;i<nums.length;i++){
                // if (temp.contains(nums[i]))
                //     continue;
                if (!used[i]){
                    temp.add(nums[i]);
                    used[i] = true;
                    backTrack(result,temp,nums,used);
                    temp.remove(temp.size()-1);
                    used[i] = false;
                }
            }
        }
    }
}
