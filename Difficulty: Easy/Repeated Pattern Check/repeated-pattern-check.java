class Solution {
    public boolean findPattern(String s) {
        // code here
        int x=0;
        int y=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='x'){
                x++;
            }else{
                x--;
            }
            if(x<0){
                return false;
            }
        }
        
        return x==0;
    }
}
