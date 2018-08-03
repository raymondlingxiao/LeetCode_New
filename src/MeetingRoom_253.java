public class MeetingRoom_253 {
    public class Solution {
        public int minMeetingRooms(Interval[] intervals) {
            int[] starts = new int[intervals.length];
            int[] ends = new int[intervals.length];
            for(int i=0; i<intervals.length; i++) {
                starts[i] = intervals[i].start;
                ends[i] = intervals[i].end;
            }
            Arrays.sort(starts);
            Arrays.sort(ends);
            int rooms = 0;
            int endsItr = 0;
            for(int i=0; i<starts.length; i++) {
                if(starts[i]<ends[endsItr])
                    rooms++;
                else
                    endsItr++;
            }
            return rooms;
        }
    }
}
