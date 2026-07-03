class Solution {
    public static int priority(char c){
        if(c=='^'){
            return 3;
        }else if(c=='*'|| c=='/'){
            return 2;
        }else if(c=='+' || c=='-'){
            return 1;
        }else {
            return -1;
        }
    }
    public static String infixToPostfix(String s) {
        // code here
        StringBuilder str=new StringBuilder();
        Stack <Character> st=new Stack<>();
        
        int n=s.length();
        int i=0;
        while (i<n){
            char ch=s.charAt(i);
            if(ch>='a' && ch<='z' || ch>='A' && ch<='Z' || ch>='0' && ch<='9'){
                str.append(ch);
            }else if(ch=='('){
                st.push(ch);
            }else if(ch==')'){
                while(!st.isEmpty() && st.peek()!='('){
                    str.append(st.pop());
                }
                if(!st.isEmpty()){
                 st.pop();   
                }
                
            }else{
                while(!st.isEmpty() && (priority(ch) < priority(st.peek()) ||
      (priority(ch) == priority(st.peek()) && ch != '^'))){
                    str.append(st.pop());
                }
                st.push(ch);
            }
            i++;
        }
        while(!st.isEmpty()){
            str.append(st.pop());
        }
        
        return str.toString();
        
    }
}