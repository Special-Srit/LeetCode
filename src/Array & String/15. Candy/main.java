import java.util.*;

class ClassName {
    static class Solution {
        public int candy(int[] ratings) {
            int n = ratings.length;
            int[] candies = new int[n];
            Arrays.fill(candies, 1);

            for (int i = 1; i < n; i++) {
                if (ratings[i] > ratings[i - 1]) {
                    candies[i] = candies[i - 1] + 1;
                }
            }

            for (int i = n - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1]) {
                    candies[i] = Math.max(candies[i], candies[i + 1] + 1);
                }
            }

            int totalCandies = 0;
            for (int candy : candies) {
                totalCandies += candy;
            }
            return totalCandies;
        }
    }        

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.candy(new int[]{1, 0, 2}));
        System.out.println(sol.candy(new int[]{1, 2, 2}));
    }
}