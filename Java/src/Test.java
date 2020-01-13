import java.util.Arrays;

public class Test {

    public static int searchInsertRightMedium(int[] nums, int target) {
        int len = nums.length;

        if (len == 0) {
            return 0;
        }

        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right + 1 - left) / 2; //找右中位数
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        int l = 1;
        System.out.println(nums[l--]);
        System.out.println(nums[--l]);


        int target = 4;
        int res = searchInsertRightMedium(nums, target);
        System.out.println(res);

        String s = "abcd";
        System.out.println(s.substring(0,4));
        System.out.println(Integer.MAX_VALUE-1);
        int left = 1;
        int leftRes = left;
        left = 0;
        System.out.println(left);
        System.out.println(leftRes);
        int k = (5+6)/2;
        System.out.println(k);
        int[][] rows = new int[9][];
        int[][] columns = new int[9][];
        int[][] boxes = new int[9][];
        for (int i = 0; i < 9; i++) {
            rows[i] = new int[9];
            columns[i] = new int[9];
            boxes[i] = new int[9];
        }
        System.out.println(Arrays.toString(rows[1]));
        String phase = "1";
        String tmp = phase;
        phase = "";
        System.out.println("----------");
        System.out.println(phase);
        System.out.println(tmp);
    }
}
