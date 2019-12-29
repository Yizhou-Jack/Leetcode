package structures;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static void printLinkedList(ListNode listNode) {
        while (listNode != null) {
            int value = listNode.val;
            System.out.println(value);
            listNode = listNode.next;
        }
    }

    public static ListNode buildListNode(int[] input) {
        ListNode first = null, last = null, newNode;
        if (input.length > 0) {
            for (int i = 0; i < input.length; i++) {
                newNode = new ListNode(input[i]);
                newNode.next = null;
                if (first == null) {
                    first = newNode;
                    last = newNode;
                }
                else {
                    last.next = newNode;
                    last = newNode;
                }
            }
        }
        return first;
    }
}
