import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String s, int index, int parts, StringBuilder path, List<String> result) {

        if (parts == 4 && index == s.length()) {
            result.add(path.toString());
            return;
        }

        if (parts == 4 || index == s.length()) return;

        int len = path.length();

        for (int i = 1; i <= 3 && index + i <= s.length(); i++) {

            String part = s.substring(index, index + i);

            if (part.length() > 1 && part.charAt(0) == '0') continue;

            int val = Integer.parseInt(part);
            if (val > 255) continue;

            if (parts > 0) path.append(".");
            path.append(part);

            backtrack(s, index + i, parts + 1, path, result);

            path.setLength(len);
        }
    }
}
