class Solution {
    static String postToPre(String s) {
        // code here
    Stack<String> st=new Stack<>();
    int i=0;
    while(i<s.length()){
        char ch=s.charAt(i);
        if(ch>='a' && ch<='z' || ch>='A' && ch<='Z' || ch>='0' && ch<='9'){
            st.push(String.valueOf(ch));
        }else{
            if(!st.isEmpty()){
                String top1=st.pop();
                String top2=st.pop();
                String con=ch+top2+top1;
                st.push(con);
            }
        }
        i++;
    }
    return st.peek();
    }
}
