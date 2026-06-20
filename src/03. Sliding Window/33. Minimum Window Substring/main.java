import java.util.*;

class MinimumWindowSubstring {
    static class Solution {
       public String minWindow(String s, String t) {
            if (s == null || s.length() == 0 || t == null || t.length() == 0) return "";

            Map<Character, Integer> required = new HashMap<>();
            for (char c : t.toCharArray()) required.put(c, required.getOrDefault(c, 0) + 1);

            int left = 0, count = 0;
            int minLength = Integer.MAX_VALUE, minStart = 0;

            for (int right = 0; right < s.length(); right++) {
                char c = s.charAt(right);
                if (required.containsKey(c)) {
                    required.put(c, required.get(c) - 1);
                    if (required.get(c) >= 0) count++;
                }

                while (count == t.length()) {
                    if (right - left + 1 < minLength) {
                        minLength = right - left + 1;
                        minStart = left;
                    }

                    char leftChar = s.charAt(left);
                    if (required.containsKey(leftChar)) {
                        required.put(leftChar, required.get(leftChar) + 1);
                        if (required.get(leftChar) > 0) count--;
                    }
                    left++;
                }
            }

            return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String result = sol.minWindow(s, t);
        System.out.println(result); // Output: "BANC"
    }
}