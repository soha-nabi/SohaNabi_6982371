import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ArrayListExample {
 public static void main(String[] args) {
  Scanner scanner=new Scanner(System.in);
  List<String> names=new ArrayList<>();
  int count=scanner.nextInt();
  scanner.nextLine();
  for(int i=0;i<count;i++) names.add(scanner.nextLine());
  for(String name:names) System.out.println(name);
 }
}
