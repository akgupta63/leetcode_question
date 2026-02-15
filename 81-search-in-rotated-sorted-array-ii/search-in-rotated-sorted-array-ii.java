class Solution {
    public boolean search(int[] arr, int k) {
                for (int x : arr) {
            if (x == k) {
                return true;
            }
        }
        
        return false;
    }
}
