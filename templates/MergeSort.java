public class MergeSort {
    public ListNode insertionSortList(ListNode head) {
        // merge sort
        if (head == null || head.next == null)
            return head;

        // find the smallest sub probelm
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        fast = slow.next;
        slow.next = null;

        ListNode left = insertionSortList(head);
        ListNode right = insertionSortList(fast);

        return merge(left,right);

    }

    private ListNode merge(ListNode l1, ListNode l2){
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        if (l1.val < l2.val){
            l1.next = merge(l1.next, l2);
            return l1;
        }
        else{
            l2.next = merge(l2.next,l1);
            return l2;
        }

    }
}