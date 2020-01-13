package tools;

public class AlgorithmMode {

    /*
    二分查找（找左中位数）
    */
    public static int searchLeftMedium(int[] nums, int target) {
        int len = nums.length;

        if (len == 0) {
            return 0;
        }

        int left = 0;
        int right = len - 1;
        while (left < right) {
            //mid = (left + right) >> 1
            int mid = left + (right - left) / 2; //找左中位数
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /*
    二分查找（找右中位数）
    */
    public static int searchRightMedium(int[] nums, int target) {
        int len = nums.length;

        if (len == 0) {
            return 0;
        }

        int left = 0;
        int right = len - 1;
        while (left < right) {
            //mid = (left + right + 1) >> 1
            int mid = left + (right + 1 - left) / 2; //找右中位数
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    /*
    滑动窗口通用mode，伪代码
    public static void slidingWindow(String s) {
        int left = 0, right = 0;

        while (right < s.length()) {
            window.add(s[right]);
            right++;

            while (valid) {
                window.remove(s[left]);
                left++;
            }
        }
    }
    */

    /*
    回溯算法通用mode
    public List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0, nums, new LinkedList<>());
        return res;
    }

    public void backtrack(int i, int[] nums, LinkedList<Integer> track) {
        res.add(new LinkedList<>(track));
        for (int j = i; j < nums.length; j++) { //循环开启的位置不一定相同：参见46/78
            //做选择
            track.add(nums[j]);
            //进入下一层决策树
            backtrack(j + 1, nums, track);
            //取消选择
            track.removeLast();
        }
    }
    */
}
