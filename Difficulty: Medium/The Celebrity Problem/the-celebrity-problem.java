class Solution {
    public int celebrity(int mat[][]) {
        // code here
        Stack <Integer> st=new Stack<>();
        for(int i=0;i<mat.length;i++){
            st.push(i);
        }
        while(st.size()>1){
            int i=st.pop();
            int j=st.pop();
            if(mat [i] [j]==0){ //Nobody Knows J
                st.push(i);
            }else{
                st.push(j); //I knows J a celebrity doesnt know anyone
            }
        }
        
        int celeb=st.peek();
        
        for(int i=0;i<mat.length;i++){
            if(i!=celeb && (mat[i][celeb]==0 || mat[celeb] [i] ==1 )){
                return -1;
            }
        }
        return celeb;
    }
}