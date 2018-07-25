public class Add2Num_2 {
    /**
     * 一次性把两个链表都进行遍历，同时生成新的链表
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode p1 = l1;
            ListNode p2 = l2;
            ListNode result = new ListNode(0);
            ListNode head = result;
            int up = 0;

            while (p1 != null || p2 != null){
                // up -= 10;
                up /= 10;
                if (p1 != null){
                    up += p1.val;
                    p1 = p1.next;
                }
                if (p2 != null){
                    up += p2.val;
                    p2 = p2.next;
                }
                // sum%10 == sum -10
                //little trick
                result.next = new ListNode(up % 10);
                result = result.next;
            }
            if (up/10 > 0){
                result.next = new ListNode(1);
            }
            return head.next;

        }
    }
}
