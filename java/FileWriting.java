import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
public class FileWriting {
 public static void main(String[] args) throws IOException {
  Scanner scanner=new Scanner(System.in);
  String text=scanner.nextLine();
  Files.writeString(Path.of("output.txt"),text);
  System.out.println("Written");
 }
}
