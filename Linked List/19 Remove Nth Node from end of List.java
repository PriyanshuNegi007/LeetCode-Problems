class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null){
            return null;
        }

        int count = 0;
        ListNode temp = head;

        while (temp != null){
            count++;
            temp = temp.next;
        }

        if (n == count){
            return head.next;
        }

        int targetIndex = count - n;
        temp = head;
        for (int i = 0; i < targetIndex - 1; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
}
