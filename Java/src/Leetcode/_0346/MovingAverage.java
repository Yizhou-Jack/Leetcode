package Leetcode._0346;

import java.util.ArrayList;
import java.util.List;

public class MovingAverage {

    int size;
    List<Integer> queue = new ArrayList<>();

    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        queue.add(val);
        // calculate the sum of the moving window
        int windowSum = 0;
        for(int i = Math.max(0, queue.size() - size); i < queue.size(); ++i)
            windowSum += (int)queue.get(i);

        return windowSum * 1.0 / Math.min(queue.size(), size);
    }
}
