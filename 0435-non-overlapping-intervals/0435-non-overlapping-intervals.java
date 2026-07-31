class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int lastFinish = -(int)1e8;
        int count = 0;

        for(int interval[] : intervals){
            if (interval[0] >= lastFinish) {
                lastFinish = interval[1];
            }
            else{
                count++;
            }
        }
        return count;
    }
}