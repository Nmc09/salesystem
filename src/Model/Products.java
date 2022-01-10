

package Model;


public class Products {
    private int id;
    private String code;
    private String name;
    private String providerPr;
    private int stock;
    private double cost;
    
    public Products(){
        
    }

    public Products(int id, String code, String name, String providerPr, int stock, double cost) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.providerPr = providerPr;
        this.stock = stock;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProviderPr() {
        return providerPr;
    }

    public void setProviderPr(String providerPr) {
        this.providerPr = providerPr;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    
}
