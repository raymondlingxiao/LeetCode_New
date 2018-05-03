public class ReverseInteger_7 {
    class Solution1 {
        //第一个解法，用list存储剪切的数字
        public int reverse(int x) {
            List<Integer> digits = new ArrayList<>();
            int length = -1;
            while(Math.abs(x)>=1){
                digits.add(x%10);
                x /= 10;
                length ++;
            }
            long result = 0;
            for (Integer digit: digits){
                if (result < -Math.pow(2,31) || result> Math.pow(2,31)-1)
                    return 0;
                result += digit * Math.pow(10,length);
                length --;
            }
            return (int)result;
        }
    }

    class SolutionTwo {
        // 这个方法中将tail在剪切的时候就放到头部
        // 每次将新的tail放到上一个result的尾部
        // 节约了存储空间和访问list的时间

        public int reverse(int x) {
            long result = 0;
            while (x!=0){
                int lastDigit = x % 10;
                result = result * 10 + lastDigit;
                if (result < -Math.pow(2,31) || result > Math.pow(2,31)-1 )
                    return 0;
                x /= 10;
            }
            return (int)result;
        }
    }


}
