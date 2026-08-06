class Solution {

    List<List<Integer>> list = new ArrayList<>();
    List<Integer> ans = new ArrayList<>();

    public void f(int nums[], List<Integer> ans){
        if (nums.length == 0) {
            list.add(new ArrayList<>(ans));
            return;
        }


        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int curr = nums[i];
            int red_nums[] = new int[n-1];
            int k = 0;
            for (int j = 0; j < nums.length; j++) {
                if (j!=i) {
                    red_nums[k] = nums[j];
                    k++;
                }
            }

            ans.add(curr);
            f(red_nums, ans);
            ans.remove(Integer.valueOf(curr));

        }
    }

    public List<List<Integer>> permute(int[] nums) {
        
        f(nums, new ArrayList<>());
        return list;
    }
}