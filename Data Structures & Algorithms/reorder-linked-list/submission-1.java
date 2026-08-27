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
    public ListNode reverse(ListNode node){
        ListNode prev = null;
        ListNode curr = node;

        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        if(head==null || head.next==null || head.next.next==null)
            return ;

        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = reverse(slow.next); 
        // System.out.println(slow.val);  

        // while(head!=null){
        //     System.out.println(head.val);
        //     head = head.next;
        // } 

        ListNode temp = head;
        ListNode s = slow.next;
        slow.next = null;

        System.out.println("Head : " + head.val );
        System.out.println("S : " + s.val );
        // 2 4 6 10 8
        // 2 10 4 6 
        while(s!=null && temp!=slow.next){
            ListNode t = temp.next;
            ListNode t2 = s.next;
            temp.next = s;
            s.next = t;
            temp = t;
            s = t2;
        }
    }
}
