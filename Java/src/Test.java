public class Test {
    public static void main(String[] args) {
        String sum = "99999991";
        int intsum = Integer.parseInt(sum);
        int sumsum = intsum % 10;
        int carry = intsum / 10;
        System.out.println(sumsum);
        System.out.println(carry);
    }
}
