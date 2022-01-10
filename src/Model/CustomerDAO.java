
package Model;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class CustomerDAO {
  Conexion cn = new Conexion();
  Connection con;  
  PreparedStatement ps;
  ResultSet rs;
  public boolean RegisterCustomer(Customer cu){
      String sql = "INSERT INTO customers(cl,name,adress,phone,email) VALUES (?,?,?,?,?)";
      try{
          con = cn.getConnection();
          ps = con.prepareStatement(sql);
          ps.setInt(1,cu.getCl());
          ps.setString(2,cu.getName());
          ps.setString(3,cu.getAdress());
          ps.setInt(4,cu.getPhone());
          ps.setString(5, cu.getEmail());
          ps.execute();
          return true;
      }
      catch(SQLException e){
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
  
  public ArrayList<Customer> listCustomer(){
    ArrayList<Customer> ListCu= new ArrayList();  
    String sql = "SELECT * FROM customers";
    try{
      con = cn.getConnection();
      ps = con.prepareStatement(sql);
      ps.executeQuery();
      rs = ps.executeQuery();
      while(rs.next()){
          Customer cu = new Customer();
          cu.setId(rs.getInt("id"));
          cu.setCl(rs.getInt("cl"));
          cu.setName(rs.getString("name"));
          cu.setAdress(rs.getString("adress"));
          cu.setPhone(rs.getInt("phone"));
          cu.setEmail(rs.getString("email"));
          ListCu.add(cu);
      }
    }catch(SQLException e){
        System.out.println(e.toString());  
    }
    return ListCu;
  }
  public boolean DelteCustomer(int id){
      String sql = "DELETE FROM customers WHERE id = ? ";
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
  public boolean ModifyCustomer(Customer cu){
      String sql = "UPDATE customers SET cl=?, name=?, adress=?, phone=?,email=? WHERE id=?";
      try{
          ps=con.prepareStatement(sql);
          ps.setInt(1,cu.getCl());
          ps.setString(2,cu.getName());
          ps.setString(3,cu.getAdress());
          ps.setInt(4,cu.getPhone());
          ps.setString(5,cu.getEmail());
          ps.setInt(6,cu.getId());
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
      public Customer SearchCustomer(int cl){
        Customer cu = new Customer();
        String sql = "SELECT * FROM customers WHERE cl = ?";
          try {
              con = cn.getConnection();
              ps = con.prepareStatement(sql);
              ps.setInt(1,cl);
              rs = ps.executeQuery();
              if(rs.next()){
                  cu.setName(rs.getString("name"));
                  cu.setAdress(rs.getString("adress"));
                  cu.setPhone(rs.getInt("phone"));
                  cu.setEmail(rs.getString("email"));
              }
          } catch (SQLException e) {
              System.out.println(e.toString());
          }
          return cu;
 
      }

}

