import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
public class TCPServer {
 public static void main(String[] args) throws Exception {
  try(ServerSocket server=new ServerSocket(5000);
      Socket socket=server.accept();
      BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
      PrintWriter writer=new PrintWriter(socket.getOutputStream(),true)) {
   String line=reader.readLine();
   writer.println("Received: "+line);
  }
 }
}
