class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
        int n = boxTypes.length;
        Arrays.sort(boxTypes, (a,b) -> b[1] - a[1]);

        int maxUnits = 0;

        for (int i = 0; i < n; i++) {
            if (boxTypes[i][0] <= truckSize) {
                truckSize = truckSize - boxTypes[i][0];
                maxUnits = maxUnits + boxTypes[i][0]*boxTypes[i][1];
            }
            else{
                maxUnits = maxUnits + truckSize*boxTypes[i][1];
                break;
            }
        }

        return maxUnits;
    }
}