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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        //after swap there will be new head
        ListNode newHead = head.next;
        ListNode current = head;
        
        //Track swap pairs
        ListNode prev = null;
        while(current != null && current.next != null){
            //Find pairs to swap
            ListNode first = current;
            ListNode second = current.next;
            ListNode nextPair = second.next;
            //swap happens
            second.next=first;
            first.next = nextPair;
            if(prev != null){
                prev.next = second;
            }
                prev = first;
                current = nextPair;
        }
        return newHead;
    }
}
