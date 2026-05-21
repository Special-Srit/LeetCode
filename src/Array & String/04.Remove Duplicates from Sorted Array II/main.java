import java.util.*;

class RemoveDuplicatesFromSortedArrayII {
    static class Solution {
        public int removeDuplicates(int[] nums) {
            int k = 0;
            for (int i = 0; i < nums.length; i++) {
                if(i < 2 || nums[i] != nums[k-2]) {
                    nums[k] = nums[i];
                    k++;
                }
            }
            System.out.println(Arrays.toString(nums));
            return k;
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int a =sol.removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3});
        System.out.println(a);
    }
}