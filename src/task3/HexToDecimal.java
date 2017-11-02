package task3;

public class HexToDecimal {

    public static void main(String[] args) {

        String number_10 = "478";
        int number_16 = hexToDecimal(number_10);
        System.out.println("10-ричное: " + number_10 + ". 16-ричное: " + number_16);
    }

    public static int hexToDecimal(String number_10) {
        String digits = "0123456789ABCDEF";
        number_10 = number_10.toUpperCase();
        int total = 0;

        for (int i = 0; i < number_10.length(); i++) {
            char currentNumeral = number_10.charAt(i);
            int d = digits.indexOf(currentNumeral);
            total = 16*total + d;
        }

        return total;
    }
}
