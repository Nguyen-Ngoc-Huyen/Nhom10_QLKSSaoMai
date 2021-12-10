/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.Helper;
import java.sql.Connection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author admin
 */
public class DatabaseHelper {
    ResultSet rs = null;
    java.sql.Connection conn =null;
    public java.sql.Connection getConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost;databaseName=QLKhachSan;user=sa;password=123456";
             conn=DriverManager.getConnection(url);
            
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(null, "Không thể kết nối được với cơ sở dữ liệu");
        }
        return conn;
    }
    public void closeConnection(){
        
        try {
            if(rs!=null)
                rs.close();
            if(conn!=null)
                conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public ResultSet getResultSet(String sql){
            ResultSet kp = null;
            try{
                conn= getConnection();
                Statement st = conn.createStatement();
                kp = st.executeQuery(sql);
            }
            catch(Exception ex){
                System.err.println("Lỗi tại getresultset: "+ex.getMessage());
            }
            return kp;
        }
}
