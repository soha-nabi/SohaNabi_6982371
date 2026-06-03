import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class BasicJDBCConnection {
 public static void main(String[] args) throws Exception {
  Class.forName("org.sqlite.JDBC");
  try(Connection conn=DriverManager.getConnection("jdbc:sqlite:students.db");
      Statement stmt=conn.createStatement();
      ResultSet rs=stmt.executeQuery("SELECT * FROM students")) {
   while(rs.next()){
    System.out.println(rs.getInt("id")+" "+rs.getString("name"));
   }
  }
 }
}
