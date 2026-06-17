class LengthOfLastWord {
    static class Solution {
        public int lengthOfLastWord(String s) {
            s = s.trim();
            int lastSpaceIndex = s.lastIndexOf(' ');
            return s.length() - lastSpaceIndex - 1;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "Hello World";
        int length = sol.lengthOfLastWord(s);   
        System.out.println(length);
    }
}