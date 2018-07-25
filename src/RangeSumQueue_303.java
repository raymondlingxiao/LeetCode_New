public class RangeSumQueue_303 {
    class NumArray {

        private int[] nums;
        private Map<String,Integer> map= new HashMap<String,Integer>();
        public NumArray(int[] nums) {
            this.nums = nums;
        }

        public int sumRange(int i, int j) {
            int sum = 0;
            if (map.containsKey(""+i+j))
                return map.get(""+i+j);
            for (int k=i;k<=j;k++){
                sum += nums[k];
            }
            map.put(""+i+j,sum);
            return sum;
        }
    }

/**
 * Too slow, try to using the elements within the array
 */
class NumArray2 {

    private int[]sums;
    public NumArray(int[] nums) {
        if (nums.length != 0){
            sums = new int[nums.length];
            sums[0] = nums[0];
            for (int i=1;i<nums.length;i++){
                sums[i] = sums[i-1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        if (i > j)
            return -1;
        if (i == 0)
            return sums[j];
        return sums[j] - sums[i-1];
    }
}
}
