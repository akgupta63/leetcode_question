class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] count = new int[26];

        for (char c : text.toCharArray()) {
            count[c - 'a']++;
        }

        count['l' - 'a'] /= 2;
        count['o' - 'a'] /= 2;

        return Math.min(
                Math.min(count['b' - 'a'], count['a' - 'a']),
                Math.min(count['l' - 'a'],
                Math.min(count['o' - 'a'], count['n' - 'a']))
        );
    }
}