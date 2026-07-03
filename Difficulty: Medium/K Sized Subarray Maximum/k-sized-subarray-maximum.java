class Solution {
    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {

        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {

            
            while (!dq.isEmpty() && dq.peekFirst() <= i - k)
                dq.pollFirst();

           
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i])
                dq.pollLast();

            
            dq.offerLast(i);

            
            if (i >= k - 1)
                ans.add(arr[dq.peekFirst()]);
        }

        return ans;
    }
}