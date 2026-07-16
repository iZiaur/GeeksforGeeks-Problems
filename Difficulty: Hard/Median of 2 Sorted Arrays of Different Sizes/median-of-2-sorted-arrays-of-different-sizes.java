class Solution {
    public double medianOf2(int a[], int b[]) {
        // Code Here
         // two pointer approach 
        int len1=a.length;
        int len2=b.length;
        int totallen=len1+len2;
        int i=0;
        int curr=0;
        int prev=0;
        int p1=0;
        int p2=0;
        while(i<=totallen/2){
            prev=curr;

            if(p1==len1){
                curr=b[p2];
                p2++;
            }
            else if(p2==len2){
                curr=a[p1];
                p1++;
            }else if(a[p1]<=b[p2]){
                curr=a[p1];
                p1++;
            }else{
                curr=b[p2];
                p2++; 
            }
            i++;
        }

        if(totallen%2==0){
            double ans=(curr+prev)/(double) 2;
            return ans;
        }

        return (double) curr;
        
    }
}