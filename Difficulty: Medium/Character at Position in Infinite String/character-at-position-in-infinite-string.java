import java.util.ArrayList;
import java.util.List;

class Solution {
    public char posInfinite(String s, int pos) {
        long p = pos;
        long n = s.length();
        if (p <= n) {
            return s.charAt((int) p - 1);
        }

        List<Long> lengths = new ArrayList<>();
        lengths.add(n);

        long step = 0;
        while (lengths.get((int) step) < p) {
            step++;
            long prevLen = lengths.get((int) (step - 1));
            long nextLen = 2 * prevLen + step;
            lengths.add(nextLen);
        }

        for (int i = (int) step; i >= 1; i--) {
            long prevLen = lengths.get(i - 1);
            if (p <= prevLen) {
                continue;
            } else if (p <= prevLen + i) {
                return '$';
            } else {
                long revIndex = p - (prevLen + i);
                p = prevLen - revIndex + 1;
            }
        }

        return s.charAt((int) p - 1);
    }
}