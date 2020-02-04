package _0454;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {

    /*
    首先两组int相加，把相反数结果存到hashmap里，value是出现的次数；
    然后另外两组int相加，把结果在hashmap里查找，如果找到就加上这个数的value值
    */

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int len = A.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int AB = A[i]+B[j];
                int num = map.getOrDefault(-AB, 0);
                map.put(-AB, ++num);
            }
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int CD = C[i]+D[j];
                if (map.getOrDefault(CD, 0) > 0) {
                    res += map.get(CD);
                }
            }
        }
        return res;
    }
}
