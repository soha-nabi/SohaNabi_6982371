import java.lang.reflect.Method;
public class ReflectionExample {
 public static void hello() { System.out.println("Hello"); }
 public static void main(String[] args) throws Exception {
  Class<?> cls=Class.forName("ReflectionExample");
  Method method=cls.getDeclaredMethod("hello");
  method.invoke(null);
  for(Method m:cls.getDeclaredMethods()) System.out.println(m.getName());
 }
}
