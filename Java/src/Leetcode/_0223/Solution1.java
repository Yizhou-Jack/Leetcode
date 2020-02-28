package Leetcode._0223;

public class Solution1 {

    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if (A > G || E > C || B > H || F > D) return Math.abs(A-C)*Math.abs(B-D)+Math.abs(E-G)*Math.abs(F-H);
        int originOne = (C-A)*(D-B);
        int originTwo = (G-E)*(H-F);
        int width = Math.min(C, G) - Math.max(A, E);
        int height = Math.min(D, H) - Math.max(B, F);
        return originOne+originTwo-width*height;
    }

    public static void main(String[] args) {
        int res = computeArea(-3, 0, 3, 4, 0, -1, 9, 2);
        System.out.println(res);
    }
}
