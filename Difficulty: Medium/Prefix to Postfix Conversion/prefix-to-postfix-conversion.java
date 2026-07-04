class Solution {
    static String preToPost(String s) {
        // code here
    Stack<String> st=new Stack<>();
    int i=s.length()-1;
    while(i>=0){
        char ch=s.charAt(i);
        if(ch>='a' && ch<='z' || ch>='A' && ch<='Z' || ch>='0' && ch<='9'){
            st.push(String.valueOf(ch));
        }else{
            if(!st.isEmpty()){
                String top1=st.pop();
                String top2=st.pop();
                String con=top1+top2+ch;
                st.push(con);
            }
        }
        i--;
    }
    return st.peek();
    }
}