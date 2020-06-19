package Leetcode._0012;

public class Solution1 {

    public String intToRoman(int num) {
        String theOne = "";
        int one = num%10;
        num /= 10;
        if (one == 4) {
            theOne = "IV";
        } else if (one == 9) {
            theOne = "IX";
        } else if (one < 5) {
            while (one > 0) {
                theOne += "I";
                one--;
            }
        } else {
            theOne = "V";
            while (one-5 > 0) {
                theOne += "I";
                one--;
            }
        }

        String theTen = "";
        int ten = num%10;
        num /= 10;
        if (ten == 4) {
            theTen = "XL";
        } else if (ten == 9) {
            theTen = "XC";
        } else if (ten < 5) {
            while (ten > 0) {
                theTen += "X";
                ten--;
            }
        } else {
            theTen = "L";
            while (ten-5 > 0) {
                theTen += "X";
                ten--;
            }
        }

        String theHun = "";
        int hun = num%10;
        num /= 10;
        if (hun == 4) {
            theHun = "CD";
        } else if (hun == 9) {
            theHun = "CM";
        } else if (hun < 5) {
            while (hun > 0) {
                theHun += "C";
                hun--;
            }
        } else {
            theHun = "D";
            while (hun-5 > 0) {
                theHun += "C";
                hun--;
            }
        }

        String theTho = "";
        int tho = num;
        while (tho > 0) {
            theTho += "M";
            tho--;
        }

        return theTho+theHun+theTen+theOne;
    }

}
