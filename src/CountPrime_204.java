public class CountPrime_204 {
    class Solution {
        public int countPrimes(int n) {
            //Sieve of Eratosthenes
            //抓住质数的倍数均不为质数，逐步删除元素
            int count = 0;
            boolean[] notPrime = new boolean[n];

            for (int i=2;i<n;i++){
                //遇到质数+1
                if (!notPrime[i]){
                    count ++;
                    //质数的所有倍数都不为质数
                    for (int j=2; i*j < n;j++){
                        notPrime[i*j] = true;
                    }
                }
            }
            return count;
        }
    }
}
