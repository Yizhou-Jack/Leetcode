package Leetcode._0836;

public class Solution1 {

    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (rec1[0] >= rec2[0] && rec1[1] >= rec2[1] && rec1[2] <= rec2[2] && rec1[3] <= rec2[3]) {
            return true;
        }
        if (rec1[0] <= rec2[0] && rec1[1] <= rec2[1] && rec1[2] >= rec2[2] && rec1[3] >= rec2[3]) {
            return true;
        }
        for (int i = rec1[0]+1; i < rec1[2]; i++) {
            for (int j = rec1[1]+1; j < rec1[3]; j++) {
                if (i >= rec2[0] && j >= rec2[1] && i <= rec2[2] && j <= rec2[3]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] rec1 = new int[]{0,0,1,1};
        int[] rec2 = new int[]{1,0,2,1};
        System.out.println(isRectangleOverlap(rec1,rec2));
    }
}
