class Solution {
    static int solve(int bt[]) {
        // code here
        Arrays.sort(bt);
        int waitingsum=0;
        int runningsum=0;
        for(int i=0;i<bt.length;i++){
            waitingsum+=runningsum;
            runningsum+=bt[i];
            
        }
        
        int res=waitingsum/bt.length;
        return res;
    }
}
