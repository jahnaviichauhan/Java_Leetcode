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

    public ListNode[] splitListToParts(ListNode head, int k) {
        // Step 1: Calculate the total length of the linked list
        int totalLength = 0;
        ListNode current = head;
        while (current != null) {
            totalLength++;
            current = current.next;
        }

        // Step 2: Determine the size of each part and the extra nodes
        int partSize = totalLength / k; // Minimum size of each part
        int extraNodes = totalLength % k; // Number of parts that will have one extra node

        // Step 3: Split the list
        ListNode[] result = new ListNode[k];
        current = head;
        for (int i = 0; i < k; i++) {
            ListNode partHead = current;
            ListNode partTail = current;
            int currentPartSize = partSize + (extraNodes > 0 ? 1 : 0);
            extraNodes--;

            for (int j = 0; j < currentPartSize - 1; j++) {
                if (partTail != null) {
                    partTail = partTail.next;
                }
            }

            if (partTail != null) {
                ListNode nextPartHead = partTail.next;
                partTail.next = null;
                current = nextPartHead;
            }

            result[i] = partHead;
        }

        return result;
    }

    // Helper method to create a linked list from an array (for testing purposes)
    public static ListNode buildList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    // Helper method to print the linked list parts (for testing purposes)
    public static void printListParts(ListNode[] parts) {
        for (ListNode part : parts) {
            ListNode current = part;
            while (current != null) {
                System.out.print(current.val + " ");
                current = current.next;
            }
            System.out.println();
        
    }
}
}