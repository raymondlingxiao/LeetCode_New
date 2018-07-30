public class SwapNodePairs_24 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null)
                return null;
            if (head.next == null)
                return head;
            ListNode fakeHead = new ListNode(-1);
            fakeHead.next = head;
            helper(head,fakeHead);
            return fakeHead.next;
        }

        private void helper(ListNode node, ListNode pre){

            if (node == null || node.next == null)
                return;
            ListNode temp = node.next;
            node.next = node.next.next;
            temp.next = node;
            pre.next = temp;
            pre = node;
            /**
             * 这里是关键点，需要考虑到node下一个是空，或者下一个的下一个为空来避免空指针
             * */
            helper(node.next, pre);
        }
    }
}
