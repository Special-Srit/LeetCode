class MaxProfitFinder {
    static class Solution {
        public int maxProfit(int[] prices) {
            int buyPrice = prices[0];
            int maxProfit = 0;

            for (int i = 1; i < prices.length; i++) {
                if (prices[i] < buyPrice) {
                    buyPrice = prices[i];
                } else {
                    int profit = prices[i] - buyPrice;
                    maxProfit = Math.max(maxProfit, profit);
                }
            }

            return maxProfit;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxProfit(new int[]{1,2}));
    }
}