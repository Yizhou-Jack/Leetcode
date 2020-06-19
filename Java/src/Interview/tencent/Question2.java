package Interview.tencent;

import java.util.*;

public class Question2 {

    /*
    小Q在周末的时候和他的小伙伴来到大城市逛街，一条步行街上有很多高楼，共有n座高楼排成一行。
    小Q从第一栋一直走到了最后一栋，小Q从来都没有见到这么多的楼，所以他想知道他在每栋楼的位置处能看到多少栋楼呢？
    （当前面的楼的高度大于等于后面的楼时，后面的楼将被挡住）
     */

    public static String solution1(int[] nums) {
        int len = nums.length;
        int[] looks = new int[len];

        Stack<Integer> stack = new Stack<>();
        for (int i = len-1; i >= 0; i--) {
            looks[i] = stack.size();
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                stack.pop();
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = 0; i < len; i++) {
            looks[i] = looks[i] + 1 + stack.size();
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                stack.pop();
            }
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(looks[i]);
            sb.append(" ");
        }

        return sb.deleteCharAt(sb.length()-1).toString();
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
