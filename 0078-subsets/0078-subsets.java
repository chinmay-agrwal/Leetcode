class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        if (nums.length == 0) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            ans.add(list);
            return ans;
        }
        int n = nums.length;
        int redNums[] = new int[n-1];
        for (int i = 0; i < redNums.length; i++) {
            redNums[i] = nums[i+1];
        }
        List<List<Integer>> rres = subsets(redNums);

        int x = nums[0];
        List<List<Integer>> mres = new ArrayList<>();

        for (List<Integer> list : rres) {
            mres.add(list);
        }
        for (List<Integer> list : rres) {
            List<Integer> listCopy = new ArrayList<>(list);
            listCopy.add(0, x);
            mres.add(listCopy);
        }

        return mres;
    }
}