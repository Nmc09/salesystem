

package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class SaleDAO {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public int IdSale(){
        int id =0;
        String sql = "SELECT MAX(id)FROM sales";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            if(rs.next()){
                id = rs.getInt(1);
            }
            
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return id;
    }
    
   public int RegisterSale(Sale s){
       String sql = " INSERT INTO sales(customer, seller,total,date) VALUES (?,?,?,?)";
       try {
         con = cn.getConnection();
         ps= con.prepareStatement(sql);
         ps.setString(1,s.getCustomer());
         ps.setString(2,s.getSeller());
         ps.setDouble(3,s.getTotal());
         ps.setString(4,s.getDate());
         ps.execute();
       } catch (SQLException e) {
           System.out.println(e.toString());
       }finally{
           try {
               con.close();
           } catch (SQLException e) {
               System.out.println(e.toString());
           }
       }
       return r;
   } 
   public int RegisterDetail(Detail Sd){
       String sql = "INSERT INTO details (code_pro,amount,cost,id_sale) VALUES (?,?,?,?)";
       try {
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           ps.setString(1,Sd.getCode_pro());
           ps.setInt(2,Sd.getAmount());
           ps.setDouble(3,Sd.getCost());
           ps.setInt(4,Sd.getId());
           ps.execute();
       } catch (SQLException e) {
           System.out.println(e.toString());
       }finally{
           try {
               con.close();
           } catch (SQLException e) {
               System.out.println(e.toString());
           }
       }
       return r;
   }
   public boolean UpdateStock(int amount, String code){
       String sql = " UPDATE products SET stock = ? WHERE code = ?";
       try {
         con = cn.getConnection();
         ps = con.prepareStatement(sql);
         ps.setInt(1, amount);
         ps.setString(2,code);
         ps.execute();
         return true;
       } catch (SQLException e) {
           System.out.println(e.toString());
           return false;
       }
   }
   
   public ArrayList<Sale> ListSales(){
    ArrayList<Sale> ListSales= new ArrayList();  
    String sql = "SELECT * FROM sales";
    try{
      con = cn.getConnection();
      ps = con.prepareStatement(sql);
      ps.executeQuery();
      rs = ps.executeQuery();
      while(rs.next()){
         Sale sa = new Sale();
         sa.setId(rs.getInt("id"));
         sa.setCustomer(rs.getString("customer"));
         sa.setSeller(rs.getString("seller"));
         sa.setTotal(rs.getDouble("total"));
        
         ListSales.add(sa);
      }
    }catch(SQLException e){
        System.out.println(e.toString());  
    }
    return ListSales;
  }
}
