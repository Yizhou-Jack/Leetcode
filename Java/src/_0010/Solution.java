package _0010;

public class Solution {

    /*
    递归并使用动态规划的方法优化
    */

    private static int[][] res;

    public static boolean isMatch(String s, String p){
        if (s == null || p == null){
            return false;
        }
        res = new int[s.length()+1][p.length()+1]; //加长数组至length+1，以防index i,j越界
        return getRes(0, 0, s, p);
    }

    public static boolean getRes(int i, int j, String s, String p){
        if (p.length() == j){
            return s.length() == i; //如果p检查完了，s还没有检查完，那么就不匹配（如abcd和abc*比较）
        }
        if (res[i][j] != 0){
            return res[i][j] == 1; //s从0到i，p从0到j部分已经检查过了，res内若为1则是符合，res内若为-1则是不符合
        }
        //当i没有走到尽头时，检查此时的i与j位置上的字母是否相同；如果p的j位置是通配符'.'，那么也算匹配上了
        boolean firstMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        //f为不断递归的结果（有很多子问题）
        boolean f;
        if (j+1 < p.length() && p.charAt(j+1) == '*'){
            /*
            当j+1没有走到尽头时，检查j+1位置上是否为通配符'*'
            如果是'*'：
            getRes(i, j+2, s, p)为检查未出现的字符（如b和a*b比较）；
                                或者是aaabc和a*bc比较时，i移动到了aaabc的b处，j还在a*bc的a处。
                                此时 || 条件就可以让||前的getRes(i, j+2, s, p)继续检查i移动到aaabc的b处，j移动到a*bc的b处情况
            firstMatch && getRes(i+1, j, s, p)为向前移动i，观察通配符是否匹配到了正确的值，
                                匹配到了则移动i直到这个子字符序列结束（如aaabc和a*bc比较，i移动到aaabc的b处）
            */
            f = getRes(i, j+2, s, p) || (firstMatch && getRes(i+1, j, s, p));
        } else{
            //如果不是'*'，那么f为刚才检查出的firstMatch并上getRes(i+1, j+1, s, p)（即both向后移动一位的递归结果）
            f = firstMatch && getRes(i+1, j+1, s, p);
        }
        res[i][j] = f ? 1 : -1; //填写res表
        return f;
    }

    public static void main(String[] args) {
        String s = "abc";
        String p = "a*b*c*d";
        System.out.println(isMatch(s, p));
    }
}
