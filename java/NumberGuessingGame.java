import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame {
 public static void main(String[] args) {
  Random random=new Random();
  int target=random.nextInt(100)+1;
  Scanner scanner=new Scanner(System.in);
  while(true){
   int guess=scanner.nextInt();
   if(guess==target){
    System.out.println("Correct");
    break;
   }
   System.out.println(guess<target?"Too Low":"Too High");
  }
 }
}
