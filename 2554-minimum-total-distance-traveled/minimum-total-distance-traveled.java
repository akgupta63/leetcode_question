import java.util.*;

class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {

        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);

        // Expand factories
        List<Integer> list = new ArrayList<>();
        for (int[] f : factory) {
            for (int i = 0; i < f[1]; i++) {
                list.add(f[0]);
            }
        }

        int n = robot.size();
        int m = list.size();

        long[][] dp = new long[n + 1][m + 1];

        for (long[] row : dp) {
            Arrays.fill(row, Long.MAX_VALUE);
        }

        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                // Skip
                dp[i][j] = dp[i][j - 1];

                // Take
                if (dp[i - 1][j - 1] != Long.MAX_VALUE) {
                    long cost = dp[i - 1][j - 1] +
                            Math.abs(robot.get(i - 1) - list.get(j - 1));
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[n][m];
    }
}