public class FindDupNum_287 {
    class Solution {
        public int findDuplicate(int[] nums) {
            // O-n
            HashMap<Integer, Boolean> map = new HashMap<>();
            for (int num : nums) {
                if (map.containsKey(num))
                    return num;
                else
                    map.put(num, true);
            }
            return -1;
        }
    }

    class Solution2 {
        public int findDuplicate(int[] nums) {
            int slow = nums[0];
            int fast = nums[slow];

            while (slow != fast) {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }

            fast = 0;
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }

            return slow;

        }

    }

}
