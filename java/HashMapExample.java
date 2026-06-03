import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class HashMapExample {
 public static void main(String[] args) {
  Scanner scanner=new Scanner(System.in);
  Map<Integer,String> map=new HashMap<>();
  int count=scanner.nextInt();
  for(int i=0;i<count;i++){
   int id=scanner.nextInt();
   String name=scanner.next();
   map.put(id,name);
  }
  int query=scanner.nextInt();
  System.out.println(map.get(query));
 }
}
