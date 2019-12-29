class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Q2_AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String strl1 = "";
        String strl2 = "";
        while (l1 != null) {
            strl1 = l1.val + strl1;
            l1 = l1.next;
        }
        while (l2 != null) {
            strl2 = l2.val + strl2;
            l2 = l2.next;
        }
        Integer intl1 = Integer.parseInt(strl1);
        Integer intl2 = Integer.parseInt(strl2);
        Integer intsum = intl1 + intl2;
        String strsum = intsum.toString();
        String reverseStrSum = new StringBuffer(strsum).reverse().toString();
        String[] listStrSum = reverseStrSum.split("");

        int[] listInt = StringArrToIntArr(listStrSum);
        ListNode targetNode = buildListNode(listInt);

        return targetNode;
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

    public static int[] StringArrToIntArr(String[] s) {
        int[] result = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            result[i] = Integer.parseInt(s[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = buildListNode(new int[]{9});
        ListNode l2 = buildListNode(new int[]{1,9,9,9,9,9,9,9,9,9}); //too big integer
        addTwoNumbers(l1, l2);
    }
}
