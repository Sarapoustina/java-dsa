import java.util.*;

public class OddEvenLinkedList {

    public static ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
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
        ListNode result = oddEvenList(head);
        System.out.print("Odd-Even grouped list: ");
        printList(result);
    }
}

