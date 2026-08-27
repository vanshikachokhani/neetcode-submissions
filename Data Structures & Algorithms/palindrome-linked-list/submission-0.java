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
    public ListNode reverse(ListNode temp){
        ListNode prev = null;
        ListNode head = temp;

        while(head!=null){
            ListNode t = head.next;
            head.next = prev;
            prev = head;
            head = t;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode temp = reverse(slow);

        ListNode dummy = head;
        while(temp!=null && dummy!=null){
            if(temp.val!=dummy.val) {
                return false;
            }
            temp = temp.next;
            dummy = dummy.next;
        }
        return true;
    }
}