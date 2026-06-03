public class ThreadCreation {
 static class SimpleThread extends Thread {
  private final String message;
  SimpleThread(String message){this.message=message;}
  public void run(){for(int i=0;i<3;i++) System.out.println(message);}
 }
 public static void main(String[] args) {
  new SimpleThread("Thread1").start();
  new SimpleThread("Thread2").start();
 }
}
