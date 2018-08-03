public class MergeInterval_56 {
    /**
     * Definition for an interval.
     * public class Interval {
     *     int start;
     *     int end;
     *     Interval() { start = 0; end = 0; }
     *     Interval(int s, int e) { start = s; end = e; }
     * }
     */
    class Solution {
        public List<Interval> merge(List<Interval> intervals) {
            List<Interval> result = new ArrayList<Interval>();
            if (intervals.size() == 0)
                return result;
            // sort the interval list
            /**
             * 这里需要注意sort的用法
             * */
            intervals.sort((i1,i2)->Integer.compare(i1.start,i2.start));
            Interval last = new Interval();
            last.start = intervals.get(0).start;
            last.end = intervals.get(0).end;


            // merge
            for (Interval k: intervals){
                if (k.start == last.start && k.end == last.end)
                    continue;
                if (last.end >= k.start){
                    last.end = Math.max(last.end,k.end);
                }
                else{
                    result.add(new Interval(last.start,last.end));
                    last.start = k.start;
                    last.end = k.end;
                }
            }
            if (result.size() == 0||last.start != result.get(result.size()-1).start && last.end != result.get(result.size()-1).end)
                result.add(new Interval(last.start,last.end));
            return result;
        }
    }
}
