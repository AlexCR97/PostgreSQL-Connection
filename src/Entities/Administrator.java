package Entities;

public class Administrator {
    
    private int id;
    private String userName;
    private String password;
    
    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
    
    @Override
    public String toString() {
        String s = String.format(
              "ID: %s\n"
            + "User Name: %s\n"
            + "Password: %s\n",
                id, userName, password
        );
        return s;
    }
    
    public Administrator(int id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }
    
}
