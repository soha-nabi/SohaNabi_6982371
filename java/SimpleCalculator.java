import java.util.Scanner;
public class SimpleCalculator {
 public static void main(String[] args) {
  Scanner scanner=new Scanner(System.in);
  double a=scanner.nextDouble();
  double b=scanner.nextDouble();
  String op=scanner.next();
  double result=0;
  switch(op) {
   case "+" -> result=a+b;
   case "-" -> result=a-b;
   case "*" -> result=a*b;
   case "/" -> result=b!=0?a/b:Double.NaN;
   default -> result=Double.NaN;
  }
  System.out.println(result);
 }
}
