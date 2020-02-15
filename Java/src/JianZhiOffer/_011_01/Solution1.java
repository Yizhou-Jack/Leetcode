package JianZhiOffer._011_01;

public class Solution1 {

    public static int minArray(int[] numbers) {
        int len = numbers.length;
        if (len == 1) return numbers[0];
        for (int i = 0; i < len-1; i++) {
            if (numbers[i+1] < numbers[i]) return numbers[i+1];
        }
        return numbers[0];
    }

}
