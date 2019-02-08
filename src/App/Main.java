package App;

import java.util.ArrayList;

import DBConnection.PostgreDB;
import Entities.Administrator;
import Repositories.AdministratorsRepos;

public class Main {
    
    public static void main(String[] args) {
        PostgreDB db = new PostgreDB("postgres", "Carp1997", "carp");
        
        if (db.getConnection() == null) {
            System.out.println("Connection failed.");
            return;
        }
        System.out.println("Connection successful!");
        
        AdministratorsRepos adminRepos = new AdministratorsRepos(db);
        Administrator a = new Administrator(3, "Alez", "2468");
        ArrayList<Administrator> admins;
        
        boolean success;
        //success = adminRepos.Insert(a);
        //success = adminRepos.Delete(2);
        //success = adminRepos.Update(a);
        
        /*
        if (!success) {
            System.out.println("Query failed.");
            return;
        }
        
        System.out.println("Query successful!");
        */
        
        admins = adminRepos.Select();
        if (admins == null) {
            System.out.println("Query failed.");
            return;
        }
        
        for (Administrator admin: admins)
            System.out.println(admin);
    }
}
