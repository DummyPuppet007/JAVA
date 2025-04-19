class User{
    //private variables (encapsulate)
    private int userId;
    private String username;
    private String password;

    //only access through getter & setter method
    public int getUserId() {
        return userId;
    }

    public void setUserId(int id) {
        this.userId = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pwd) {
        this.password = pwd;
    }
}

public class encapsulation {
    public static void main(String[] args) {
        User u1 = new User();
        u1.setUsername("bhaumik");   
        u1.setPassword("1234");
        System.out.println("Username : " +  u1.getUsername());
        System.out.println("Password : " + u1.getPassword());
    }
}
