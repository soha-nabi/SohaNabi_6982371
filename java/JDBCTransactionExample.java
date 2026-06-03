import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class JDBCTransactionExample {
 public static void main(String[] args) throws Exception {
  try(Connection conn=DriverManager.getConnection("jdbc:sqlite:accounts.db")) {
   conn.setAutoCommit(false);
   try(PreparedStatement debit=conn.prepareStatement("UPDATE accounts SET balance=balance-? WHERE id=?");
       PreparedStatement credit=conn.prepareStatement("UPDATE accounts SET balance=balance+? WHERE id=?")) {
    debit.setDouble(1,50);
    debit.setInt(2,1);
    credit.setDouble(1,50);
    credit.setInt(2,2);
    debit.executeUpdate();
    credit.executeUpdate();
    conn.commit();
   } catch(Exception e) {
    conn.rollback();
    throw e;
   }
  }
 }
}
