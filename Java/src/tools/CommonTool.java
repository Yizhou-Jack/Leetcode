package tools;

public class CommonTool {

    /*
    判断char是否为字母或者是数字
    */
    public boolean isLetterOrDigit (char c) {
        boolean res1 = Character.isLetterOrDigit(c);
        boolean res2 = Character.isLetter(c); //判断char是否为字母
        boolean res3 = Character.isDigit(c); //判断char是否为数字
        return res1;
    }

    /*
    将char改为小写
    */
    public char charToLowerCase (char c) {
        char res = Character.toLowerCase(c);
        return res;
    }
}
