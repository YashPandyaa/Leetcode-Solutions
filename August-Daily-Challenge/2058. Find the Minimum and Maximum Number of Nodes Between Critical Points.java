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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] result = {-1, -1};
        
        ListNode prev = head;
        ListNode curr = head.next;
        int index = 1;
        
        int firstCritical = -1;
        int lastCritical = -1;
        int prevCritical = -1;
        int minDist = Integer.MAX_VALUE;
        
        while (curr.next != null) {
            boolean isCritical = (curr.val > prev.val && curr.val > curr.next.val) ||
                                 (curr.val < prev.val && curr.val < curr.next.val);
            
            if (isCritical) {
                if (firstCritical == -1) {
                    firstCritical = index;
                    prevCritical = index;
                } else {
                    minDist = Math.min(minDist, index - prevCritical);
                    prevCritical = index;
                    lastCritical = index;
                }
            }
            
            prev = curr;
            curr = curr.next;
            index++;
        }
        
        if (lastCritical != -1) {
            result[0] = minDist;
            result[1] = lastCritical - firstCritical;
        }
        
        return result;
    }
}
