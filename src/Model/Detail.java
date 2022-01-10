


package Model;

public class Detail {
private int id;
private String code_pro;
private int amount;
private double cost;
private int id_sale;

public Detail(){
    
}
    public Detail(int id, String code_pro, int amount, double cost, int id_sale) {
        this.id = id;
        this.code_pro = code_pro;
        this.amount = amount;
        this.cost = cost;
        this.id_sale = id_sale;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode_pro() {
        return code_pro;
    }

    public void setCode_pro(String code_pro) {
        this.code_pro = code_pro;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getId_sale() {
        return id_sale;
    }

    public void setId_Sale(int id_sale) {
        this.id_sale = id_sale;
    }

}
