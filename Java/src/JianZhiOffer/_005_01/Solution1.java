package JianZhiOffer._005_01;

public class Solution1 {

    public static String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') sb.append("%20");
            else sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String res = replaceSpace("We are happy.");
        System.out.println(res);
    }
}
