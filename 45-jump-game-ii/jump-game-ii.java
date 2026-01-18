class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int end = 0;
        int farthest = 0;

        // We don't need to jump from last index
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            // When we reach the end of current jump range
            if (i == end) {
                jumps++;
                end = farthest;
            }
        }
        return jumps;
    }
}
