class Solution {
    public int maximumSubarray(int[] arr) {
        int n = arr.length;
        
        // Base case initialization at index 0
        long noSq = arr[0];
        long sq = (long) arr[0] * arr[0];
        long maxOverall = Math.max(noSq, sq);
        
        for (int i = 1; i < n; i++) {
            long x = arr[i];
            long xSquared = x * x;
            
            // Calculate new state values
            long nextSq = Math.max(xSquared, Math.max(noSq + xSquared, sq + x));
            long nextNoSq = Math.max(x, noSq + x);
            
            // Update state
            sq = nextSq;
            noSq = nextNoSq;
            
            // Update global maximum
            maxOverall = Math.max(maxOverall, Math.max(noSq, sq));
        }
        
        return (int) maxOverall;
    }
}