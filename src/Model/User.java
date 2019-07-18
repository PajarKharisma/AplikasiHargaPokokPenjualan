package Model;

import Master.Model;

public class User extends Model{
    private String username;
    private String password;
    private int akses;
    
    public User(){
        super("user");
    }
    
    public User(String username, String password, int akses){
        this.username = username;
        this.password = password;
        this.akses = akses;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAkses() {
        return akses;
    }

    public void setAkses(int akses) {
        this.akses = akses;
    }
}
