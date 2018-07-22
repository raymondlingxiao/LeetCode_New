public class DeleteNodeLinkedList_237 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public void deleteNode(ListNode node) {
            ListNode cur = node;
            ListNode nxt = node.next;
            cur.next = cur.next.next;
            node.val = nxt.val;
        }
    }
}
