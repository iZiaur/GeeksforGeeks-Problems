class Solution {
    public static int minCost(int[] arr) {
        // code here
       int totalcost=0;
       PriorityQueue <Integer> pq=new PriorityQueue<>();
       for(int i=0;i<arr.length;i++){
           pq.add(arr[i]);
       }
       
       while(pq.size()!=1){
           int firstel=pq.poll();;
           
           int secondel=pq.poll();;
           totalcost+=firstel+secondel;
           
          
           pq.add(firstel+secondel);
       }
       
       return totalcost;
        
        
        
    }
}