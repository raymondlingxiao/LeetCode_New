public class MergeKSortedList_23 {

    /**
     * 1. merge加上遍历list
     * 2. devide and conquer
     * 3.priority queue
     *
     */

    class Solution3 {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0)
                return null;
            if (lists.length == 1)
                return lists[0];
            PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b)->(a.val-b.val));
            ListNode res = new ListNode(-1);
            ListNode temp = res;

            for (ListNode node:lists){
                if (node != null)
                    queue.offer(node);
            }
            while(!queue.isEmpty()){
                temp.next = queue.poll();
                temp = temp.next;

                if (temp.next != null)
                    queue.offer(temp.next);
            }

            return res.next;
        }

    }
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null||lists.length == 0)
                return null;
            if (lists.length == 1)
                return lists[0];
            ListNode temp = lists[0];
            for (int i=1;i<lists.length;i++){
                temp = mergeTwoLists(temp,lists[i]);
            }
            return temp;

        }

        // devided and conquer,将其分为左边的和加上右边的和
        private ListNode mergelists(ListNode[] lists, int start, int end){
            if (start == end)
                return lists[start];
            if (start<end){
                int mid = (end-start)/2 + start;
                ListNode left = mergelists(lists,start,mid);
                ListNode right = mergelists(lists,mid+1,end);
                return mergeTwoLists(left,right);
            }
            else

                private ListNode mergeTwoLists(ListNode l1, ListNode l2){
            if (l1 == null)
                return l2;
            if (l2 == null)
                return l1;
            ListNode head = new ListNode(-1);
            ListNode list = head;

            while (l1 != null && l2 != null){
                if (l1.val <= l2.val){
                    list.next = l1;
                    l1 = l1.next;
                }
                else{
                    list.next = l2;
                    l2 = l2.next;
                }
                list = list.next;
            }
            if (l1 != null) list.next = l1;
            if (l2 != null) list.next = l2;

            return head.next;
        }
    }
}
