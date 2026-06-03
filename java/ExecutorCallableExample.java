import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
public class ExecutorCallableExample {
 public static void main(String[] args) throws Exception {
  ExecutorService executor=Executors.newFixedThreadPool(3);
  List<Callable<String>> tasks=new ArrayList<>();
  tasks.add(() -> "Task1");
  tasks.add(() -> "Task2");
  tasks.add(() -> "Task3");
  List<Future<String>> futures=executor.invokeAll(tasks);
  for(Future<String> future:futures) System.out.println(future.get());
  executor.shutdown();
 }
}
