class Solution {
    private double[][] memo;

    public double soupServings(int n) {
        // Optimization: probability converges to 1
        if (n >= 4800) return 1.0;

        int m = (n + 24) / 25; // scale down
        memo = new double[m + 1][m + 1];

        return dfs(m, m);
    }

    private double dfs(int a, int b) {
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1.0;
        if (b <= 0) return 0.0;

        if (memo[a][b] > 0) return memo[a][b];

        memo[a][b] = 0.25 * (
                dfs(a - 4, b) +
                dfs(a - 3, b - 1) +
                dfs(a - 2, b - 2) +
                dfs(a - 1, b - 3)
        );

        return memo[a][b];
    }
}
