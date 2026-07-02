class Solution {
    public void rearrangeQueue(Queue<Integer> q) {
        // code here
     Queue<Integer> first=new ArrayDeque<>();
     int orgsize=q.size();
     for(int i=0;i<orgsize/2;i++)
     {  int top=q.peek();
         first.add(top);
         q.remove();
     }
     
     while(!first.isEmpty()){
         q.add(first.remove());
         q.add(q.remove());
     }
    }
}
