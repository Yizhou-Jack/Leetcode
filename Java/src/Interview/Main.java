package Interview;

import structures.ListNode;

import java.util.*;
import java.util.regex.Pattern;

public class Main {

    public static int[] solution1(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int i = 0; i < nums.length; i++) {
            if (pq.size() < k) {
                pq.add(nums[i]);
            } else if (pq.peek() < nums[i]) {
                pq.poll();
                pq.add(nums[i]);
            }
        }

        int[] res = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            res[i] = pq.poll();
            i++;
        }

        return res;
    }

    public static ListNode solution2(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            while (next != null) {
                if (next.val < curr.val) {
                    int temp = curr.val;
                    curr.val = next.val;
                    next.val = temp;
                }
                next = next.next;
            }
            curr = curr.next;
        }
        return head;
    }

    public static boolean match(String str, String pattern) {
        int s = 0;
        int p = 0;
        int starIndex = -1;
        int matchIndex = 0;
        while (s < str.length()) {
            if (p < pattern.length() && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))) {
                s++;
                p++;
            }
            else if (p < pattern.length() && pattern.charAt(p) == '*') {
                starIndex = p;
                matchIndex = s;
                p++;
            }
            else if (starIndex != -1) {
                p = starIndex+1;
                matchIndex++;
                s = matchIndex;
            }
            else return false;
        }

        while (p < pattern.length() && pattern.charAt(p) == '*') {
            p++;
        }

        return p == pattern.length();
    }

    public static void main(String[] args) {
        String str = "*abc*?a";
        String pattern = "xxxabcda";
        boolean res3 = match(str, pattern);
        System.out.println(res3);
    }

    /*
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nm = sc.nextLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        char[][] input = new char[n][m];
        for(int i = 0; i < n; i++){
            char[] line = sc.nextLine().toCharArray();
            input[i] = line;
        }
        int res = DFSIteration(n, m, input);
        System.out.println(res);
    }
     */
}
