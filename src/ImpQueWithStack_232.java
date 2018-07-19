public class ImpQueWithStack_232 {
    class MyQueue {

        /** Initialize your data structure here.
         * 这里采用两个stack来实现queue，每次取出放进都由两个stack进行 */
        public MyQueue() {

        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stackIn.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (stackOt.empty()){
                while(!stackIn.empty()){
                    stackOt.push(stackIn.pop());
                }
            }
            return stackOt.pop();

        }

        /** Get the front element. */
        public int peek() {
            if (stackOt.empty()){
                while(!stackIn.empty()){
                    stackOt.push(stackIn.pop());
                }
            }
            return stackOt.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return (stackIn.empty() && stackOt.empty());
        }

        private Stack<Integer> stackIn = new Stack<Integer>();
        private Stack<Integer> stackOt = new Stack<Integer>();

    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
