import java.util.*;

class Solution {
    public int[] finalPrices(int[] prices) {

        int n = prices.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = prices[i];
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                int idx = stack.pop();
                ans[idx] = prices[idx] - prices[i];
            }

            stack.push(i);
        }

        return ans;
    }
}
