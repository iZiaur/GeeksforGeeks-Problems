class Solution {
    class Student{
        String s;
        int len;
        int index;
        public Student(String s,int len,int index){
            this.s=s;
            this.len=len;
            this.index=index;
        }
    }
    public void sortByLength(String[] arr) {
        // code here
        PriorityQueue<Student> pq=new PriorityQueue<>((a,b)->{
            if(a.len!=b.len){
                return  a.len-b.len;
            }else{
                return a.index-b.index;
            }
        }
       );
        for(int i=0;i<arr.length;i++){
            pq.add(new Student(arr[i],arr[i].length(),i));
        }
        int idx=0;
        while(!pq.isEmpty()){
            Student s1=pq.poll();
            arr[idx++]=s1.s;
        }
        
    }
}
