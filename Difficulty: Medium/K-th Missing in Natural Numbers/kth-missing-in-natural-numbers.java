import java.util.Arrays;

class Solution {
    public int findKthSmall(int[] arr, int k) {
        // Sort the array to enable binary search for counting elements <= mid
        Arrays.sort(arr);
        
        long low = k;
        long high = (long) k + arr.length;
        long ans = high;
        
        while (low <= high) {
            long mid = low + (high - low) / 2;
            
            // Count how many elements in arr are <= mid using binary search
            long removedCount = countLessOrEqual(arr, mid);
            
            // Number of remaining natural numbers up to mid
            long remainingCount = mid - removedCount;
            
            if (remainingCount >= k) {
                ans = mid;
                high = mid - 1; // Try to find a smaller valid number
            } else {
                low = mid + 1;  // Need a larger number
            }
        }
        
        return (int) ans;
    }
    
    // Helper method to find the number of elements in arr that are <= target
    private int countLessOrEqual(int[] arr, long target) {
        int left = 0, right = arr.length - 1;
        int count = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                count = mid + 1; // All elements from 0 to mid are <= target
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return count;
    }
}