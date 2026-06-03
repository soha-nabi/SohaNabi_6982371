import java.util.Scanner;
public class EvenOddChecker {
 public static void main(String[] args) {
  Scanner scanner=new Scanner(System.in);
  int value=scanner.nextInt();
  System.out.println(value%2==0?"Even":"Odd");
 }
}
