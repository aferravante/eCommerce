package it.cspnet.ecommerce.data;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
    private String dbUserName;
    private String dbPassword;
    private String url;
    
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("manca supporto db");
            System.exit(1);
        }
        
    }

    public DAO() {
    }

    public void setDbUserName(String dbUserName) {
        this.dbUserName = dbUserName;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
    

    public DAO(String dbUserName, String dbPassword, String url) {
        this.dbUserName = dbUserName;
        this.dbPassword = dbPassword;
        this.url = url;
    }
    
    public Connection getConnection() throws Exception{
        return DriverManager.getConnection(url, dbUserName, dbPassword);
    }
    
}
