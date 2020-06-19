package Math;

public class Sqrt {

    public static double sqrt(int t) {
        int i = 0;
        for (; i < t; i++) {
            if (i*i == t) {
                return i;
            }
            if (i*i > t) {
                break;
            }
        }

        double left = i-1;
        double right = i;
        double precise = 1e-7;
        while (right - left > precise) {
            double middle = (left+right)/2;
            double square = middle*middle;
            if (square > t) {
                right = middle;
            } else {
                left = middle;
            }
        }

        return (left+right)/2;
    }

    public static void main(String[] args) {
        double res = sqrt(5);
        System.out.println(res);
    }
}
