public class MajorElem_169 {
    class Solution {
        public int majorityElement(int[] nums) {
            // using map os-n ot-2n
            int standard = nums.length/2;
            Map<Integer,Integer> map = new HashMap<Integer,Integer>();
            for (int i=0;i<nums.length;i++){
                if (map.containsKey(nums[i])){
                    map.put(nums[i],map.get(nums[i])+1);
                }
                else
                    map.put(nums[i],1);
            }
            for (Integer key: map.keySet()){
                if (map.get(key) > standard)
                    return key;
            }
            return -1;

        }
    }
    class Solution2 {
        public int majorityElement(int[] nums) {
            // using faster solution 元素个数相减
            int major =nums[0];
            int count = 0;
            for (int num:nums){
                if (count == 0){
                    major = num;
                    count ++;
                }
                else if (major == num)
                    count ++;
                else if (major != num)
                    count --;
            }
            return major;

        }
    }
}
