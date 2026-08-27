/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while(l1!=null && l2!=null){
            int v1 = l1.val;
            int v2 = l2.val;
            if(v1<=v2){
                curr.next = new ListNode(v1);
                curr = curr.next;
                l1 = l1.next;
            }
            else{
                curr.next = new ListNode(v2);
                curr = curr.next;
                l2 = l2.next;
            }
        }

        while(l1!=null){
            curr.next = new ListNode(l1.val);
                curr = curr.next;
                l1 = l1.next;
        }

         while(l2!=null){
            curr.next = new ListNode(l2.val);
                curr = curr.next;
                l2 = l2.next;
        }

        return dummy.next;
    } 
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;

        for(int i=0;i<lists.length-1;i++){
            lists[i+1] = merge(lists[i], lists[i+1]);
        }
        return lists[lists.length-1];
    }
}
