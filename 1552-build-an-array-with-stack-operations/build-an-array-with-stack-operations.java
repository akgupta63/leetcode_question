import java.util.*;

class Solution {
    public List<String> buildArray(int[] target, int n) {

        List<String> ops = new ArrayList<>();
        int curr = 1;

        for (int x : target) {

            while (curr < x) {
                ops.add("Push");
                ops.add("Pop");
                curr++;
            }

            ops.add("Push");
            curr++;
        }

        return ops;
    }
}
