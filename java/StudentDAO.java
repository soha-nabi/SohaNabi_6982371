import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class StudentDAO {
 public void insert(int id,String name) throws Exception {
  try(Connection conn=DriverManager.getConnection("jdbc:sqlite:students.db");
      PreparedStatement ps=conn.prepareStatement("INSERT INTO students(id,name) VALUES(?,?)")) {
   ps.setInt(1,id);
   ps.setString(2,name);
   ps.executeUpdate();
  }
 }
 public void update(int id,String name) throws Exception {
  try(Connection conn=DriverManager.getConnection("jdbc:sqlite:students.db");
      PreparedStatement ps=conn.prepareStatement("UPDATE students SET name=? WHERE id=?")) {
   ps.setString(1,name);
   ps.setInt(2,id);
   ps.executeUpdate();
  }
 }
 public static void main(String[] args) throws Exception {
  StudentDAO dao=new StudentDAO();
  dao.insert(1,"Alice");
  dao.update(1,"AliceUpdated");
  System.out.println("Done");
 }
}
