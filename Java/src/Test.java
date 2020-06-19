import java.util.*;

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Test {

    public static List<Integer> treeTraversal = new ArrayList<>();

    public static void inorder(TreeNode root) { //中序遍历
        if (root == null) {
            return;
        }
        inorder(root.left);
        treeTraversal.add(root.val);
        inorder(root.right);
    }

    public static int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;
        PriorityQueue<Integer> allocator = new PriorityQueue<>();
        Arrays.sort(
                intervals,
                new Comparator<int[]>() {
                    public int compare(int[] a, int[] b) {
                        return a[0] - b[0];
                    }
                });
        allocator.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= allocator.peek()) {
                allocator.poll();
                allocator.add(intervals[i][1]);
            } else {
                allocator.add(intervals[i][1]);
            }
        }

        return allocator.size();
    }

    public static void main(String[] args) {
        int[] inta1 = new int[]{1,2,3,4};
        int[] inta2 = new int[]{1,2,3,4};
        List<String> list = new ArrayList<>();
        list.add(Arrays.toString(inta1));
        System.out.println(list.contains(Arrays.toString(inta2)));
    }
}
