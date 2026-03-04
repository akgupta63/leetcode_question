import java.util.*;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {

        Arrays.sort(potions);

        int n = spells.length;
        int m = potions.length;

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {

            long need = (success + spells[i] - 1) / spells[i];

            int left = 0, right = m - 1, pos = m;

            while (left <= right) {

                int mid = (left + right) / 2;

                if (potions[mid] >= need) {
                    pos = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            result[i] = m - pos;
        }

        return result;
    }
}