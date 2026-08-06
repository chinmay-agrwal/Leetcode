class Solution {

    List<List<Integer>> list = new ArrayList<>();

    public void f(int nums[], boolean vis[], List<Integer> ans){
        if (ans.size() == nums.length) {
            list.add(new ArrayList<>(ans));
            return;
        }


        int n = nums.length;
        for (int i = 0; i < n; i++) {
            
            if (vis[i] == false) {
                vis[i] = true;
                int curr = nums[i];
                
                ans.add(curr);
                f(nums, vis, ans);
                ans.remove(ans.size() - 1);
                vis[i] = false;
            }

        }
    }

    public List<List<Integer>> permute(int[] nums) {
        
        int n = nums.length;
        boolean vis[] = new boolean[n];
        f(nums, vis, new ArrayList<>());
        return list;
    }
}