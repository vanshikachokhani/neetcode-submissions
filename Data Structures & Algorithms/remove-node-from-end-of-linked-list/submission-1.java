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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int sz = 0;
        ListNode temp = head;
        while(temp!=null){
            temp = temp.next;
            sz++;
        }

        if(sz==1){
            head = null;
            return head;
        }
        if(n==sz){
            head = head.next;
            return head;
        }

        int q = sz-n+1; 
        int cnt = 1;
        temp = head;
        ListNode prev = head;
        while(cnt<q){
            prev = temp;
            temp = temp.next;
            cnt++;
        }
        // System.out.println(temp.val + " : " + prev.val);
        prev.next = temp.next;
        return head;
    }
}
