class Interval{

    int start;
    int end;

    Interval(int start, int end){
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        int n = intervals.length;
        Interval inter[] = new Interval[n];
        for (int i = 0; i < n; i++) {
            inter[i] = new Interval(intervals[i][0], intervals[i][1]);
        }

        Arrays.sort(inter, (a, b) -> a.end - b.end);

        int lastFinish = -(int)1e8;
        int count = 0;

        for(Interval interval : inter){
            if (interval.start >= lastFinish) {
                lastFinish = interval.end;
            }
            else{
                count++;
            }
        }
        return count;
    }
}