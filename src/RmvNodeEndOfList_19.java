public class RmvNodeEndOfList_19 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null)
                return null;
            ListNode fakeHead = new ListNode(-1);
            fakeHead.next = head;
            ListNode slow = fakeHead;
            ListNode fast = fakeHead;


            while (n+1>0){
                fast = fast.next;
                n--;
            }
            while (fast != null){
                fast = fast.next;
                slow = slow.next;
            }
            //rmv node
            slow.next = slow.next.next;
            return fakeHead.next;
        }
    }
}
