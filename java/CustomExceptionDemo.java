import java.util.Scanner;
public class CustomExceptionDemo {
 static class InvalidAgeException extends Exception {
  InvalidAgeException(String message){super(message);}
 }
 public static void main(String[] args) {
  Scanner scanner=new Scanner(System.in);
  int age=scanner.nextInt();
  try {
   if(age<18) throw new InvalidAgeException("Invalid age");
   System.out.println("Valid age");
  } catch(InvalidAgeException e) {
   System.out.println(e.getMessage());
  }
 }
}
