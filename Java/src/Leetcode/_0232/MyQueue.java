package Leetcode._0232;

import java.util.Stack;

public class MyQueue {

    Stack<Integer> stack;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }
        int res = temp.pop();
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
        return res;
    }

    /** Get the front element. */
    public int peek() {
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }
        int res = temp.peek();
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
        return res;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}
