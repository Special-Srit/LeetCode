import java.util.*;

class SubstringWithConcatenationOfAllWords {
    static class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> result = new ArrayList<>();
            if (s == null || s.length() == 0 || words == null || words.length == 0) return result;

            int wordLength = words[0].length();
            int totalWords = words.length;
            int n = s.length();

            Map<String, Integer> wordToId = new HashMap<>();
            for (String word : words) {
                if (!wordToId.containsKey(word)) wordToId.put(word, wordToId.size());
            }
            int numUnique = wordToId.size();

            int[] required = new int[numUnique];
            for (String word : words) required[wordToId.get(word)]++;

            int[] wordIds = new int[n];
            Arrays.fill(wordIds, -1);
            for (int i = 0; i + wordLength <= n; i++) {
                Integer id = wordToId.get(s.substring(i, i + wordLength));
                if (id != null) wordIds[i] = id;
            }

            for (int offset = 0; offset < wordLength; offset++) {
                int[] window = new int[numUnique];
                int left = offset, count = 0;

                for (int right = offset; right + wordLength <= n; right += wordLength) {
                    int id = wordIds[right];

                    if (id != -1) {
                        window[id]++;
                        count++;

                        while (window[id] > required[id]) {
                            window[wordIds[left]]--;
                            count--;
                            left += wordLength;
                        }

                        if (count == totalWords) {
                            result.add(left);
                            window[wordIds[left]]--;
                            count--;
                            left += wordLength;
                        }
                    } else {
                        Arrays.fill(window, 0);
                        count = 0;
                        left = right + wordLength;
                    }
                }
            }

            return result;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));  // [0, 9]
        System.out.println(sol.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"}));  // []
        System.out.println(sol.findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"}));  // [6, 9, 12]
    }
}
