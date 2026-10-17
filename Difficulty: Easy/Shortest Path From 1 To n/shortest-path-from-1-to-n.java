class Solution {
    public int minimumStep(int n) {
        // code here
       int count=0;
      while(n>1){
          if(n%3==0) n/=3;
          else n=n-1;
          
          count++;
      }
       
       return count;
    }
}
