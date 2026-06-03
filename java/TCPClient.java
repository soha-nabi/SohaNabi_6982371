import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
public class TCPClient {
 public static void main(String[] args) throws Exception {
  try(Socket socket=new Socket("localhost",5000);
      PrintWriter writer=new PrintWriter(socket.getOutputStream(),true);
      BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
   writer.println("Hello server");
   System.out.println(reader.readLine());
  }
 }
}
