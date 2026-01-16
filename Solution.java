import java.util.*;

class Solution {
    public int minMen(int arr[]) {
        int n = arr.length;
        List<int[]> intervals = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (arr[i] != -1) {
                int l = Math.max(0, i - arr[i]);
                int r = Math.min(n - 1, i + arr[i]);
                intervals.add(new int[]{l, r});
            }
        }

        intervals.sort((a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        int count = 0;
        int idx = 0;
        int currentEnd = 0;
        int maxReach = 0;

        while (currentEnd < n) {
            boolean found = false;

            while (idx < intervals.size() && intervals.get(idx)[0] <= currentEnd) {
                maxReach = Math.max(maxReach, intervals.get(idx)[1] + 1);
                idx++;
                found = true;
            }

            if (!found) return -1;

            count++;
            currentEnd = maxReach;
        }

        return count;
    }
}
