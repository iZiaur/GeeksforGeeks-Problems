class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        // code here
        
        double arr[][]=new double[val.length+1][3];
        
        for(int i=0;i<val.length;i++){
            arr[i][0]=val[i]/((double)wt[i]);
            arr[i][1]=val[i];
            arr[i][2]=wt[i];
        }
        
        Arrays.sort(arr,Comparator.comparingDouble(o->o[0]));
        
        double cap=capacity;
        double value=0;
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i][2]<=cap){
                cap=cap-arr[i][2];
                value+=arr[i][1];
            }else{
                value=value+(arr[i][0]*cap);
                break;
            }
        }
        return Double.parseDouble(String.format("%.6f", value));
        
    }
}