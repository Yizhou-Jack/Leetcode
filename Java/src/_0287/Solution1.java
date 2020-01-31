package _0287;

public class Solution1 {

    /*
    使用环形链表II的方法解题（142.环形链表II）
    如果数组中有重复的数，整数的数组nums中的数字范围是[1,n]，从下标为0出发，根据f(n)计算出一个值，以这个值为新的下标，
    会出现一个环，快指针和慢指针相同时，出现环的入口（也就是环形链表中的快指针和慢指针的差）
    第二次while则先将差设置出来，在他们相等的时候即为相同的值。
    */

    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        int pre1 = 0;
        int pre2 = slow;
        while (pre1 != pre2) {
            pre1 = nums[pre1];
            pre2 = nums[pre2];
        }
        return pre1;
    }

}
