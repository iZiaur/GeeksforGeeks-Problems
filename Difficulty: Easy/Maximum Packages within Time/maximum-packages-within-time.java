class Solution {
    public int maxPackages(int[] arr, int totalTime) {
        // code here
        int k=totalTime;
        if(arr.length<=totalTime){
            int sum=0;
            for(int i=0;i<arr.length;i++){
                sum+=arr[i];
            }
            return sum;
        }
        int max=0;
        int sum=0;
        int left=0;
        for(int right=0;right<arr.length;right++){
            sum+=arr[right];
            if(right>=k-1){
                max=Math.max(max,sum);
                sum=sum-arr[left];
                left++;
            }
        }
        
        return max;
    }
}