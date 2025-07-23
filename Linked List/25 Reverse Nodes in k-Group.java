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
    private int findLength(ListNode head){
        int length = 0;
        while(head != null){
            length++;
            head = head.next;
        }
        return length;
    }

    private ListNode getKthNode(ListNode head, int k){
        k = k - 1;
        while(head != null && k > 0){
            k--;
            head = head.next;
        }
        return head;
    }

    private ListNode reverse(ListNode head){
        ListNode current = head;
        ListNode prev = null;
        while(current != null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1){
            return head;
        }
        int length = findLength(head);

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode current = head;

        while(length >= k){
            ListNode start = current;
            ListNode end = getKthNode(current,k);
            if(end == null){
                break;
            }

            ListNode nextStart = end.next;
            end.next = null;
            prev.next = reverse(start);

            start.next = nextStart;
            prev = start; 
            current = nextStart;
            length = length - k; 
        }
        return dummy.next;
    }
}
