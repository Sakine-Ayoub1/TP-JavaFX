package ma.enset.tpJavaFX.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnexionDBSingleton {

    private static Connection connection;

    static  {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB_STOCK", "root", "");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
