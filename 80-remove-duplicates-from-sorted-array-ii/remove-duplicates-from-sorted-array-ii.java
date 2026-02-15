class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0; // pointer for valid position

        for (int i = 0; i < nums.length; i++) {

            // First two elements are always allowed
            if (k < 2 || nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}
