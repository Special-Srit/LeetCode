import java.util.*;

class LongestSubstringWithoutRepeatingCharacters {
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            Set<Character> charSet = new HashSet<>();
            int left = 0, maxLength = 0;

            for (int right = 0; right < s.length(); right++) {
                char currentChar = s.charAt(right);
                while (charSet.contains(currentChar)) {
                    charSet.remove(s.charAt(left));
                    left++;
                }
                charSet.add(currentChar);
                maxLength = Math.max(maxLength, right - left + 1);
            }

            return maxLength;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "abcabcbb";
        int length = sol.lengthOfLongestSubstring(s);
        System.out.println(length);
    }
}