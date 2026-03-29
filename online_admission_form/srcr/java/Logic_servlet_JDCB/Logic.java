package Logic_servlet_JDBC;

 class Logic {
    private String email;
    private String password;

     public Logic(String email, String password) {
         this.email = email;
         this.password = password;
     }

     public String getEmail() {
         return email;
     }

     public void setEmail(String email) {
         this.email = email;
     }

     public String getPassword() {
         return password;
     }

     public void setPassword(String password) {
         this.password = password;
     }
 }