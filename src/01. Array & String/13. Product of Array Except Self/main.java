import java.util.*;

class ProductExceptSelf {
    static class Solution {
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] result = new int[n];
            result[0] = 1;
            for (int i = 1; i < n; i++) {
                result[i] = result[i - 1] * nums[i - 1];
            }
            int suffixProduct = 1;
            for (int i = n - 1; i >= 0; i--) {
                result[i] *= suffixProduct;
                suffixProduct *= nums[i];
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(sol.productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
    }
}