package _0215;

import java.util.PriorityQueue;

public class Solution2 {

    /*
    维护一个小顶堆，最后返回堆顶部的数字
    */

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : nums) {
            pq.add(val);
            //维护堆的大小为 K
            if (pq.size() > k) {
                //弹出最顶端的数,并删除
                pq.poll();
            }
        }
        //取最顶端的数
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] intArr = new int[]{3,2,3,1,2,4,5,5,6};
        int res = findKthLargest(intArr, 4);
        System.out.println(res);
    }
}
