package Interview.tencent;

import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

/*
小Q想要给他的朋友发送一个神秘字符串，但是他发现字符串的过于长了，
于是小Q发明了一种压缩算法对字符串中重复的部分进行了压缩，
对于字符串中连续的m个相同字符串S将会压缩为[m|S](m为一个整数且1<=m<=100)，
例如字符串ABCABCABC将会被压缩为[3|ABC]，
现在小Q的同学收到了小Q发送过来的字符串，你能帮助他进行解压缩么？
 */

public class Question1 {

    public static String solution1(String input) {
        Stack<String> stack = new Stack<>();
        int i = 0;
        while (i < input.length()) {
            char c = input.charAt(i);
            if (Character.isLetter(c)) {
                int start = i;
                while (i < input.length() && Character.isLetter(input.charAt(i))) {
                    i++;
                }
                String substr = input.substring(start, i);
                stack.add(substr);
            } else if (c == ']') {
                String str = stack.pop();
                String num = stack.pop();
                String substr = "";
                for (int j = 0; j < Integer.parseInt(num); j++) {
                    substr += str;
                }
                stack.pop(); //[
                while (!stack.isEmpty() && !isInteger(stack.peek())) {
                    String regex = stack.pop();
                    substr = regex+substr;
                }
                stack.add(substr);
                i++;
            } else if (c == '[') {
                stack.add(Character.toString(c));
                i++;
            } else if (Character.isDigit(c)) {
                int number = 0;
                while (i < input.length() && Character.isDigit(input.charAt(i))) {
                    number = number*10 + Integer.parseInt(Character.toString(input.charAt(i)));
                    i++;
                }
                stack.add(Integer.toString(number));
            } else {
                i++;
            }
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = stack.pop() + res;
        }
        return res;
    }

    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    public static String rep1(String s){ //s == [33|ABC]
        String result = "";
        int a = s.indexOf("|");
        String b = s.substring(a+1, s.length());
        int c = Integer.parseInt(s.substring(0, a));
        for (int i = 0; i < c; i++) {
            result = result + b;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        while (s.contains("|")) {
            int a = s.lastIndexOf("[");
            int b = s.indexOf("]");
            s = s.substring(0,a) + rep1(s.substring(a+1,b)) + s.substring(b+1,s.length());
        }
        System.out.println(s);
    }

    /*
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        String res = solution1(str);
        System.out.println(res);
    }
    */

}
