package entity;

public class User {
    int usearid;
    String username;
    String password;

    public User(int usearid, String username, String password) {
        this.usearid = usearid;
        this.username = username;
        this.password = password;
    }

    public int getUsearid() {
        return usearid;
    }

    public void setUsearid(int usearid) {
        this.usearid = usearid;
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
}
