class Solution {
    public void sortIt(int[] arr) {
        // code here
        ArrayList<Integer>odd=new ArrayList<>();
        ArrayList<Integer>even=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2==0){
                even.add(arr[i]);
            }else{
                odd.add(arr[i]);
            }
        }
        Collections.sort(odd);
        Collections.reverse(odd);
        Collections.sort(even);
        int idx=0;
       for(int i=0;i<odd.size();i++){
           arr[idx++]=odd.get(i);
       }
       for(int i=0;i<even.size();i++){
           arr[idx++]=even.get(i);
       }
    }
}
