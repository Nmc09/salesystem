

package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class loginDAO {
  Connection con;
  PreparedStatement ps;
  ResultSet rs;
  Conexion cn = new Conexion() ; 
  
  public login log(String email, String pass){
      login l = new login();
      String sql = "SELECT * FROM users WHERE email = ? AND pass = ?";
      try{
       con = cn.getConnection(); 
       ps = con.prepareStatement(sql);
       ps.setString(1,email);
       ps.setString(2,pass);
       rs=ps.executeQuery();
       if(rs.next()){
         l.setId(rs.getInt("id"));
         l.setName(rs.getString("name"));
         l.setEmail(rs.getString("email"));
         l.setPass(rs.getString("pass"));
         l.setRole(rs.getString("role"));
       }
      }catch(SQLException e){
          System.out.println(e.toString());
      }   
      return l;
      }
  public boolean Register(login reg){
      String sql = "INSERT INTO users (name, email, pass, role) VALUES(?,?,?,?)";
      try{
          con= cn.getConnection();
          ps = con.prepareStatement(sql);
          ps.setString(1,reg.getName());
          ps.setString(2, reg.getEmail());
          ps.setString(3,reg.getPass());
          ps.setString(4,reg.getRole());
          ps.execute();
          return true;
      } catch (SQLException ex) {
          Logger.getLogger(loginDAO.class.getName()).log(Level.SEVERE, null, ex);
          return false;
      }
  }
}
