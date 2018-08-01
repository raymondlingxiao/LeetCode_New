public class Permutatioin2_47 {
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            boolean[] used = new boolean[nums.length];
            helper(result,new ArrayList<>(),nums,used);
            return result;

        }

        private void helper(List<List<Integer>> result, List<Integer> temp,int[] nums,boolean[] used){
            if (temp.size() == nums.length){
                result.add(new ArrayList<>(temp));
                return;
            }

            for (int i=0;i<nums.length;i++){
                if (!used[i]){
                    // 当前一个是没有使用过，并且i没有使用过，且i不等于i-1的时候才进行
                    
                    if ( i>0 && nums[i] == nums[i-1] && !used[i-1])
                        continue;
                    temp.add(nums[i]);
                    used[i] = true;
                    helper(result,temp,nums,used);
                    temp.remove(temp.size()-1);
                    used[i] = false;
                }
            }
        }
    }
}
