class Solution {
    public int firstElementKTime(int[] arr, int k) {
        // code here
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            if(map.get(arr[i])==k){
                return arr[i];
            }
        }
        // for(Map.Entry<Integer,Integer> entry:map.entrySet()){
        //     if(entry.getValue()==k){
        //         return entry.getKey();
        //     }
        // }
        
        return -1;
    }
}