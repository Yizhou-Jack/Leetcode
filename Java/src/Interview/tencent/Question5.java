package Interview.tencent;

import java.util.*;

public class Question5 {

    public static int xLayer(int x) {
        int o = 1;
        int sum = 0;
        int layer = 0;
        while (x > sum) {
            sum += o;
            layer++;
            o *= 2;
        }
        return layer;
    }

    public static int[] solution1(String[] opers) {
        int[] res = new int[opers.length];
        for (int i = 0; i < opers.length; i++) {
            String[] xandk = opers[i].split(" ");
            int x = Integer.parseInt(xandk[0]);
            int k = Integer.parseInt(xandk[1]);
            int xLayer = xLayer(x);
            if (xLayer <= k) {
                res[i] = -1;
            } else {
                int minus = (int)Math.pow(2, xLayer-k);
                int upnodes = (int)Math.pow(2, xLayer-1)-1;
                int left = x-upnodes;
                int count = 0;
                while (left > 0) {
                    left = left-minus;
                    count++;
                }
                res[i] = (int)Math.pow(2, k-1)+count-1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int Q = Integer.parseInt(s.nextLine());
        String[] opers = new String[Q];
        for (int i = 0; i < Q; i++) {
            opers[i] = s.nextLine();
        }
        int[] res = solution1(opers);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

}
