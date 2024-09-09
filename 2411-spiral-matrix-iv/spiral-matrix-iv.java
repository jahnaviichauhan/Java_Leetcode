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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        for (int[] row : matrix) {
            Arrays.fill(row, -1);
        }

        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        ListNode current = head;

        while (current != null && top <= bottom && left <= right) {
            // Traverse from left to right
            for (int i = left; i <= right && current != null; i++) {
                matrix[top][i] = current.val;
                current = current.next;
            }
            top++;

            // Traverse from top to bottom
            for (int i = top; i <= bottom && current != null; i++) {
                matrix[i][right] = current.val;
                current = current.next;
            }
            right--;

            // Traverse from right to left
            for (int i = right; i >= left && current != null; i--) {
                matrix[bottom][i] = current.val;
                current = current.next;
            }
            bottom--;

            // Traverse from bottom to top
            for (int i = bottom; i >= top && current != null; i--) {
                matrix[i][left] = current.val;
                current = current.next;
            }
            left++;
        }

        return matrix;
    }
}