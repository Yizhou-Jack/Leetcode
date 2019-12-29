package tools;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class ListNodeTool {

    private static void printLinkedList(ListNode listNode) {
        while (listNode != null) {
            int value = listNode.val;
            System.out.println(value);
            listNode = listNode.next;
        }
    }

    private static ListNode buildListNode(int[] input) {
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

