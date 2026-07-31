class Solution {

    public int recursion(int ind, int nums[], int dp[]){

         if (ind >= nums.length - 1) {
        return 0;
    }

    if (dp[ind] != -1) {
        return dp[ind];
    }

    int mini = (int) 1e9;

    for (int i = 1; i <= nums[ind]; i++) {

        if (ind + i < nums.length) {

            mini = Math.min(
                mini,
                1 + recursion(ind + i, nums, dp)
            );
        }
    }

    return dp[ind] = mini;
    }

    public int jump(int[] nums) {
        
        int n = nums.length;
        int dp[] = new int[n];

        Arrays.fill(dp, -1);
        
        int ans = recursion(0, nums, dp);
        return ans;
    }
}