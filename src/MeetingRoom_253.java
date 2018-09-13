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

        class Solution2{
            public int minMeetingRooms(Interval[] intervals) {
                if(intervals == null || intervals.length == 0) return 0;
                Arrays.sort(intervals,(a,b)->a.start-b.start);
                PriorityQueue<Interval> pq = new PriorityQueue<>((a,b)->a.end-b.end);
                pq.add(intervals[0]);

                for(int i=1; i<intervals.length; i++) {
                    // 如果start>当前最小的end
                    //这时不需要add room，取出之前已经用完的房间
                    if(intervals[i].start >= pq.peek().end) {
                        pq.poll();
                    }
                    // 加入房间的新使用时长
                    pq.offer(intervals[i]);
                }
                return pq.size();
            }
        }
    }

    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;

        // Sort the intervals by start time
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) { return a.start - b.start; }
        });

        // Use a min heap to track the minimum end time of merged intervals
        PriorityQueue<Interval> heap = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) { return a.end - b.end; }
        });

        // start with the first meeting, put it to a meeting room
        heap.offer(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            // get the meeting room that finishes earliest
            Interval interval = heap.poll();

            if (intervals[i].start >= interval.end) {
                // if the current meeting starts right after
                // there's no need for a new room, merge the interval
                interval.end = intervals[i].end;
            } else {
                // otherwise, this meeting needs a new room
                heap.offer(intervals[i]);
            }

            // don't forget to put the meeting room back
            heap.offer(interval);
        }

        return heap.size();
    }
}
