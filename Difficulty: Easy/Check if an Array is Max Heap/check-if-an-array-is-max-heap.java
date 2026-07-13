class Solution {
    public boolean isMaxHeap(int[] arr) {
        // code here
        int root=0;
        boolean isValid=true;
        while(root<arr.length){
            int left=2*root+1;
            int right=2*root+2;
            
            if(left>arr.length-1 && right > arr.length-1){
                break;
            }
            
            if(left<arr.length && arr[left]>arr[root] ||right<arr.length && arr[right]>arr[root]){
                isValid=false;
                break;
            }
            root++;
        }
        return isValid;
    }
}