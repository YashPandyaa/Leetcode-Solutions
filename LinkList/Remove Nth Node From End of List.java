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
       int size=0;
       int count=0;
       ListNode temp=head;
       if(head==null)return null;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        size=count-n;
        if(size==0){
            head=head.next;
            return head;
        }
       ListNode temp1=head;

        for(int i=0;i<size-1;i++){
            temp1=temp1.next;
        }
        temp1.next=temp1.next.next;
        
        return head;
    }
}
