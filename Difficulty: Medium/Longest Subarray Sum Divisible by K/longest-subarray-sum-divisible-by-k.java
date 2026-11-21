import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestSubarrayDivK(int[] arr, int k) {
        Map<Integer, Integer> firstIndexOfRem = new HashMap<>();
        
        firstIndexOfRem.put(0, -1);

        long prefixSum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            int rem = (int) (prefixSum % k);
            if (rem < 0) {
                rem += k;
            }

            if (firstIndexOfRem.containsKey(rem)) {
                maxLen = Math.max(maxLen, i - firstIndexOfRem.get(rem));
            } else {
                
                firstIndexOfRem.put(rem, i);
            }
        }

        return maxLen;
    }
}