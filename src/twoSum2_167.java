public class twoSum2_167 {
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            // using two pointers to traverse
            int fp = 0;
            int ep = numbers.length -1;
            while (fp < ep){
                if (numbers[fp] + numbers[ep] == target)
                    return new int[]{fp+1,ep+1};
                else if (numbers[fp] + numbers[ep] < target)
                    fp ++;
                else
                    ep --;
            }
            return new int[2];
        }
    }
}
