/* Determine if a person can attend all the meetings given [start_time, end_time] */
public boolean canAttendMeetings(Interval[] intervals) {
    Arrays.sort(intervals, new Comparator<Interval>(){ //Sort an intervals array of [start_time, end_time]
        public int compare(Interval a, Interval b){
            return a.start-b.start;
        }
    });
 
    for(int i=0; i<intervals.length-1; i++){
        if(intervals[i].end>intervals[i+1].start){ //If end time of next meeting is greater than start time of the previous meeting he cannot attend all the meetings
            return false;
        }
    }
 
    return true;
}