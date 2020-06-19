package Interview.meituan;

import java.util.Arrays;
import java.util.Scanner;

public class Question2 {

    public static String solution(int n, int[] radiusNums) {
        double res = 0;
        Arrays.sort(radiusNums);
        if (n % 2 == 0) {
            for (int i = radiusNums.length-1; i >= 0; i -= 2) {
                res += Math.PI * (radiusNums[i]*radiusNums[i] - radiusNums[i-1]*radiusNums[i-1]);
            }
        } else {
            for (int i = radiusNums.length-1; i > 0; i -= 2) {
                res += Math.PI * (radiusNums[i]*radiusNums[i] - radiusNums[i-1]*radiusNums[i-1]);
            }
            res += Math.PI * (radiusNums[0]*radiusNums[0]);
        }
        return String.format("%.5f", res);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] radius = sc.nextLine().split(" ");
        int[] radiusNums = new int[radius.length];
        for (int i = 0; i < radius.length; i++){
            radiusNums[i] = Integer.parseInt(radius[i]);
        }
        String res = solution(n, radiusNums);
        System.out.println(res);
    }

}
