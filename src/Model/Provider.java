

package Model;


public class Provider {
  private int id;
  private int cl;
  private String name;
  private String adress;
  private int phone;
  private String email;
  
  public Provider(){
      
  }

    public Provider(int id, int cl, String name, String adress, int phone, String email) {
        this.id = id;
        this.cl = cl;
        this.name = name;
        this.adress = adress;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCl() {
        return cl;
    }

    public void setCl(int cl) {
        this.cl = cl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
  
    
}
