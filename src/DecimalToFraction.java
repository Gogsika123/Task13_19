import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class DecimalToFraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        String decimalStr = scanner.nextLine();
        // decimalis bigdecimalad gadaqceva
        BigDecimal decimalNumber = new BigDecimal(decimalStr);
        // mteli da wiladuri nawilis gamoyofa
        BigInteger integerPart = decimalNumber.toBigInteger();
        BigDecimal fractionalPart = decimalNumber.subtract(new BigDecimal(integerPart));
        BigDecimal denominator = BigDecimal.TEN.pow(fractionalPart.scale());
        // wiladuri nawilis mnishvnelad gadaqceva
        BigInteger numerator = fractionalPart.multiply(denominator).toBigInteger();
        BigInteger gcd = numerator.gcd(denominator.toBigInteger());
        numerator = numerator.divide(gcd);
        denominator = denominator.divide(gcd.toBigInteger());
        // shedegi
        if (integerPart.compareTo(BigInteger.ZERO) != 0) {
            System.out.print("In fraction form: ");
            System.out.print(integerPart);
            if (numerator.compareTo(BigInteger.ZERO) != 0) {
                System.out.print(" " + numerator + "/" + denominator);
            }
        } else {
            System.out.print("In fraction form: ");
            System.out.print(numerator + "/" + denominator);
        }

        scanner.close();
    }
}
