class Solution {
    public int minPlatform(int arr[], int dep[]) {
        //  code here
        if(arr.length==1){
            return 1;
        }
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int i=1;
        int j=0;
        int platforms=1;
        int ans=1;
        
        while(i<arr.length && j<dep.length){
            
            if(arr[i]<=dep[j]){
                platforms++;
                ans=Math.max(ans,platforms);
                i++;
            }else{
                platforms--;
                j++;
            }
        }
        return ans;
        
    }
}
