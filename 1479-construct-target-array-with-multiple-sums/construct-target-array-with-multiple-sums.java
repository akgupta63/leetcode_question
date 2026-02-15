import java.util.*;

class Solution {
    public boolean isPossible(int[] target) {

        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        long sum = 0;
        for (int num : target) {
            maxHeap.add(num);
            sum += num;
        }

        while (true) {

            int max = maxHeap.poll();
            long rest = sum - max;
            if (max == 1 || rest == 1) return true;

            if (rest == 0 || rest >= max) return false;
            int prev = (int)(max % rest);

            if (prev == 0) return false;
            maxHeap.add(prev);
            sum = rest + prev;
        }
    }
}
