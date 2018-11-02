/* Find the minimum number of conference rooms required */
public int minMeetingRooms(Interval[] intervals) {
    if(intervals == null || intervals.length == 0) return 0;
 
    Arrays.sort(intervals, new Comparator<Interval>(){
        public int compare(Interval a, Interval b){
            return a.start-b.start;
        }
    });
 
    PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
    int count = 1;
    queue.offer(intervals[0].end); //Start time of first meeting
 
    for(int i=1; i<intervals.length; i++){
        
        if(intervals[i].start < queue.peek()) count++; //if start time of next meeting is less than end time of previous meeting we need more conference room
        else queue.poll(); //else we do not require another room to start the next meeting
 
        queue.offer(intervals[i].end); //again add the end time of the current meeting
    }
 
    return count;
}