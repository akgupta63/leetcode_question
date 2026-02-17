import java.util.*;

class Solution {
    public boolean isScramble(String s1, String s2) {
        Map<String, Boolean> memo = new HashMap<>();
        return solve(s1, s2, memo);
    }

    private boolean solve(String s1, String s2, Map<String, Boolean> memo) {
        String key = s1 + "#" + s2;
        if (memo.containsKey(key)) return memo.get(key);

        if (s1.equals(s2)) {
            memo.put(key, true);
            return true;
        }

        if (!sameChars(s1, s2)) {
            memo.put(key, false);
            return false;
        }

        int n = s1.length();

        for (int i = 1; i < n; i++) {

            if (solve(s1.substring(0, i), s2.substring(0, i), memo) &&
                solve(s1.substring(i), s2.substring(i), memo)) {
                memo.put(key, true);
                return true;
            }

            if (solve(s1.substring(0, i), s2.substring(n - i), memo) &&
                solve(s1.substring(i), s2.substring(0, n - i), memo)) {
                memo.put(key, true);
                return true;
            }
        }

        memo.put(key, false);
        return false;
    }

    private boolean sameChars(String a, String b) {
        int[] count = new int[26];

        for (char c : a.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : b.toCharArray()) {
            count[c - 'a']--;
        }

        for (int x : count) {
            if (x != 0) return false;
        }

        return true;
    }
}
