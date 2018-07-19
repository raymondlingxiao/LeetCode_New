public class ImpStackWithQue_225 {
    class MyStack {

        /** Initialize your data structure here. */
        public MyStack() {

        }

        /** Push element x onto stack. */
        public void push(int x) {
            ListNode newNode = new ListNode(x);
            if (this.head == null){
                head = newNode;
                pointer =head;
            }
            else{
                pointer.next = newNode;
                pointer = newNode;
            }

        }

        /** Removes the element on top of the stack and returns that element.
         * 这里考虑到链表的性质，所以删除末尾元素，必须遍历全部链表，而插入则不需要*/
        public int pop() {
            if (head == null)
                return -1;
            int val = pointer.val;
            if (head == pointer){
                head = null;
                pointer = null;
                return val;

            }
            else{
                ListNode node = head;
                while (node != null){
                    if (node.next == pointer){
                        pointer = node;
                        node.next = null;
                    }
                    node = node.next;
                }
                return val;
            }

        }

        /** Get the top element. */
        public int top() {
            if (head == null)
                return -1;
            else{
                return pointer.val;
            }
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            if (head == null)
                return true;
            else
                return false;
        }
        // 建立链表中的node结构
        private class ListNode {
            int val;
            ListNode next;
            ListNode(int x) { val = x; }
        }

        private ListNode head = null;
        private ListNode pointer = null;
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
}
