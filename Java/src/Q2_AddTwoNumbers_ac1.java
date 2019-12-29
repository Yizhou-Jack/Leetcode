public class Q2_AddTwoNumbers_ac1 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, node = null;
        int carry = 0, sum = 0;
        while (!(l1 == null && l2 == null)) {
            // both not null
            if (l1 != null && l2 != null) {
                sum = (l1.val + l2.val + carry) % 10;
                carry = (l1.val + l2.val + carry) / 10; //carry 进位
                l1 = l1.next;
                l2 = l2.next;
            }
            // l1==null
            else if (l1 == null && l2 != null) {
                sum = (l2.val + carry) % 10;
                carry = (l2.val + carry) / 10;
                l2 = l2.next;
            }
            // l2==null
            else if (l1 != null && l2 == null) {
                sum = (l1.val + carry) % 10;
                carry = (l1.val + carry) / 10;
                l1 = l1.next;
            }
            // both null
            else {
                // break out of the loop
            }
            if (head == null) {
                head = new ListNode(sum);
                node = head;
            } else {
                node.next = new ListNode(sum);
                node = node.next;
            }
        }
        if (carry > 0) { //最后一个进位
            while (carry > 0) {
                int curr = carry % 10;
                node.next = new ListNode(curr);
                node = node.next;
                carry = carry / 10;
            }
        }
        return head;
    }

    private static ListNode buildListNode(int[] input) {
        ListNode first = null,last = null,newNode;
        if (input.length>0) {
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

    private static void printLinkedList(ListNode listNode) {
        while (listNode != null) {
            int value = listNode.val;
            System.out.println(value);
            listNode = listNode.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = buildListNode(new int[]{2,4,4,3});
        ListNode l2 = buildListNode(new int[]{5,6,6,4});
        ListNode targetNode = addTwoNumbers(l1, l2);
        printLinkedList(targetNode);
    }
}
