class Solution {
    static String preToInfix(String pre_exp) {
        // code here
    Stack<String> st=new Stack<>();
    int i=pre_exp.length()-1;
    while(i>=0){
        char ch=pre_exp.charAt(i);
        if(ch>='a' && ch<='z' || ch>='A' && ch<='Z' || ch>='0' && ch<='9'){
            st.push(String.valueOf(ch));
        }else{
            if(!st.isEmpty());
            String top1=st.pop();
            String top2=st.pop();
            String con='('+top1+ch+top2+')';
            st.push(con);
        }
        i--;
    }
        return st.peek();
    }
}
