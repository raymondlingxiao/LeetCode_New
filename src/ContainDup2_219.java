public class ContainDup2_219 {
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            // two pointers, sliding window
            // so slow
            // if (nums.length <=1)
            //     return false;
            // int ft = 0;
            // int end = ft + k;
            // while (ft < nums.length){
            //     for (int i=end;i>ft;i--){
            //         if (i<nums.length && nums[ft] == nums[i])
            //             return true;
            //     }
            //     ft++;
            //     end++;
            // }
            // return false;

            Map<Integer,Integer> map = new HashMap<Integer,Integer>();
            for (int i=0;i<nums.length;i++){
                if (map.containsKey(nums[i])){
                    if (i-map.get(nums[i]) <= k)
                        return true;
                    else
                        map.put(nums[i],i);
                }
                else
                    map.put(nums[i],i);
            }

            return false;
        }


    }
}
