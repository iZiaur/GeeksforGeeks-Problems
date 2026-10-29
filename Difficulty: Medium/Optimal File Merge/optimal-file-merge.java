class Solution {
    public int minComputation(int[] files) {
        // code here
        int cost=0;
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(int i:files){
            pq.offer(i);
        }
        while(pq.size()!=1){
            int el1=pq.poll();
            int el2=pq.poll();
            cost+=el1+el2;
            pq.offer(el1+el2);
        }
        
        // cost+=pq.poll();
        
        return cost;
    }
}