import java.util.*;

class RemoveElement {
    static class Solution {
        public int removeElement(int[] nums, int val) {
            int k = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != val) {
                    nums[k] = nums[i];
                    k++;
                }
            }
            return k;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int k = sol.removeElement(nums, val);
        System.out.println("k: " + k);
        System.out.println("nums: " + Arrays.toString(nums));
    }
}
