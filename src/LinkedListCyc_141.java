public class LinkedListCyc_141 {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     * 双指针问题
     */
    public class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null)
                return false;
            // two pointers
            ListNode fast = head;
            ListNode slow = head;
            // start compare
            // 此处需要考虑到空指针的问题，需要确保下一个指针不为空再看后两个
            while (fast.next != null && fast.next.next != null){
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow)
                    return true;
            }
            return false;

        }
    }
}
