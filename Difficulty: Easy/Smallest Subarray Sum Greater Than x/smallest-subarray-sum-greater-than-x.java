class Solution {
    public int smallestSubWithSum(int[] arr, int x) {
        // code here
        int len=Integer.MAX_VALUE;
        
        int left=0;
        int right=0;
        int sum=0;
        while(right<arr.length){
            sum+=arr[right];
            while(sum>x){
                len=Math.min(len,right-left+1);
                sum=sum-arr[left];
                left++;
            }
            right++;
        }
        
        if(len==Integer.MAX_VALUE){
            return 0;
        }
        return len;
    }
}