/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if(headA == null || headB == null){
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;

        while(a != b){
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next; //means same thing as if-else statement above
        }
        return a;
    }

    public ListNode getIntersectionNodeBrute(ListNode headA, ListNode headB) {
        //Use set as it does not allow duplicates
        Set<ListNode> set = new HashSet<>();
        while(headB != null){
            set.add(headB);
            headB = headB.next;
        }

        while(headA != null){
            if(set.contains(headA)){
                return headA;
            }
            headA = headA.next;
        }
        return null;
    }
}
