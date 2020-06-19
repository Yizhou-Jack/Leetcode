package Interview.meituan;

import java.util.Scanner;

public class Question4 {

    public static double res = 0;

    public static void backtrack(int[] alist, int[] nums, int i, double prob) {
        int[] newNums = new int[nums.length];
        for (int j = 0; j < nums.length; j++) {
            newNums[j] = nums[j];
        }
        double exProb = 1;
        for (int j = 0; j < newNums.length; j++) {
            if (newNums[j] == 0) exProb *= (1-prob);
            if (newNums[j] == 1) exProb *= prob;
        }
        int aCount = 0;
        int value = 0;
        boolean flag = false;
        for (int j = 0; j < newNums.length; j++) {
            if (newNums[j] == 1) {
                value += alist[aCount];
                aCount++;
            } else {
                aCount = 0;
            }
        }
        res += exProb * value;
        for (int j = i; j < newNums.length; j++) {
            newNums[j] = 1;
            backtrack(alist, newNums, i+1, prob);
            newNums[j] = 0;
        }
    }

    public static double solution(int[] npq, int[] alist) {
        int n = npq[0];
        double prob = (double)npq[1] / (double)npq[2];
        int[] nums = new int[alist.length];
        int[] zeros = new int[nums.length];
        backtrack(alist, zeros, 0, prob);
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] npq = new int[3];
        for (int i = 0; i < 3; i++){
            npq[i] = Integer.parseInt(input[i]);
        }
        String[] astrlist = sc.nextLine().split(" ");
        int[] alist = new int[astrlist.length];
        for (int i = 0; i < astrlist.length; i++) {
            alist[i] = Integer.parseInt(astrlist[i]);
        }

        System.out.println(res);
    }
}
