class Solution {
    public String firstNonRepeating(String s) {
        // code here
        
        
        StringBuilder res=new StringBuilder();
        int freqarr[]=new int[26];
        Queue<Character> q =new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            freqarr[ch-'a']++;
            q.add(ch);
            while(!q.isEmpty() && freqarr[q.peek()-'a']>1){
                q.remove();
            }
            if(q.isEmpty()){
                res.append("#");
            }else{
                res.append(q.peek());
            }
        }
        return res.toString();
    }
}