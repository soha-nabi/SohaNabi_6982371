import java.math.BigInteger;
import java.util.Scanner;
public class FactorialCalculator {
 public static void main(String[] args) {
  Scanner scanner=new Scanner(System.in);
  int n=scanner.nextInt();
  BigInteger result=BigInteger.ONE;
  for(int i=1;i<=n;i++) result=result.multiply(BigInteger.valueOf(i));
  System.out.println(result);
 }
}
