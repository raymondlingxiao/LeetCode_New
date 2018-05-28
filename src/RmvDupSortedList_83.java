public class RmvDupSortedList_83 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution1 {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null)
                return null;
            ListNode last = head;
            ListNode cur = last.next;
            while (cur != null){
                if (cur.val == last.val)
                    cur = cur.next;
                else{
                    last.next = cur;
                    last = cur;
                    cur = cur.next;
                }
            }
            last.next = null;
            return head;
        }
        class Solution2 {
            // improved version
            public ListNode deleteDuplicates(ListNode head) {
                if (head == null)
                    return null;
                ListNode last = head;
                ListNode cur = last.next;
                while (cur != null){
                    if (cur.val == last.val)
                        last.next = cur.next;
                    else
                        last = cur;
                    cur = cur.next;
                }
                return head;
            }
        }
    }
}
