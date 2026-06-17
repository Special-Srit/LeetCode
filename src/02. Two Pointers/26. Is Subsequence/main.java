class ClassName {
    static class Solution {
        public boolean isSubsequence(String s, String t) {
            int i = 0, j = 0;
            while (i < s.length() && j < t.length()) {
                if (s.charAt(i) == t.charAt(j)) {
                    i++;
                }
                j++;
            }
            return i == s.length();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();  
        String s = "abc";
        String t = "ahbgdc";
        boolean result = sol.isSubsequence(s, t);
        System.out.println(result);
    }
}