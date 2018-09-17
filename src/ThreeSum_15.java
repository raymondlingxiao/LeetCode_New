import java.util.*;

public class ThreeSum_15 {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            Set<Integer> used = new HashSet<>();
            Set<List<Integer>> result = new HashSet<>();
            for (int i=0;i<nums.length;i++){
                if (used.contains(nums[i]))
                    continue;
                else
                    used.add(nums[i]);
                Map<Integer,Integer> map = new HashMap<Integer,Integer>();
                List<Integer> temp = new LinkedList<Integer>();
                int remain = 0-nums[i];
                // 没有进行去调重复的操作，而是利用set，最后来取舍，消耗了大量的时间
                for (int j = i+1;j<nums.length;j++){
                    if (map.containsKey(remain-nums[j])){
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(remain-nums[j]);
                        result.add(temp);
                        temp = new LinkedList<Integer>();
                    }
                    else
                        map.put(nums[j],j);
                }

            }
            return new ArrayList<>(result);

        }
    }
    /**
     * 由于是排序过后的结果，所以可以运用两个pointer来进行binary search的类似操作
     * 需要注意的就是skip掉相同的元素，并且之前已经计算国结果的i，从第i+1位开始即可
     * */
    class Solution2 {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            for (int i=0;i+2<nums.length;i++){
                if (i>0 && nums[i-1] == nums[i])
                    continue;
                int start = i+1;
                int end =nums.length-1;
                int target = -nums[i];
                while (start < end){
                    if (nums[start] + nums[end] == target){
                        result.add(Arrays.asList(nums[i],nums[start],nums[end]));
                        start ++;
                        end --;
                        while (start < end && nums[start-1] == nums[start])
                            start ++;
                        while (start < end && nums[end +1] == nums[end])
                            end --;
                    }
                    else if (nums[start] + nums[end] < target){
                        start ++;
                    }
                    else
                        end --;
                }
            }
            return result;
        }
    }
}

class Solution3 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();
        // 固定一个数，从这个数的右边开始遍历
        for (int i=0;i<nums.length;i++){
            int target = -nums[i];
            match(target, nums, i, set);
        }
        return new ArrayList<List<Integer>>(set);
    }

    private void match(int target, int[] nums, int ig, Set<List<Integer>> set){
        // 从右边开始遍历
        int s = ig+1;
        int t = nums.length-1;
        while (s<t){
            if (nums[s] + nums[t] < target){
                s++;
            }
            else if (nums[s] + nums[t] > target){
                t--;
            }
            // 当出现相等的情况时候，应该考虑可能后续还有组合可能
            else if (nums[s] + nums[t] == target){
                set.add(Arrays.asList(nums[ig],nums[s],nums[t]));
                // 继续往下遍历
                s++;
                t--;
                // 这里需要注意，是拿当前的元素和上一个元素比较，注意下标的处理
                while (s<t && nums[s-1] == nums[s])
                    s++;
                while (s<t && nums[t] == nums[t+1])
                    t--;

            }

        }
    }
}
