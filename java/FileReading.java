import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
public class FileReading {
 public static void main(String[] args) throws IOException {
  for(String line:Files.readAllLines(Path.of("output.txt"))) {
   System.out.println(line);
  }
 }
}
