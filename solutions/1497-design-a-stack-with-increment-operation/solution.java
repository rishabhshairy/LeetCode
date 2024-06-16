class CustomStack {
    
    Stack<Integer> s1;
    int max;
    int count;
    public CustomStack(int maxSize) {
        s1=new Stack<>();
        this.max=maxSize;
        count=0;
    }
    
    public void push(int x) {
        
        if(count < max){
            s1.push(x);
            count++;
        }
        return;
    }
    
    public int pop() {
      if(s1.isEmpty()){
          return -1;
      }  
        count--;
        return s1.pop();
    }
    
    public void increment(int k, int val) {
        if(count < k) {
            for(int i=0; i<count; i++) {
                s1.set(i, s1.get(i)+val);
            }
        } else {
            for(int i=0; i<k; i++)
                s1.set(i, s1.get(i)+val);
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
