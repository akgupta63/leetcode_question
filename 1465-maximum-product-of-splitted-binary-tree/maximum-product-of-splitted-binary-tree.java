class Solution {
    private long totalSum = 0;
    private long maxProduct = 0;
    private static final int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        // Step 1: get total sum of tree
        totalSum = getSum(root);

        // Step 2: compute max product
        getSubtreeSum(root);

        return (int)(maxProduct % MOD);
    }

    // DFS to compute total sum
    private long getSum(TreeNode node) {
        if (node == null) return 0;
        return node.val + getSum(node.left) + getSum(node.right);
    }

    // DFS to compute subtree sums and products
    private long getSubtreeSum(TreeNode node) {
        if (node == null) return 0;

        long left = getSubtreeSum(node.left);
        long right = getSubtreeSum(node.right);

        long subSum = node.val + left + right;

        // Product if we cut above this subtree
        long product = subSum * (totalSum - subSum);
        maxProduct = Math.max(maxProduct, product);

        return subSum;
    }
}
