class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length, m = mana.length;

        long[] finish = new long[n];

        for (int j = 0; j < m; j++) {

            long start = 0;
            long prefix = 0;

            for (int i = 0; i < n; i++) {
                start = Math.max(start, finish[i] - prefix);
                prefix += (long) skill[i] * mana[j];
            }

            long time = start;

            for (int i = 0; i < n; i++) {
                time += (long) skill[i] * mana[j];
                finish[i] = time;
            }
        }

        return finish[n - 1];
    }
}