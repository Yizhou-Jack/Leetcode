package Interview.microsoft;

import java.util.*;

public class Question2 {

    /*
    实现一个函数，输入是string类型的中文数字，输出是对应的long值
    例如：二十万五百亿三千零八万一千零五十 --> 20050030081050
     */

    public static long solution(String input) {
        Map<Character, Long> multiMap = new HashMap<>();
        multiMap.put('十', (long)10);
        multiMap.put('百', (long)100);
        multiMap.put('千', (long)1000);
        multiMap.put('万', (long)10000);
        multiMap.put('亿', (long)100000000);
        Map<Character, Long> numsMap = new HashMap<>();
        numsMap.put('零', (long)0);
        numsMap.put('一', (long)1);
        numsMap.put('二', (long)2);
        numsMap.put('三', (long)3);
        numsMap.put('四', (long)4);
        numsMap.put('五', (long)5);
        numsMap.put('六', (long)6);
        numsMap.put('七', (long)7);
        numsMap.put('八', (long)8);
        numsMap.put('九', (long)9);

        Stack<Long> stack = new Stack<>();
        stack.push(numsMap.get(input.charAt(0)));
        for (int i = 1; i < input.length(); i++) {
            char c = input.charAt(i);
            if (numsMap.containsKey(c)) {
                stack.push(numsMap.get(c));
                continue;
            }
            long subRes = 0;
            long multi = multiMap.get(c);
            while (!stack.isEmpty()) {
                if (stack.peek() < multi) {
                    subRes += stack.pop();
                } else {
                    break;
                }
            }
            stack.push(subRes*multi);
        }

        long res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }

    public static void main(String[] args) {
        String input = "二十万五百亿三千零八万一千零五十";
        long solution = solution(input);
        System.out.println(solution);
    }
}
