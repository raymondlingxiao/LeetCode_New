public class RmvLinkedEle_203 {
    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            // two pointers, add a head
            // 处理链表时可以加入一个假头方便操作
            //注意在处理指针的时候要小心移动的位置
            ListNode fakeHead = new ListNode(-1);
            fakeHead.next = head;
            ListNode cur = head, prev = fakeHead;
            while (cur != null){
                if (cur.val == val)
                    prev.next = cur.next;
                //这里是关键
                else
                    prev = cur;
                cur = cur.next;
            }
            return fakeHead.next;
        }
    }
}
