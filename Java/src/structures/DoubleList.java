package structures;

public class DoubleList {

    private DoubleNode head;
    private DoubleNode tail;
    private int size;

    public DoubleList() {
        head = new DoubleNode(0, 0);
        tail = new DoubleNode(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    // 在链表头部添加节点 x
    public void addFirst(DoubleNode x) {
        x.next = head.next;
        x.prev = head;
        head.next.prev = x;
        head.next = x;
        size++;
    }

    // 删除链表中的 x 节点（x 一定存在）
    public void remove(DoubleNode x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    // 删除链表中最后一个节点，并返回该节点
    public DoubleNode removeLast() {
        if (tail.prev == head)
            return null;
        DoubleNode last = tail.prev;
        remove(last);
        return last;
    }

    // 返回链表长度
    public int size() { return size; }
}
