class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int NEG = -1_000_000_000; // safe negative value

        int[][] dp = new int[n + 1][m + 1];

        // Initialize DP with large negative values
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = NEG;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int prod = nums1[i - 1] * nums2[j - 1];

                int take = prod;
                if (dp[i - 1][j - 1] != NEG) {
                    take = Math.max(take, prod + dp[i - 1][j - 1]);
                }

                dp[i][j] = Math.max(
                        take,
                        Math.max(dp[i - 1][j], dp[i][j - 1])
                );
            }
        }

        return dp[n][m];
    }
}
