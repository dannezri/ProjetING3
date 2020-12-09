import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;


public class Index {
    private static Connection getDatabaseConnection()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver OK");

            String url="jdbc:mysql://localhost:8889/javaClass";
            String user="lacryo_root";
            String password="Nezri1974";
            // Create a connection to the database.
            Connection cnx = DriverManager.getConnection(url, user, password);
            System.out.println("Connexion OK");



            return cnx;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            System.exit(0);
            return null;
        }
    }

    public static void main(String[] args) throws Exception {

        GUILogin GUI_APP = new GUILogin(getDatabaseConnection());
        GUI_APP.window_param();
    }
}
