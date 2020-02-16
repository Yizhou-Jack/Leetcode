package JianZhiOffer._014_01;

public class Solution1 {

    public static int cuttingRope(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        if (n == 3) return 2;

        int prev = 0;
        int curr = 0;
        for (int i = 2; i <= n/2; i++) {
            int divide = n/i;
            int left = n%i;
            curr = 1;
            for (int j = 0; j < i-left; j++) {
                curr *= divide;
            }
            for (int j = 0; j < left; j++) {
                curr *= (divide+1);
            }
            if (curr < prev) return prev;
            prev = curr;
        }

        return curr;
    }

    public static void main(String[] args) {
        int res = cuttingRope(10);
        System.out.println(res);
    }
}
