public class RverLinkedList_206 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        //iterative way
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            while (head != null){
                ListNode nex = head.next;
                head.next = prev;
                prev = head;
                head = nex;
            }
            return prev;
        }
    }

    class Solution2 {
        //recursive way
        public ListNode reverseList(ListNode head) {
            //find the exit, that is return the pointer which points at the last number
            //here it is 'prev'
            if (head == null)
                return prev;
            ListNode nex = head.next;
            head.next = prev;
            prev = head;
            return reverseList(nex);

        }
        private ListNode prev = null;
    }
}
