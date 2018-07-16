public class MinStack_155 {
    class MinStack {

        /** initialize your data structure here. */
        private ArrayList<Integer> stack = new ArrayList<>();
        public MinStack() {

        }

        public void push(int x) {
            this.stack.add(x);

        }

        public void pop() {
            int size = this.stack.size();
            if (size > 0)
                this.stack.remove(size-1);
        }

        public int top() {
            int size = this.stack.size();
            if (size > 0)
                return this.stack.get(size-1);

            else
                return -1;
        }

        public int getMin() {
            int min = Integer.MAX_VALUE;
            if (this.stack.size() > 0){
                for (int num:stack){
                    if (num < min)
                        min = num;
                }
                return min;
            }
            else
                return -1;
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
