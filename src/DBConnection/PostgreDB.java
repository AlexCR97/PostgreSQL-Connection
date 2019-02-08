package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostgreDB {
    
    private Connection connection;
    private String url;
    private String user;
    private String pass;
    private String dbName;
    
    public Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, pass);
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PostgreDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return connection;
    }
    
    public PostgreDB(String user, String pass, String dbName) {
        this.user = user;
        this.pass = pass;
        this.dbName = dbName;
        
        url = "jdbc:postgresql://localhost:5432/" + this.dbName;
    }
    
    public static void main(String[] args) {
        PostgreDB db = new PostgreDB("postgres", "Carp1997", "carp");
        
        if (db.getConnection() == null) {
            System.out.println("Connection failed.");
            return;
        }
        
        System.out.println("Connection successful!");
    }
    
}
