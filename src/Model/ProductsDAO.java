

package Model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;


public class ProductsDAO {
  Connection con;
  Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    
    public boolean RegisterProducts(Products pro){
        String sql = "INSERT INTO products (code,name,provider,stock,cost) VALUES (?,?,?,?,?)";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1,pro.getCode());
            ps.setString(2,pro.getName());
            ps.setString(3,pro.getProviderPr());
            ps.setInt(4,pro.getStock());
            ps.setDouble(5,pro.getCost());
            ps.execute();
            return true;
            
           
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString()); 
            return false;
        }
        finally{
          try{
           con.close();
          }catch(SQLException e){
              System.out.println(e.toString());
          }
        }
      }
     public void ConsultProvider(JComboBox provider){
         String sql = "SELECT name FROM provider";
         try{
             con = cn.getConnection();
             ps = con.prepareStatement(sql);
             rs =ps.executeQuery();
             while(rs.next()){
             provider.addItem(rs.getString("name")); 
             }  
             }catch(SQLException e){
                  System.out.println(e.toString());   
                     }
         }
     public ArrayList<Products> listProducts(){
    ArrayList<Products> ListPro= new ArrayList();  
    String sql = "SELECT * FROM products";
    try{
      con = cn.getConnection();
      ps = con.prepareStatement(sql);
      ps.executeQuery();
      rs = ps.executeQuery();
      while(rs.next()){
          Products pro = new Products();
          pro.setId(rs.getInt("id"));
          pro.setCode(rs.getString("code"));
          pro.setName(rs.getString("name"));
          pro.setProviderPr(rs.getString("provider"));
          pro.setStock(rs.getInt("stock"));
          pro.setCost(rs.getDouble("cost"));
          ListPro.add(pro);
      }
    }catch(SQLException e){
        System.out.println(e.toString());  
    }
    return ListPro;
  }
     public boolean DelteProducts(int id){
      String sql = "DELETE FROM products WHERE id = ? ";
      try{
          ps = con.prepareStatement(sql);
          ps.setInt(1, id);
          ps.execute();
          return true;
      }
      catch(SQLException e){
          System.out.println(e.toString());
          return false;
      }finally{
          try{
              con.close();
          }catch(SQLException ex){
              System.out.println(ex.toString()); 
          }
      }
  }
     public boolean ModifyProducts(Products pro){
      String sql = "UPDATE products SET code=?, name=?, provider=?,stock=?,cost=? WHERE id=?";
      try{
          ps=con.prepareStatement(sql);
          ps.setString(1,pro.getCode());
          ps.setString(2,pro.getName());
          ps.setString(3,pro.getProviderPr());
          ps.setInt(4,pro.getStock());
          ps.setDouble(5,pro.getCost());
          ps.setInt(6,pro.getId());
          
          ps.execute();
          return true;
      }catch(SQLException e){
          System.out.println(e.toString());
          return false;
          
      }finally{
          try{
              con.close();
          }catch(SQLException e){
            System.out.println(e.toString());
          }
      }
  }
     public Products SearchProduct(String code){
         Products product = new Products();
         String sql = "SELECT * FROM products WHERE code = ?";
         try {
          con = cn.getConnection();
          ps = con.prepareStatement(sql);
          ps.setString(1,code);
          rs = ps.executeQuery();
          if(rs.next()){
              product.setName(rs.getString("name"));
              product.setCost(rs.getDouble("cost"));
              product.setStock(rs.getInt("stock"));
          }
         } catch (SQLException e) {
             System.out.println(e.toString());
         }
      return product;
     }
     
     public Settings SearchData(){
         Settings Setting = new Settings();
         String sql = "SELECT * FROM settings";
         try {
          con = cn.getConnection();
          ps = con.prepareStatement(sql);
          rs = ps.executeQuery();
          if(rs.next()){
              Setting.setId(rs.getInt("Id"));
              Setting.setCl(rs.getInt("cl"));
              Setting.setName(rs.getString("name"));
              Setting.setAdress(rs.getString("adress"));
              Setting.setPhone(rs.getInt("phone"));
              Setting.setEmail(rs.getString("email"));
          }
         } catch (SQLException e) {
             System.out.println(e.toString());
         }
      return Setting;
     }
      public boolean ModifyData(Settings setting){
      String sql = "UPDATE settings SET cl=?, name=?, adress=?,phone=?,email=? WHERE id=?";
      try{
          ps=con.prepareStatement(sql);
          ps.setInt(1,setting.getCl());
          ps.setString(2,setting.getName());
          ps.setString(3,setting.getAdress());
          ps.setInt(4,setting.getPhone());
          ps.setString(5,setting.getEmail());
          ps.setInt(6,setting.getId());
          
          ps.execute();
          return true;
      }catch(SQLException e){
          System.out.println(e.toString());
          return false;
          
      }finally{
          try{
              con.close();
          }catch(SQLException e){
            System.out.println(e.toString());
          }
      }
  }
}



