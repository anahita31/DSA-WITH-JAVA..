import java.util.HashSet;

class ListNode {
    char val;
    ListNode next;
    ListNode(char val) {
        this.val = val;
    }
}

public class Solution {
    // Convert String to LinkedList
    private ListNode stringToLinkedList(String s) {
        if (s.isEmpty()) return null;

        ListNode head = new ListNode(s.charAt(0));
        ListNode current = head;
        for (int i = 1; i < s.length(); i++) {
            current.next = new ListNode(s.charAt(i));
            current = current.next;
        }
        return head;
    }

    // Main required method (LeetCode-compatible)
    public int lengthOfLongestSubstring(String s) {
        ListNode head = stringToLinkedList(s);
        if (head == null) return 0;

        HashSet<Character> seen = new HashSet<>();
        ListNode start = head, end = head;
        int maxLength = 0;

        while (end != null) {
            if (!seen.contains(end.val)) {
                seen.add(end.val);
                maxLength = Math.max(maxLength, seen.size());
                end = end.next;
            } else {
                seen.remove(start.val);
                start = start.next;
            }
        }

        return maxLength;
    }
}
