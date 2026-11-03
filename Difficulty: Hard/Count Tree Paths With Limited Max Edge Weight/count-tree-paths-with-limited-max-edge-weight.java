class Solution {
    static class Query implements Comparable<Query> {
        int x, index;
        Query(int x, int index) {
            this.x = x;
            this.index = index;
        }
        @Override
        public int compareTo(Query other) {
            return Integer.compare(this.x, other.x);
        }
    }

    private int[] parent;
    private int[] size;

    private int find(int i) {
        if (parent[i] == i)
            return i;
        return parent[i] = find(parent[i]);
    }

    public ArrayList<Integer> maximumWeight(int n, int[][] edges, int[] queries) {
        // Sort edges by weight
        java.util.Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        // Prepare queries with their original indices
        int q = queries.length;
        Query[] qArr = new Query[q];
        for (int i = 0; i < q; i++) {
            qArr[i] = new Query(queries[i], i);
        }
        java.util.Arrays.sort(qArr);

        // Initialize DSU
        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        ArrayList<Integer> ansList = new ArrayList<>(Collections.nCopies(q, 0));
        int edgeIndex = 0;
        int totalPaths = 0;

        for (int i = 0; i < q; i++) {
            int maxX = qArr[i].x;
            
            // Add all edges with weight <= maxX
            while (edgeIndex < edges.length && edges[edgeIndex][2] <= maxX) {
                int u = edges[edgeIndex][0];
                int v = edges[edgeIndex][1];
                int rootU = find(u);
                int rootV = find(v);

                if (rootU != rootV) {
                    totalPaths += size[rootU] * size[rootV];
                    parent[rootV] = rootU;
                    size[rootU] += size[rootV];
                }
                edgeIndex++;
            }
            ansList.set(qArr[i].index, totalPaths);
        }

        return ansList;
    }
}