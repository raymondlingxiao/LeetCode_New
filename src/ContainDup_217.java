public class ContainDup_217 {
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            // Map<Integer,Integer> map = new HashMap<Integer,Integer>();
            // for (int num: nums){
            //     if (map.containsKey(num)){
            //         return true;
            //     }
            //     else
            //         map.put(num,1);
            // }
            // return false;

            Set<Integer> set = new HashSet<Integer>();
            for(int i : nums)
                if(!set.add(i))// if there is same
                    return true;
            return false;
        }
    }
}
