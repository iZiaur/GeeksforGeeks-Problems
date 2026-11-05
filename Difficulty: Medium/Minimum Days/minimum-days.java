class Solution {
    public int getMinimumDays(String s, int[] p) {
        int n = s.length();
        int l = 0, r = n;

        while (l < r) {
            int m = l + (r - l) / 2;
            boolean[] vis = new boolean[n];

            for (int i = 0; i < m; i++) {
                vis[p[i]] = true;
            }

            boolean ok = true;

            for (int i = 0; i < n - 1; i++) {
                if (!vis[i] && !vis[i + 1] &&
                    s.charAt(i) == s.charAt(i + 1)) {
                    ok = false;
                    break;
                }
            }

            if (ok)
                r = m;
            else
                l = m + 1;
        }

        return l;
    }
}