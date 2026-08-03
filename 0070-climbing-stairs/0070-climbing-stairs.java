class Solution {
    public int memo(int n, int dp[]){
        if (n == 0) {
            return 1;
        }
        if (n<0) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }

        int n1 = memo(n-1, dp);
        int n2 = memo(n-2, dp);

        return dp[n] = n1+n2;

    }

    public int climbStairs(int n) {

        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        int ans = memo(n, dp);
        return ans;
    }
}