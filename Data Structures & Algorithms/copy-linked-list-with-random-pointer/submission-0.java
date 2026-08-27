/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Integer, Node> mp = new HashMap<>();
        Map<Node,Integer> mp2 = new HashMap<>();

        Node prev = new Node(0);
        Node dummy = prev;
        Node temp = head;
        int id = 0;
        while(temp!=null){
            Node ans = new Node(temp.val);
            prev.next = ans;
            prev = ans;
            mp.put(id,ans);
            mp2.put(temp,id);
            id++;
            temp = temp.next;
        }

        temp = head;
        Node temp2 = dummy.next;

        while(temp!=null){
            temp2.random = mp.get(mp2.get(temp.random));
            temp = temp.next;
            temp2 = temp2.next;
        }

        return dummy.next;
    }
}
