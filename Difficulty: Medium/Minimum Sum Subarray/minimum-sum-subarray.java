class Solution {
    public int minSubarraySum(int[] arr) {
        // code here
        int min=arr[0];
        int csum=arr[0];
        for(int i=1;i<arr.length;i++){
            csum=Math.min(arr[i],csum+arr[i]);
            min=Math.min(min,csum);
        }
        
        return min;
    }
}