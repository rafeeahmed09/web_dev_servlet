package Logic_servlet_JDBC;

class Singnup{
    private int id;
    private String FullName;
    private String Email Address;
    private String Phone;
    private String Password;

    public Singnup(int id, String fullName, String email, String phone, String password) {
        this.id = id;
        FullName = fullName;
        Email = email;
        Phone = phone;
        Password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}