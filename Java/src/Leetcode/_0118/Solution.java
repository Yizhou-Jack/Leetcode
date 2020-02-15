package Leetcode._0118;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /*
    简单：杨辉三角，类似动态规划
    */

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            if (i == 0) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(1);
                res.add(tmp);
                continue;
            }
            if (i == 1) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(1);
                tmp.add(1);
                res.add(tmp);
                continue;
            }
            List<Integer> tmp = new ArrayList<>();
            tmp.add(1);
            for (int j = 0; j < res.get(i-1).size()-1; j++) {
                tmp.add(res.get(i-1).get(j)+res.get(i-1).get(j+1));
            }
            tmp.add(1);
            res.add(tmp);
        }
        return res;
    }
}
