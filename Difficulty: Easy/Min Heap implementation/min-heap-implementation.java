class minHeap {

    // Constructor
    ArrayList <Integer> arr;
    public minHeap() {
        // Initialize your data members
        arr=new ArrayList<>();
    }

    public void push(int x) {
        // Insert x into the heap
       arr.add(x);
       int child=arr.size()-1;
      
       
       while(child>0){
            int parent=(child-1)/2;
            
            if(arr.get(parent)<=arr.get(child)){
                break;
            }
            int temp=arr.get(child);
            arr.set(child,arr.get(parent));
            arr.set(parent,temp);
            
            child=parent;
       }
    }
    private void heapify(int i){
        int left=2*i+1;
        int right=2*i+2;
        int minidx=i;
        
        if(left<arr.size() && arr.get(minidx)>arr.get(left)){
            minidx=left;
        }
        if(right<arr.size() && arr.get(minidx)>arr.get(right)){
            minidx=right;
        }
        
        if(minidx!=i){
            int temp=arr.get(i);
            arr.set(i,arr.get(minidx));
            arr.set(minidx,temp);
            heapify(minidx);
        }
    }
    public void pop() {
        // Remove the top (minimum) element
        int first=arr.get(0);
        int last=arr.get(arr.size()-1);
        
        arr.set(0,last);
        arr.set(arr.size()-1,first);
        
        arr.remove(arr.size()-1);
        heapify(0);
    }

    public int peek() {
        // Return the top element or -1 if empty
        if(arr.size()==0){
            return -1;
        }
        return arr.get(0);
    }

    public int size() {
        // Return the number of elements in the heap
        return arr.size();
    }
}