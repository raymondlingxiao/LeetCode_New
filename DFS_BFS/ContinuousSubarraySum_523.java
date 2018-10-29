public class ContinuousSubarraySum_523 {
    class Solution {
        /*
            A proof sketch:
            Suppose sum_i represents the running sum starting from index 0 and ending at i,
            once we find a mod that has been seen, say modk, we have:
            current one: sum_i = m*k + modk
            previous one: sum_j = n*k + modk
            Thus,
            sum_i - sum_j = (m - n) *k
        */
        public boolean checkSubarraySum(int[] nums, int k) {
        /*
            基本方法是存储每个index下的sum值，最新的index的sum等于前一个sum+他自己
            然后在两个for中，利用index的sum差，得到一个区间的sum是多少

            优化利用hashMap，存储sum%k的值，如果出现已经出现过得值，检查他们的index差值是不是大于1
            证明如上
        */
            HashMap<Integer,Integer> map = new HashMap<>();
            map.put(0,-1);
            int sum = 0;
            for (int i=0;i<nums.length;i++){
                sum += nums[i];

                if (k != 0)
                    sum %= k;
                if (map.containsKey(sum)){
                    if (i - map.get(sum) > 1)
                        return true;
                }
                else{
                    map.put(sum,i);
                }
            }

            return false;

        }
    }
}
