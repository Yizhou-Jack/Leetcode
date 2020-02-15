package Leetcode._0028;

public class Solution {

    public static int strStr(String haystack, String needle) {
        if ((haystack.equals("") && needle.equals("") || (!haystack.equals("") && needle.equals("")))){
            return 0;
        }
        if (haystack.length() < needle.length()){
            return -1;
        }
        int lenNeedle = needle.length();
        int lenOriginalHaystack = haystack.length();
        for (int i = 0; i < needle.length(); i++){
            haystack += " ";
        }
        char firstNeedle = needle.charAt(0);
        for (int i = 0; i < lenOriginalHaystack; i++){
            if (haystack.charAt(i) == firstNeedle){
                String subHaystack = haystack.substring(i, i+lenNeedle);
                if (subHaystack.equals(needle)){
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
        String haystack = "hello";
        String needle = "el";
        int res = strStr(haystack, needle);
        System.out.println(res);
    }
}
