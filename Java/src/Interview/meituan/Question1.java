package Interview.meituan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Question1 {

    public static int solution(char[] chars, char[] nums) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 1; i < nums.length+1; i++) {
            map.put((char)(i+'0'), nums[i-1]);
        }
        for (int i = 0; i < chars.length; i++) {
            char replace = map.get(chars[i]);
            chars[i] = replace;
        }
        String str = String.valueOf(chars);
        System.out.println(str);
        int res = Integer.parseInt(str);
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] chars = sc.nextLine().toCharArray();
        String[] strs = sc.nextLine().split(" ");
        char[] nums = new char[strs.length];
        for (int i = 0; i < strs.length; i++) {
            nums[i] = strs[i].charAt(0);
        }
        int res = solution(chars, nums);
        System.out.println(res);
    }

}
