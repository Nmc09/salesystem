
package Model;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProviderDAO {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
 public boolean RegisterProvider(Provider pr){
     String sql = "INSERT INTO provider(cl,name,adress,phone,email ) VALUES (?,?,?,?,?)";
     try{
         con = cn.getConnection();
         ps = con.prepareStatement(sql);
         ps.setInt(1,pr.getCl());
         ps.setString(2, pr.getName());
         ps.setString(3,pr.getAdress());
         ps.setInt(4, pr.getPhone());
         ps.setString(5, pr.getEmail());
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
 public ArrayList<Provider> ListProvider(){
     ArrayList<Provider> ListPr = new ArrayList();
     String sql = "SELECT * FROM provider";
     try{
         con = cn.getConnection();
         ps = con.prepareStatement(sql);
         rs = ps.executeQuery();
         while(rs.next()){
           Provider pr = new Provider();
           pr.setId(rs.getInt("id"));
           pr.setCl(rs.getInt("cl"));
           pr.setName(rs.getString("name"));
           pr.setAdress(rs.getString("adress"));
           pr.setPhone(rs.getInt("phone"));
           pr.setEmail(rs.getString("email"));
           ListPr.add(pr);
         }
         
     }catch(SQLException e){
         System.out.println(e.toString());
     }
     return ListPr;
 }
 public boolean DeleteProvider(int id){
     String sql = "DELETE FROM provider WHERE id = ?";
     try{
      con = cn.getConnection();
      ps = con.prepareStatement(sql);
      ps.setInt(1,id);
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
 public boolean ModifyProvider(Provider pr){
     String sql = "UPDATE provider SET cl=?,name=?,adress=?,phone=?,email=? WHERE id = ?";
     try{
         con = cn.getConnection();
         ps = con.prepareStatement(sql);
         ps.setInt(1,pr.getCl());
         ps.setString(2,pr.getName());
         ps.setString(3,pr.getAdress());
         ps.setInt(4,pr.getPhone());
         ps.setString(5, pr.getEmail());
         ps.setInt(6, pr.getId());
         ps.execute();
         return true;
     }catch(SQLException e){
         System.out.println(e.toString());
         return false;
     }finally{
         try{
         con.close();        
         }
         catch(SQLException e){
             System.out.println(e.toString());   
         }
     }
    }
}
