class Solution {
    public static int solve(int n, String s) {
        int[] state = new int[26]; 
        int occupiedCount = 0;
        int turnedAwayCount = 0;

        for (int i = 0; i < s.length(); i++) {
            int customer = s.charAt(i) - 'A';

           
            if (state[customer] == 0) {
                if (occupiedCount < n) {
                    state[customer] = 1; 
                    occupiedCount++;
                } else {
                    state[customer] = 2; 
                    turnedAwayCount++;
                }
            } 
           
            else {
                if (state[customer] == 1) {
                    occupiedCount--;
                }
                
            }
        }

        return turnedAwayCount;
    }
}