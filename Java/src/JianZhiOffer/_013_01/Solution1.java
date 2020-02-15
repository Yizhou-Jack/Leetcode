package JianZhiOffer._013_01;

import java.util.LinkedList;

public class Solution1 {

    public int movingCount(int m, int n, int k) {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        boolean[][] visited = new boolean[m][n];
        int res = 0;

        while(!queue.isEmpty()){
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            if (!visited[x][y]) {
                visited[x][y] = true;
                if (checkValid(x,y,k)) {
                    res++;
                    if(y + 1 < n && !visited[x][y + 1])
                        queue.add(new int[]{x, y + 1});
                    if(x + 1 < m && !visited[x + 1][y])
                        queue.add(new int[]{x + 1, y});
                    if(y - 1 >= 0 && !visited[x][y - 1])
                        queue.add(new int[]{x, y - 1});
                    if(x - 1 >= 0 && !visited[x - 1][y])
                        queue.add(new int[]{x - 1, y});
                }
            }
        }
        return res;
    }

    public boolean checkValid(int m, int n, int k) {
        int sum = 0;
        while (m > 0) {
            sum += m%10;
            m /= 10;
        }
        while (n > 0) {
            sum += n%10;
            n /= 10;
        }
        return sum <= k;
    }
}
