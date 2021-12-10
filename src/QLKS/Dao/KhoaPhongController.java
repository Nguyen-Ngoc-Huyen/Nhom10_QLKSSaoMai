/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.Dao;

import QLKS.Models.Phong;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
/**
 *
 * @author MinhQuan
 */
public class KhoaPhongController {
     
    Connection con = null;
    Statement st = null;
    String uRl = "jdbc:sqlserver://localhost:1433;databaseName=QLKhachSan;user=sa;password=123456";
     public KhoaPhongController() {
        try {
            //org.apache.derby.jdbc.ClientDriver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            con = DriverManager.getConnection(uRl);
            System.out.println("Ket noi thanh cong");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ket noi that bai" + ex.toString());
        }
    }
     public ArrayList<Phong> getAllPhong() throws SQLException {
        ArrayList<Phong> KhoaPhongList = new ArrayList<>();
       
        try {
            String query1 = "SELECT * FROM Phong";

            st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            Phong p;
            while (rs.next()) {
//                ChiSo cs = new ChiSo(rs.getInt("Chisothangtruoc"), rs.getInt("Chisothangnay"), rs.getString("Ngayghi"));
//                KhachHang kh = new KhachHang(rs.getString("maKhachHang"), rs.getString("HoTen"), rs.getString("DiaChi"));
                p = new Phong(rs.getString("maPhong"),rs.getString("loaiPhong"), rs.getFloat("giaPhong"), rs.getString("tinhTrang"));
                
                KhoaPhongList.add(p);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi lấy dữ liệu " + ex.toString());
            return null;
        }
        return KhoaPhongList;
    }
      public boolean updateKhoaPhong(Phong kp) throws SQLException {
        try {
            String query1 = "UPDATE Phong SET MaPhong= ?,LoaiPhong= ?,"
                    + "GiaPhong=?,TinhTrang=? WHERE MaPhong= ?";
//            String query2 = "UPDATE CHISO SET Chisothangnay= ?,Chisothangtruoc= ? WHERE maKhachHang= ? AND Ngayghi=  ? ";
            PreparedStatement pst1 = con.prepareStatement(query1);
//            PreparedStatement pst2 = con.prepareStatement(query2);
            pst1.setString(1, kp.getMaPhong());
             pst1.setString(2, kp.getLoaiPhong());
              pst1.setDouble(3, kp.getGiaPhong());
               pst1.setString(4, kp.getTinhTrang());
                pst1.setString(5, kp.getMaPhong());
            
           
            
//            pst2.setInt(1, cs.getChiSoThangNay());
//            pst2.setInt(2, cs.getChiSoThangTruoc());
//            pst2.setString(3, kh.getMakh());
//            pst2.setString(4, cs.getNgayghi());
            pst1.executeUpdate();
//            pst2.executeUpdate();
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi nhập dữ liệu :" + ex.toString());
        }
        return false;
      }
}
