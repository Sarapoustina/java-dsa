import java.util.*;

public class RemoveZeroSum {

    public static ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int sum = 0;

        for (ListNode node = dummy; node != null; node = node.next) {
            sum += node.val;
            map.put(sum, node);
        }

        sum = 0;
        for (ListNode node = dummy; node != null; node = node.next) {
            sum += node.val;
            node.next = map.get(sum).next;
        }

        return dummy.next;
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
        ListNode result = removeZeroSumSublists(head);
        System.out.print("After removing zero-sum sublists: ");
        printList(result);
    }
}

