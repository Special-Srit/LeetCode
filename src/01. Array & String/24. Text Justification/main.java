import java.util.*;

class TextJustification {
    static class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            List<String> res = new ArrayList<>();
            int n = words.length;
            int i = 0;
            while (i < n) {
                int j = i + 1;
                int lineLength = words[i].length();
                while (j < n && lineLength + words[j].length() + (j - i) <= maxWidth) {
                    lineLength += words[j].length();
                    j++;
                }
                StringBuilder sb = new StringBuilder();
                int spacesToDistribute = maxWidth - lineLength;
                int gaps = j - i - 1;

                if (gaps == 0 || j >= n) {
                    for (int k = i; k < j; k++) {
                        sb.append(words[k]);
                        if (k < j - 1) sb.append(" ");
                    }
                    while (sb.length() < maxWidth) sb.append(" ");
                } else {
                    int spacePerGap = spacesToDistribute / gaps;
                    int extraSpaces = spacesToDistribute % gaps;

                    for (int k = i; k < j; k++) {
                        sb.append(words[k]);
                        if (k < j - 1) {
                            for (int s = 0; s < spacePerGap; s++) sb.append(" ");
                            if (extraSpaces > 0) {
                                sb.append(" ");
                                extraSpaces--;
                            }
                        }
                    }
                }
                res.add(sb.toString());
                i = j;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        List<String> justifiedText = sol.fullJustify(words, maxWidth);
        for (String line : justifiedText) {
            System.out.println("\"" + line + "\"");
        }
    }
}