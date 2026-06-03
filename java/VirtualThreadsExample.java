public class VirtualThreadsExample {
 public static void main(String[] args) {
  for(int i=0;i<10;i++){
   Thread.startVirtualThread(() -> System.out.println("Virtual thread"));
  }
 }
}
