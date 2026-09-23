class Solution {
    
    public boolean dfsutil(int i,ArrayList<ArrayList<Integer>> adj,Stack<Integer>st,boolean[]stack,boolean[]visited){
        visited[i]=true;
        stack[i]=true;
        
        ArrayList<Integer>temp=adj.get(i);
        for(int j=0;j<temp.size();j++){
            
            if(stack[temp.get(j)]){
                return true;
            }
            
            if(!visited[temp.get(j)] && dfsutil(temp.get(j),adj,st,stack,visited)){
                return true;
            }
        }
        stack[i]=false;
        st.push(i);
        return false;
    }
    public String findOrder(String[] words) {
        // code here
        
        StringBuilder biggerstr=new StringBuilder();
        for(int i=0;i<words.length;i++){
            biggerstr.append(words[i]);
            
        }
        Set<Character>countset=new TreeSet<>();
        for(int i=0;i<biggerstr.length();i++){
            countset.add(biggerstr.charAt(i));
        }
        
        // Mapping Each Character to a number index to build graph
        
        HashMap<Character,Integer> map=new LinkedHashMap<>();
        int idx=0;
        for(Character c: countset){
            map.put(c,idx++);
        }
        // System.out.println(map);
        // Making the Graph;
        
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<countset.size();i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<words.length-1;i++){
            String word1=words[i];
            String word2=words[i+1];
            
            int len=Math.min(word1.length(),word2.length());
            for(int j=0;j<len;j++){
                if(word1.charAt(j)!=word2.charAt(j)){
                    int u=map.get(word1.charAt(j));
                    int v=map.get(word2.charAt(j));
                    
                    // System.out.println(u+" "+v);
                    adj.get(u).add(v);
                    break;
                }
            }
        }
        
        boolean visited[]=new boolean[countset.size()];
        boolean stack[]=new boolean[countset.size()];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<visited.length;i++){
            if(!visited[i]){
                if(dfsutil(i,adj,st,stack,visited)){
                    return "";
                }
            }
        }
        
        StringBuilder str=new StringBuilder();
        ArrayList<Character>keyset=new ArrayList<>();
        for(Character c:map.keySet()) keyset.add(c);
        while(!st.isEmpty()){
            str.append(keyset.get(st.pop()));
        }
        
        return str.toString();
    }
}