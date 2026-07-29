class Solution {
    public ArrayList<Integer> maxMeetings(int[] s, int[] f) {
        // code here
        ArrayList <Integer> sol=new ArrayList<>();
        int arr[][]=new int[s.length][3];
        
        for(int i=0;i<s.length;i++){
            arr[i][0]=s[i];
            arr[i][1]=f[i];
            arr[i][2]=i+1;
        }
        
        Arrays.sort(arr,Comparator.comparingInt(o->o[1]));
        
        sol.add(arr[0][2]);
        
        int endtime=arr[0][1];
        
        for(int i=1;i<s.length;i++){
            if(arr[i][0]>endtime){
                sol.add(arr[i][2]);
                endtime=arr[i][1];
            }
        }
        Collections.sort(sol);
        
        return  sol;
    }
}