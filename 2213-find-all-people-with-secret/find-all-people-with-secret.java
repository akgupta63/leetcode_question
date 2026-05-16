import java.util.*;

class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);

        boolean[] know = new boolean[n];
        know[0] = true;
        know[firstPerson] = true;

        int i = 0;

        while (i < meetings.length) {
            int time = meetings[i][2];

            Map<Integer, List<Integer>> graph = new HashMap<>();
            Set<Integer> people = new HashSet<>();

            while (i < meetings.length && meetings[i][2] == time) {
                int x = meetings[i][0];
                int y = meetings[i][1];

                graph.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
                graph.computeIfAbsent(y, k -> new ArrayList<>()).add(x);

                people.add(x);
                people.add(y);

                i++;
            }

            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();

            for (int person : people) {
                if (know[person]) {
                    queue.offer(person);
                    visited.add(person);
                }
            }

            while (!queue.isEmpty()) {
                int curr = queue.poll();
                know[curr] = true;

                for (int next : graph.getOrDefault(curr, new ArrayList<>())) {
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int j = 0; j < n; j++) {
            if (know[j]) {
                result.add(j);
            }
        }

        return result;
    }
}