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
        if(intervals.size() <= 1) return intervals;
        
        Collections.sort(intervals, new Comparator<Interval>() {
           public int compare(Interval a, Interval b) {
               if(a.start != b. start) {
                   return a.start - b. start;
               }
               return a.end - b.end;
           } 
        });
        
        ListIterator<Interval> iter = intervals.listIterator();
        Interval cur = iter.next();
        while(iter.hasNext()) {
            Interval next = iter.next();
            if(cur.end < next.start) {
                cur = next;
                continue;
            } else {
                cur.end = Math.max(cur.end, next.end);
                iter.remove();
            }
        }
        return intervals;
    }
}