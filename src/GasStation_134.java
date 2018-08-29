public class GasStation_134 {
    // On2
    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            for (int i=0;i<gas.length;i++){
                int curGas  = gas[i] - cost[i];
                for (int j=i+1;;j++){
                    if (j > gas.length-1)
                        j = j-gas.length;
                    if (curGas >= 0 && j == i)
                        return i;
                    if (curGas<=0)
                        break;
                    else{
                        curGas += gas[j]-cost[j];
                    }
                }
            }
            return -1;
        }
    }
}
