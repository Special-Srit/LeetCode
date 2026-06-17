import java.util.*;

class HIndex {
    static class Solution {
        public int hIndex(int[] citations) {
            Arrays.sort(citations);
            int n = citations.length;
            int hIndex = 0;

            for (int i = 0; i < n; i++) {
                int hCandidate = Math.min(citations[i], n - i);
                hIndex = Math.max(hIndex, hCandidate);
            }

            return hIndex;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.hIndex(new int[]{3, 0, 6, 1, 5}));
    }
}