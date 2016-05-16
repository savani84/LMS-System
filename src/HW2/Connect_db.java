package HW2;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect_db {
	static Connection con=null;
    public static Connection getConnection()
    {
        //if (con != null) return con;
        // get db, user, pass from settings file
        return getConnection("jdbc:mysql://cs3.calstatela.edu:3306/cs320stu138", "cs320stu138", "hzZ.Cu7Q");
        //return getConnection("jdbc:mysql://localhost:3306/cs320stu138", "root", "abcd");
    }

    private static Connection getConnection(String db_name,String user_name,String password)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection( db_name, user_name, password );
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return con;        
    }
}
