import java.util.*;

class Solution {

    static int[] parent;

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {

        int n = deadline.length;
        int[][] arr = new int[n][2];
        int maxDeadline = 0;

        for (int i = 0; i < n; i++) {
            arr[i][0] = profit[i];
            arr[i][1] = deadline[i];
            maxDeadline = Math.max(maxDeadline, deadline[i]);
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(b[0], a[0]));

        parent = new int[maxDeadline + 1];
        for (int i = 0; i <= maxDeadline; i++) {
            parent[i] = i;
        }

        int jobs = 0;
        int totalProfit = 0;

        for (int i = 0; i < n; i++) {
            int slot = find(arr[i][1]);

            if (slot > 0) {
                jobs++;
                totalProfit += arr[i][0];
                parent[slot] = find(slot - 1);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(jobs);
        ans.add(totalProfit);

        return ans;
    }
}