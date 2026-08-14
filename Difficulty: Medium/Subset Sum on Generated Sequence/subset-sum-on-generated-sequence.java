class Solution {
    public boolean isPossible(int[] arr, int s, int x) {
        // code here
        
        
        long sum = s;

        // Store only generated values <= x
        ArrayList<Long> seq = new ArrayList<>();

        if (s <= x) {
            seq.add((long) s);
        }

        for (int num : arr) {

            long next = sum + num;

            if (next <= x) {
                seq.add(next);
            } else {
                
                break;
            }

            sum += next;
        }

       
        for (int i = seq.size() - 1; i >= 0; i--) {

            if (seq.get(i) <= x) {
                x -= seq.get(i);
            }

            if (x == 0) {
                return true;
            }
        }

        return x == 0;
        
    }
}