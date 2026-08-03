class Solution {

    static String codes[] = {"_", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        
        if (digits.length() == 0) {
            List<String> list = new ArrayList<>();
            
            list.add("");
            return list;
        }

        List<String> rres = letterCombinations(digits.substring(1));
        char ch = digits.charAt(0);
        int x = ch - '0';

        List<String> mres = new ArrayList<>();

        for (int i = 0; i < codes[x].length(); i++) {
            for (String rstr : rres) {
                mres.add(codes[x].charAt(i) + rstr);
            }
        }

        return mres;
    }
}
