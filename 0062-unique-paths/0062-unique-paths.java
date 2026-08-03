class Solution {
    public int memo(int m, int n, int dp[][]){
        if (m==0 && n==0) {
            return 1;
        }
        if (m<0 || n<0) {
            return 0;
        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        int h = memo(m, n-1, dp);
        int v = memo(m-1, n, dp);

        return dp[m][n] = h+v;
    }

    public int uniquePaths(int m, int n) {
        
        int dp[][] = new int[m][n];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = memo(m-1, n-1, dp);
        return ans;

    }
}