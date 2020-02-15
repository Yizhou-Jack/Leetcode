package Leetcode._0044;

public class Solution {

    /*
    使用迭代的方法：
    start和match用来解决出现*时候的长字符串匹配问题：start记录pattern中*的index，match记录str中被*匹配到字符index。
    一种情况：str == adcebkkkkkkb；pattern == *a*bc
    在s=5、p=4之后，到了str指向第一个k，pattern指向b的情况。此时p会一直在第三个else if中==3，等待下一个b的出现来匹配中间所有的k；
    如果没有等到，p就不等于pattern.length()（因为后面没有*），return false。
    */

    public static boolean isMatch(String str, String pattern) {
        int s = 0;
        int p = 0;
        int starIndex = -1; //记录pattern中*的index
        int matchIndex = 0; //记录str中被*匹配到字符index
        while (s < str.length()) {
            //1. 一对一匹配或者匹配到了?，两指针同时后移。
            if (p < pattern.length() && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))) {
                s++;
                p++;
            }
            //2. 碰到*，在此处先假设它匹配空串，并且用starIndex记录*的index，p后移动到*的后一位。
            else if (p < pattern.length() && pattern.charAt(p) == '*'){
                starIndex = p;
                matchIndex = s;
                p++;
            }
            /*
            3. 当前字符不匹配，并且也没有*，回退（这步代表用*匹配了一个字符）
               p回到*的下一个位置；
               match更新到下一个位置；
               s回到更新后的match。
            */
            else if (starIndex != -1){
                p = starIndex + 1;
                matchIndex++;
                s = matchIndex;
            }
            //4. 字符不匹配，也没有*，返回false
            else return false;
        }

        //将末尾多余的*直接匹配空串
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;

        return p == pattern.length();
    }

    public static void main(String[] args) {
        String str = "adcebkkkkkkb";
        String pattern = "*a*bc";
        boolean res = isMatch(str, pattern);
        System.out.println(res);
    }
}
