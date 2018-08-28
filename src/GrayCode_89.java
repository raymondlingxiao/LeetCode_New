public class GrayCode_89 {
    class Solution {
        public List<Integer> grayCode(int n) {
            //G(i) = i^(i/2);
            List<Integer> result = new LinkedList<>();
            for (int i = 0; i < 1<<n; i++) result.add(i ^ i>>1);
            return result;
        }
    }

    int nums = 0;
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<>();
        backTrack(n, ret);
        return ret;
    }

    private void backTrack(int n, List<Integer> ret) {
        if (n == 0) {
            ret.add(nums);
            return;
        }
        else {
            backTrack(n - 1, ret);
            nums ^= (1 << n - 1);
            backTrack(n - 1, ret);
        }
    }
}
