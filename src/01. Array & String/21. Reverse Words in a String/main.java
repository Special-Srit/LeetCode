import java.util.*;

class reverseWordsInAString {
    static class Solution {
        public String reverseWords(String s) {
            s = s.trim();
            String[] words = s.split("\\s+");
            Collections.reverse(Arrays.asList(words));
            return String.join(" ", words);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "Hello World";
        String reversed = sol.reverseWords(s);
        System.out.println(reversed);
    }
}