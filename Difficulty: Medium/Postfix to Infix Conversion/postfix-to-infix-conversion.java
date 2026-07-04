class Solution {
    static String postToInfix(String exp) {
        // code here
     Stack<String>st=new Stack<>();
     int i=0;
     while(i<exp.length()){
         char ch=exp.charAt(i);
         if(ch>='a' && ch<='z' || ch>='A' && ch<='Z' || ch>='0' && ch<='9'){
             st.push(String.valueOf(ch));
         }else{
             if(!st.isEmpty()){
                 String top1=st.pop();
                 String top2=st.pop();
                 String con='('+top2+ch+top1+')';
                 st.push(con);
             }
         }
         i++;
     }
     return st.peek();
    }
}
