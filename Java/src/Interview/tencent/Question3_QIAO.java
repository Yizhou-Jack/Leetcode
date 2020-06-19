package Interview.tencent;

import java.util.*;
import javafx.util.Pair;

public class Question3_QIAO {

    public static int solution1(int[] arrA, int[] arrB) {
        if (isOK(arrA)) return 0;
        PriorityQueue<Pair<int[], Integer>> queue = new PriorityQueue<>(5,
                new Comparator<Pair<int[], Integer>>() {
                    public int compare(Pair<int[], Integer> a, Pair<int[], Integer> b) {
                        return a.getValue() - b.getValue();
                    }
                });
        queue.add(new Pair<>(arrA, 0));
        while (!queue.isEmpty()) {
            Pair<int[], Integer> popPair = queue.poll();
            int[] popArr = popPair.getKey();
            Integer count = popPair.getValue();
            for (int i = 0; i < popArr.length-1; i++) {
                for (int j = i+1; j < popArr.length; j++) {
                    int temp1 = popArr[i];
                    int temp2 = popArr[j];
                    if (arrA[i] == temp1) {
                        popArr[i] = arrB[i];
                    } else {
                        popArr[i] = arrA[i];
                    }
                    if (arrA[j] == temp2) {
                        popArr[j] = arrB[j];
                    } else {
                        popArr[j] = arrA[j];
                    }
                    int temp = popArr[i];
                    popArr[i] = popArr[j];
                    popArr[j] = temp;
                    if (isOK(popArr)) return count+1;
                    queue.add(new Pair<>(popArr, count+1));
                    popArr[i] = temp1;
                    popArr[j] = temp2;
                }
            }
        }
        return -1;
    }

    public static boolean isOK(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] < arr[i+1]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = Integer.parseInt(s.nextLine());
        int[] arrA = new int[num];
        int[] arrB = new int[num];
        String[] arrAStr = s.nextLine().split(" ");
        String[] arrBStr = s.nextLine().split(" ");
        for (int i = 0; i < num; i++) {
            arrA[i] = Integer.parseInt(arrAStr[i]);
            arrB[i] = Integer.parseInt(arrBStr[i]);
        }
        int res = solution1(arrA, arrB);
    }

}
