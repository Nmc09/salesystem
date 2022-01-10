

package Model;


public class Sale {
 private int id;
 private String customer;
 private String seller;
 private double total;
 private String date;
 
 public Sale(){
     
 }

    public Sale(int id, String customer, String seller, double total,String date) {
        this.id = id;
        this.customer = customer;
        this.seller = seller;
        this.total = total;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
}
