class MyQueue {
    
    Stack<Integer> stIn;
    Stack<Integer> stOut;
    
    public MyQueue() {
        stIn = new Stack<Integer>();
        stOut = new Stack<Integer>();
    }
    
    public void push(int x) {
        if(stIn.isEmpty() && !stOut.isEmpty()){
            while(!stOut.isEmpty()){
                stIn.push(stOut.pop());
            }
        }
        stIn.push(x);
    }
    
    public int pop() {
        if(stOut.isEmpty() && !stIn.isEmpty()){
            while(!stIn.isEmpty()){
                stOut.push(stIn.pop());
            }
        }
        return stOut.pop();
    }
    
    public int peek() {
        int temp;
        if(stOut.isEmpty() && !stIn.isEmpty()){
            while(!stIn.isEmpty()){
                stOut.push(stIn.pop());
            }
        }
        temp = stOut.pop();
        stOut.push(temp);
        return temp;
    }
    
    public boolean empty() {
        if(stIn.isEmpty() && stOut.isEmpty()) return true;
        else return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
