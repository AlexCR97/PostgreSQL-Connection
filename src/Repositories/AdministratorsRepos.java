package Repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

import DBConnection.PostgreDB;
import Entities.Administrator;

public class AdministratorsRepos {
    
    private PostgreDB db;
    
    public boolean Insert(Administrator a) {
        String query = "insert into administrators values (?, ?, ?)";
        
        try {
            PreparedStatement statement = db.getConnection().prepareStatement(query);
            statement.setInt(1, a.getId());
            statement.setString(2, a.getUserName());
            statement.setString(3, a.getPassword());
            
            statement.executeUpdate();
            statement.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(AdministratorsRepos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public ArrayList<Administrator> Select() {
        String query = "select * from administrators";
        
        try {
            PreparedStatement statement = db.getConnection().prepareStatement(query);
            
            ResultSet set = statement.executeQuery();
            ArrayList<Administrator> admins = new ArrayList<>();
            
            while (set.next()) {
                int id = set.getInt("id");
                String userName = set.getString("user_name");
                String password = set.getString("password");
                
                Administrator a = new Administrator(id, userName, password);
                admins.add(a);
            }
            
            statement.close();
            set.close();
            
            return admins;
            
        } catch (SQLException ex) {
            Logger.getLogger(AdministratorsRepos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public boolean Delete(int id) {
        String query = "delete from administrators where id = ?";
        
        try {
            PreparedStatement statement = db.getConnection().prepareStatement(query);
            statement.setInt(1, id);
            
            statement.executeUpdate();
            statement.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(AdministratorsRepos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public boolean Update(Administrator a) {
        String query = "update administrators set user_name = ?, password = ? where id = ?";
        
        try {
            PreparedStatement statement = db.getConnection().prepareStatement(query);
            statement.setString(1, a.getUserName());
            statement.setString(2, a.getPassword());
            statement.setInt(3, a.getId());
            
            statement.executeUpdate();
            statement.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(AdministratorsRepos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public AdministratorsRepos(PostgreDB db) {
        this.db = db;
    }
    
}
