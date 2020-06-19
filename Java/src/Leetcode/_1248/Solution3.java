package Leetcode._1248;

public class Solution3 {

    /*
    滑动窗口法
     */

    public static int numberOfSubarrays(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int res = 0;
        int oddCount = 0;
        while (right < nums.length) {
            if (nums[right]%2 == 1) {
                oddCount++;
            }
            right++;

            if (oddCount == k) {
                int temp = right;
                //找最右边的奇数至下一个奇数之间偶数的个数
                while (right < nums.length && nums[right]%2 == 0) {
                    right++;
                }
                int rightEvenNum = right-temp;

                //找最左边的奇数至前一个奇数（或者开头）之间偶数的个数
                int leftEvenNum = 0;
                while (nums[left]%2 == 0) {
                    left++;
                    leftEvenNum++;
                }

                res += (leftEvenNum+1)*(rightEvenNum+1); //(leftEvenNum+1)*(rightEvenNum+1)为这个区间能给res加的数量
                left++; //将第一个奇数排除
                oddCount--; //将第一个奇数排除
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,2,1,2,2,1,2,2,2};
        int res = numberOfSubarrays(nums, 2);
        System.out.println(res);
    }
}
