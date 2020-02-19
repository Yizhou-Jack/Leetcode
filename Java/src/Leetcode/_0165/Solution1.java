package Leetcode._0165;

public class Solution1 {

    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0, j = 0; i < v1.length || j < v2.length; i++, j++) {
            int n1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int n2 = j < v2.length ? Integer.parseInt(v2[j]) : 0;
            if (n1 != n2) return n1 > n2 ? 1 : -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int res = compareVersion("1.0", "1");
        System.out.println(res);
    }
}
