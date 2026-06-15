class ContainerWithMostWater {
    static class Solution {
        public int maxArea(int[] height) {
            int left = 0, right = height.length - 1;
            int maxArea = 0;

            while (left < right) {
                int currentArea = Math.min(height[left], height[right]) * (right - left);
                maxArea = Math.max(maxArea, currentArea);

                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }
            }

            return maxArea;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = sol.maxArea(height);
        System.out.println("Maximum area of water that can be contained: " + result);
    }
}