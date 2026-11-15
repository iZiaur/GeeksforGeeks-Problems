import java.math.BigInteger;

class Solution {
    public int subsequenceSum(String s) {
        long mod = 1_000_000_007;
        long sum = 0;
        
      
        for (char c : s.toCharArray()) {
            sum = (sum + (c - '0')) % mod;
        }
        
       
        long power = BigInteger.valueOf(2)
                               .modPow(BigInteger.valueOf(s.length() - 1), BigInteger.valueOf(mod))
                               .longValue();
                               
        return (int) ((sum * power) % mod);
    }
}