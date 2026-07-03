class Solution {
    public static int priority(char ch){
        if(ch=='^'){
            return 3;
        }else if(ch=='*' || ch=='/'){
            return 2;
        }else if(ch=='+' || ch=='-'){
            return 1;
        }else{
            return -1;
        }
    }
    public String Postfix(StringBuilder s){
        StringBuilder res=new StringBuilder();
        Stack<Character> st=new Stack<>();
        int i=0;
        while(i<s.length()){
            char ch=s.charAt(i);
            if(ch>='a' && ch<='z'|| ch>='A' && ch<='Z' || ch>='0' && ch<='9'){
                res.append(ch);
            }else if(ch=='('){
                st.push(ch);
            }else if(ch==')'){
                while(!st.isEmpty() && st.peek()!='('){
                    res.append(st.pop());
                }
                st.pop();
            }else{
                while(!st.isEmpty() &&(priority(ch)<priority(st.peek())||
                (priority(ch)==priority(st.peek()) && ch=='^'))){
                    res.append(st.pop());
                }
                st.push(ch);
            }
            i++;
        }
        while(!st.isEmpty()){
            res.append(st.pop());
        }
        res=res.reverse();
        return res.toString();
        
    }
    public String infixToPrefix(String s) {
        // code here
        StringBuilder orignalstr=new StringBuilder(s);
        orignalstr.reverse();
        for(int i=0;i<s.length();i++){
            char ch=orignalstr.charAt(i);
            if(ch=='('){
                orignalstr.setCharAt(i,')');
            }
            if(ch==')'){
                orignalstr.setCharAt(i,'(');
            }
        }
        String last=Postfix(orignalstr);
        return last;
        
    }
}