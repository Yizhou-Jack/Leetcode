package Leetcode._0277;

import java.util.Arrays;

public class Solution1 {

    /*
    遍历一次数组：
    对于更新之后的res没有必要重新找前面的i来确认是否know，因为如果先前的res如果认识前面的i的话，已经被更新了
     */

    public static int findCelebrity(int n) {
        int res = 0;
        for (int i = 1; i < n; i++) { //遍历找名人，不停更新res。
            if (knows(res,i)) {
                res = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (res == i) continue;
            if (knows(res,i) || !knows(i,res)) return -1; //两个人并且互不认识
        }
        return res;
    }

    public static boolean knows(int a, int b) {
        if (a == 0 && b == 0) return true;
        if (a == 1 && b == 0) return false;
        if (a == 0 && b == 1) return false;
        if (a == 1 && b == 1) return true;
        return true;
    }

    public static void main(String[] args) {
        int res = findCelebrity(2);
        System.out.println(res);
    }
}
