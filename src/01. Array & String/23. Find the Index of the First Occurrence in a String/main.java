class findTheIndexOfTheFirstOccurrenceInAString {
    static class Solution {
        public int strStr(String haystack, String needle) {
            if (needle.isEmpty()) return 0;

            for (int i = 0; i <= haystack.length() - needle.length(); i++) {
                if (haystack.substring(i, i + needle.length()).equals(needle)) {
                    return i;
                }
            }

            return -1;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String haystack = "hello";
        String needle = "ll";
        System.out.println(sol.strStr(haystack, needle));
    }
}