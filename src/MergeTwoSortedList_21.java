public class MergeTwoSortedList_21 {
    class RecursiveSolution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null)
                return l2;
            if (l2 == null)
                return l1;
            ListNode mergeList;
            if (l1.val<=l2.val){
                mergeList = l1;
                mergeList.next = mergeTwoLists(mergeList.next, l2);
            }
            else{
                mergeList = l2;
                mergeList.next = mergeTwoLists(mergeList.next, l1);
            }
            return mergeList;

        }
    }

    public ListNode BF_mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null&& l2 == null)
            return null;

        ListNode mergeList = new ListNode(0);
        // Shalow-Copy, the same object
        ListNode temp = mergeList;
        // Non-Recursive Solution
        while(l1 != null && l2 != null){
            if (l1.val <= l2.val){
                temp.next = l1;
                l1 = l1.next;
            }
            else{
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;

        }
        if (l1 != null)
            temp.next = l1;
        if (l2 != null)
            temp.next = l2;
        return mergeList.next;
    }
}
}
