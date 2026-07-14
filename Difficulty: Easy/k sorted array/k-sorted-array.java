class Solution {
    static String isKSortedArray(int arr[], int n, int k) {
        // code here
        
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }
        Arrays.sort(arr);
      
      boolean isValid=true;
      
      for(int i=0;i<arr.length;i++){
          int sortindex=i;
          int givenindex=map.get(arr[i]);
          
          if(Math.abs(sortindex-givenindex)>k){
              isValid=false;
              break;
          }
      }
      
      if(isValid){
          return "Yes";
      }
      else{
           return "No";
      }
     
    }
}