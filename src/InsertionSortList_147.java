public class InsertionSortList_147 {
    class Solution {
        public ListNode insertionSortList(ListNode head) {
            if (head == null)
                return null;
            ListNode res = new ListNode(head.val);
            head = head.next;
            while (head != null){
                ListNode pre = null;
                ListNode h = res;
                if (head.val <= h.val){
                    ListNode node = new ListNode(head.val);
                    node.next = h;
                    h = node;
                    res = h;
                }

                if (head.val > h.val){
                    while (h != null && head.val > h.val){
                        pre = h;
                        h = h.next;
                    }

                    ListNode node = new ListNode(head.val);
                    pre.next = node;
                    node.next =  h;
                }
                head = head.next;

            }

            return res;
        }
    }
}
