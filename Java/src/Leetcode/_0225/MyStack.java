package Leetcode._0225;

import java.util.LinkedList;

public class MyStack {

    LinkedList<Integer> queue1;
    LinkedList<Integer> queue2;
    int top;

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
        top = 0;
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue1.add(x);
        top = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (queue1.size() > 1) {
            top = queue1.pop();
            queue2.add(top);
        }
        int res = queue1.pop();
        LinkedList<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return res;
    }

    /** Get the top element. */
    public int top() {
        while (queue1.size() > 0) {
            top = queue1.pop();
            queue2.add(top);
        }
        LinkedList<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}
