package Interview.tencent;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Question3 {

    public static String solution1(int[] nums) {
        Queue<String> queue = new LinkedList<>();
        return "";
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = Integer.parseInt(s.nextLine());
        String[] numsStr = s.nextLine().split(" ");
        int[] nums = new int[num];
        for (int i = 0; i < num; i++) {
            nums[i] = Integer.parseInt(numsStr[i]);
        }
        String res = solution1(nums);
        System.out.println(res);
    }
}
