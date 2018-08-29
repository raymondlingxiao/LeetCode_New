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

    class Solution2 {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int start = 0;
            // if total gas > total cost, then must be a solution at start point
            int total = 0;
            int tank = 0;

            for (int i=0;i<gas.length;i++){
                tank += (gas[i] - cost[i]);
                // if it can't reach the next point
                if (tank < 0){
                    // start from the next point and record the gas condition when pass it
                    start = i+1;
                    // the gas needed when reaching i+1
                    total += tank;
                    // new record from the next point
                    tank = 0;
                }
            }

            // when loop ends and tank still fullfill all the gas needed before and after this node
            // return the start point
            if (total + tank >= 0)
                return start;
            else
                return -1;
        }
    }
}
