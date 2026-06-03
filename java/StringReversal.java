import java.util.Scanner;
public class StringReversal {
 public static void main(String[] args) {
  Scanner scanner=new Scanner(System.in);
  String s=scanner.nextLine();
  StringBuilder builder=new StringBuilder(s);
  System.out.println(builder.reverse().toString());
 }
}
