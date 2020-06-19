package Interview.meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question3 {

    public static List<List<Integer>> res = new ArrayList<>();

    public static void dfs(List<Integer> path, int i, int n, int[] nums) {
        if (i >= n && !res.contains(path) && path.size() > 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < n; j++) {
            dfs(path, j+1, n, nums);
            if (nums[j] % (path.size()+1) == 0) {
                path.add(nums[j]);
                dfs(path, j+1, n, nums);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] numsStr = sc.nextLine().split(" ");
        int[] nums = new int[numsStr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(numsStr[i]);
        }
        List<Integer> path = new ArrayList<>();
        dfs(path, 0, n, nums);
        System.out.println(res.size());
    }

}
