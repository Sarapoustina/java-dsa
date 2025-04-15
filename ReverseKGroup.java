import java.util.*;

public class ReverseKGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }
        if (count == k) {
            ListNode reversed = reverseKGroup(curr, k);
            while (count-- > 0) {
                ListNode temp = head.next;
                head.next = reversed;
                reversed = head;
                head = temp;
            }
            return reversed;
        }
        return head;
    }

    public static ListNode createList(String[] input) {
        ListNode dummy = new ListNode(0), tail = dummy;
        for (String val : input) {
            tail.next = new ListNode(Integer.parseInt(val));
            tail = tail.next;
        }
        return dummy.next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + (head.next != null ? " -> " : ""));
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter linked list values (space-separated):");
        ListNode head = createList(sc.nextLine().split(" "));
        System.out.print("Enter value of k: ");
        int k = sc.nextInt();
        ListNode result = reverseKGroup(head, k);
        System.out.print("Reversed in k-groups: ");
        printList(result);
    }
}
