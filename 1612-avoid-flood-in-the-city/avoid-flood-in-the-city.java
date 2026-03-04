import java.util.*;

class Solution {

    public int[] avoidFlood(int[] rains) {

        int n = rains.length;

        int[] ans = new int[n];

        Map<Integer, Integer> last = new HashMap<>();

        TreeSet<Integer> dryDays = new TreeSet<>();

        for (int i = 0; i < n; i++) {

            if (rains[i] == 0) {

                dryDays.add(i);
                ans[i] = 1;

            } else {

                int lake = rains[i];
                ans[i] = -1;

                if (last.containsKey(lake)) {

                    Integer dry = dryDays.ceiling(last.get(lake) + 1);

                    if (dry == null)
                        return new int[0];

                    ans[dry] = lake;
                    dryDays.remove(dry);
                }

                last.put(lake, i);
            }
        }

        return ans;
    }
}