package tools;

import structures.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class AlgorithmMode {

    /*
    二维矩阵DFS递归模板
     */
    public int res = 0;

    public int DFSRecursion(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        dfs(0,0,m,n,visited);
        return res;
    }

    public void dfs(int x, int y, int m, int n, boolean[][] visited) {
        if (x >= m || x < 0 || y >= n || y < 0 || visited[x][y]) return; //再加额外的题目要求条件
        res++;
        visited[x][y] = true;
        dfs(x+1, y, m, n, visited);
        dfs(x-1, y, m, n, visited);
        dfs(x, y+1, m, n, visited);
        dfs(x, y-1, m, n, visited);
    }

    /*
    二维矩阵DFS迭代模板
     */
    public int DFSIteration(int m, int n) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0,0});
        boolean[][] visited = new boolean[m][n];
        int res = 0;

        while (!stack.isEmpty()) {
            int[] point = stack.pop();
            int x = point[0];
            int y = point[1];
            if (!visited[x][y]) {
                visited[x][y] = true;
                if (true) { //符合某个题目的条件
                    res++;
                    if(y + 1 < n && !visited[x][y + 1])
                        stack.push(new int[]{x, y + 1});
                    if(x + 1 < m && !visited[x + 1][y])
                        stack.push(new int[]{x + 1, y});
                    if(y - 1 >= 0 && !visited[x][y - 1])
                        stack.push(new int[]{x, y - 1});
                    if(x - 1 >= 0 && !visited[x - 1][y])
                        stack.push(new int[]{x - 1, y});
                }
            }
        }
        return res;
    }

    /*
    二维矩阵BFS迭代模板
     */
    public int BFS(int m, int n, int k) {
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
                if (true) { //符合某个题目的条件
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

    /*
    二叉树的遍历（递归方法）
     */
    public List<Integer> treeTraversal = new ArrayList<>();

    public void inorder(TreeNode root) { //中序遍历
        if (root == null) {
            return;
        }
        inorder(root.left);
        treeTraversal.add(root.val);
        inorder(root.right);
    }

    public void preorder(TreeNode root) { //先序遍历
        if (root == null) {
            return;
        }
        treeTraversal.add(root.val);
        inorder(root.left);
        inorder(root.right);
    }

    public void postorder(TreeNode root) { //后序遍历
        if (root == null) {
            return;
        }
        inorder(root.left);
        inorder(root.right);
        treeTraversal.add(root.val);
    }
}
