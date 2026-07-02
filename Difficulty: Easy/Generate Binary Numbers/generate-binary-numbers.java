class Solution {
    public ArrayList<String> generateBinary(int n) {
        // code here
        
        ArrayList <String > arr=new ArrayList<>();
        
        for(int i=1;i<=n;i++){
            arr.add(Integer.toBinaryString(i));
        }
        return arr;
        
    }
}
