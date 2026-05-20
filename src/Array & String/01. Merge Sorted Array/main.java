import java.util.*;

class MergeSortedArray {
    static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int j = 1;
            for (int i = m; i <= m+n-1; i++) {
                nums1[i] = nums2[j-1];
                j++;
            }
            Arrays.sort(nums1);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        sol.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
