import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String s = "abcd";
        System.out.println(s.substring(0,4));
        System.out.println(Integer.MAX_VALUE-1);
        int left = 1;
        int leftRes = left;
        left = 0;
        System.out.println(left);
        System.out.println(leftRes);
        int k = (5+6)/2;
        System.out.println(k);
        int[][] rows = new int[9][];
        int[][] columns = new int[9][];
        int[][] boxes = new int[9][];
        for (int i = 0; i < 9; i++) {
            rows[i] = new int[9];
            columns[i] = new int[9];
            boxes[i] = new int[9];
        }
        System.out.println(Arrays.toString(rows[1]));
        String phase = "1";
        String tmp = phase;
        phase = "";
        System.out.println("----------");
        System.out.println(phase);
        System.out.println(tmp);
    }
}
