import java.util.*;

class Solution {
    public String removeDuplicateLetters(String s) {

        int n = s.length();
        int[] lastIndex = new int[26];

        for (int i = 0; i < n; i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        boolean[] seen = new boolean[26];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            char ch = s.charAt(i);
            int idx = ch - 'a';

            if (seen[idx]) continue;

            while (!stack.isEmpty()
                    && ch < stack.peek()
                    && lastIndex[stack.peek() - 'a'] > i) {

                char removed = stack.pop();
                seen[removed - 'a'] = false;
            }

            stack.push(ch);
            seen[idx] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}
