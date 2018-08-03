public class MeetingRoom_252 {
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
        public boolean canAttendMeetings(Interval[] intervals) {
            if (intervals.length == 0 || intervals.length == 1)
                return true;
            Arrays.sort(intervals, new Comparator<Interval>(){
                public int compare(Interval a, Interval b){
                    if (a.start == b.start)
                        return 0;
                    if (a.start > b.start)
                        return 1;
                    else
                        return -1;
                }
            });

            //注意此处的条件边界
            int max = intervals[0].end;
            for(int i=1;i<intervals.length;i++){
                if (intervals[i].start < max)
                    return false;
                else
                    max = intervals[i].end;
            }
            return true;
        }
    }
}
