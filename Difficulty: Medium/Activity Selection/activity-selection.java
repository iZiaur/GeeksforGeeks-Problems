import java.util.*;
class Solution {
    public int activitySelection(int[] start, int[] finish) {
        // code here
        int arr[][]=new int[finish.length][3];
        
        for(int i=0;i<finish.length;i++){
            arr[i][0]=i;//orignal index
            arr[i][1]=start[i];
            arr[i][2]=finish[i];
        }
        Arrays.sort(arr,Comparator.comparingDouble(o->o[2]));
        
        int max=1;
        // System.out.println(arr[0][2]);
        int last_time=arr[0][2];
        
        for(int i=1;i<arr.length;i++){
            if(arr[i][1]>last_time){
                max++;
                // System.out.println("Current last time :" +last_time);
                last_time=arr[i][2];
                // System.out.println("Updated last time :"+last_time);
            }
        }
        
        return max;
    }
}
