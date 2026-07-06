class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        // code here
        Stack<Integer> st=new Stack<>();
        ArrayList<Integer> sol=new ArrayList<>();
        int prevhigh[]=new int[arr.length];
        int n=arr.length;
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]<=arr[i]){
                st.pop();
            }if(st.isEmpty()){
                prevhigh[i]=-1;
            }else{
                prevhigh[i]=st.peek();
                
            }
            st.push(i);
        }
        for(int i=0;i<n;i++){
            sol.add(i-prevhigh[i]);
        }
        return sol;
    }
}