import java.sql.*;
import java.util.List;
import java.util.Optional;

public class ComicBookDao implements Dao {
    @Override
    public Optional get(long id) {
        return Optional.empty();
    }

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public void save(Object o) {

    }

    @Override
    public void update(Object o, String[] params) {

    }

    @Override
    public void delete(Object o) {

    }

public static void outputDB(){

    final String DB_URL = "jdbc:derby:ComicDB";
    Statement stmt = null;
    Connection conn = null;
    try {
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL);
        System.out.println("Creating statement...");
        stmt = conn.createStatement();
        String sql;
        sql = "SELECT Title, Description, Price FROM ComicBook";
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            //Retrieve by column name
            String id = rs.getString("Title");
            double price = rs.getDouble("Price");
            String description = rs.getString("Description");

            //Display values
            System.out.print("ID: " + id.trim());
            System.out.print(", Price: " + price);
            System.out.println(", Description: " + description);
        }
        //STEP 6: Clean-up environment
        rs.close();
        stmt.close();
        conn.close();
    } catch (SQLException se) {
        //Handle errors for JDBC
        se.printStackTrace();
    } catch (Exception e) {
        //Handle errors for Class.forName
        e.printStackTrace();
    } finally {
        //finally block used to close resources
        try {
            if (stmt != null)
                stmt.close();
        } catch (SQLException se2) {
        }// nothing we can do
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }//end finally try
    }//end try

}
    public static void addContent(ComicBook book) {
        final String DB_URL = "jdbc:derby:ComicDB";
        Statement stmt = null;
        Connection conn = null;
        try{
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            System.out.println("Inserting records into the table...");
            stmt = conn.createStatement();
//

            stmt.execute("INSERT INTO ComicBook VALUES ( " +
                    "'" + book.getName() + "', " +
                    "'" + book.getDescription() + "', " +
                    ""+ book.getPrice() + " )");


            System.out.println("Inserted records into the table...");
            //Clean-up environment
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }
}
