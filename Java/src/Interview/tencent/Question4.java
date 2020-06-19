package Interview.tencent;

import java.util.*;

class MyQueue {

    Stack<Integer> input = new Stack();
    Stack<Integer> output = new Stack();

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        peek();
        return output.pop();
    }

    public int peek() {
        if (output.empty()) {
            while (!input.empty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    public boolean empty() {
        return input.empty() && output.empty();
    }

}

public class Question4 {

    public static List<Integer> solution1(String[] opers) {
        MyQueue queue = new MyQueue();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < opers.length; i++) {
            String oper = opers[i];
            if (oper.charAt(0) == 'a') {
                int addNum = Integer.parseInt(oper.split(" ")[1]);
                queue.push(addNum);
            } else if (oper.equals("peek")) {
                res.add(queue.peek());
            } else {
                queue.pop();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = Integer.parseInt(s.nextLine());
        String[] opers = new String[num];
        for (int i = 0; i < num; i++) {
            opers[i] = s.nextLine();
        }
        List<Integer> res = solution1(opers);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

}
