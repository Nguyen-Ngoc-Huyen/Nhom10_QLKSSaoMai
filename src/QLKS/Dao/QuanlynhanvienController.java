/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.Dao;

import QLKS.Models.NhanVien;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;


public class QuanlynhanvienController {
    Connection con=null;
    Statement st=null;
        String uRl = "jdbc:sqlserver://localhost:1433;databaseName=QLKhachSan;user=sa;password=123456";
        public QuanlynhanvienController(){
            try {
            //org.apache.derby.jdbc.ClientDriver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            con = DriverManager.getConnection(uRl);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ket noi that bai" + ex.toString());
        }
        }
        public ArrayList<NhanVien> getAllNhanVien() throws SQLException{
            ArrayList<NhanVien> nhanvienList= new ArrayList<>();
            try {
                String query1 = "SELECT * FROM NhanVien";
                st = con.createStatement();
                ResultSet rs = st.executeQuery(query1);
                NhanVien nvd;
                while(rs.next()){
                    nvd = new NhanVien(rs.getString("MaNV"), rs.getString("HoTenNV"), rs.getString("SoCMND"), rs.getString("NgaySinh"), rs.getString("GioiTinh"), rs.getString("Email"), rs.getString("SoDienThoai"), rs.getString("DiaChi"), rs.getString("ChucVu"));
                    nhanvienList.add(nvd);
                } 
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Lỗi lấy dữ liệu " + ex.toString());
            return null;
            }
            return nhanvienList;
        }
        public boolean themNhanVienDao(NhanVien nvd)throws SQLException{
            try {
                String query = "SELECT * FROM NhanVien"
                    + " WHERE MaNV = '" + nvd.getMaNV()+ "'";
                st=con.createStatement();
                ResultSet rs = st.executeQuery(query);
                StringBuilder sb = new StringBuilder();
            if (rs.next()) {
                sb.append("Không được nhập trùng mã nhân viên!\n");
            }
            
            if (sb.length() > 0) {
                JOptionPane.showMessageDialog(null, sb);
            } else{
                String query1 = "INSERT INTO NhanVien(MaNV, HoTenNV,SoCMND, NgaySinh, GioiTinh, Email, SoDienThoai, DiaChi, ChucVu) VALUES (?,?,?,?,?,?,?,?,?)";
                PreparedStatement pst1 = con.prepareStatement(query1);
                pst1.setString(1, nvd.getMaNV());
                 pst1.setString(2, nvd.getHoTenNV());
                  pst1.setString(3, nvd.getSoCMND());
                   pst1.setString(4, nvd.getNgaySinh());
                    pst1.setString(5, nvd.getGioiTinh());
                     pst1.setString(6, nvd.getEmail());
                      pst1.setString(7, nvd.getSoDienThoai());
                       pst1.setString(8, nvd.getDiaChi());
                        pst1.setString(9, nvd.getChucVu());
//                         pst1.setString(10, nvd.getGhiChu());
                pst1.executeUpdate();
                return true;
            }
            } catch (Exception ex) {
                System.out.println("Lỗi nhập dữ liệu :" + ex.toString());
            }
            return false;
        }
        public void XoaNhanVien(String MaNV){
            try {
                String query1 = "DELETE FROM  TaiKhoan  WHERE MaNV = '" + MaNV + "'";
                 PreparedStatement pst1 = con.prepareStatement(query1);
                
                String query2 = "DELETE FROM NhanVien  WHERE MaNV = '" + MaNV + "'";
                 PreparedStatement pst2 = con.prepareStatement(query2);
                 pst1.executeUpdate();
                 pst2.executeUpdate();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Lỗi " + ex);
            }
        }
        public  boolean SuaNhanVien(NhanVien nvd) throws Exception{
            try {
                String query1 = "UPDATE NhanVien SET HoTenNV= ?,"
                    + "SoCMND=?,NgaySinh=?,GioiTinh=?,Email=?,SoDienThoai=?,DiaChi=?,ChucVu=? WHERE MaNV= ?";
                PreparedStatement pst1 = con.prepareStatement(query1);
                 
            pst1.setString(1, nvd.getHoTenNV());
            pst1.setString(2, nvd.getSoCMND());
            pst1.setString(3,  nvd.getNgaySinh());
            pst1.setString(4, nvd.getGioiTinh());
            pst1.setString(5, nvd.getEmail());
            pst1.setString(6, nvd.getSoDienThoai());
            pst1.setString(7, nvd.getDiaChi());
            pst1.setString(8, nvd.getChucVu());
//            pst1.setString(9, nvd.getGhiChu());
              pst1.setString(9, nvd.getMaNV());
            pst1.executeUpdate();
            return true;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Lỗi nhập dữ liệu :" + ex.toString());
            }
              return false;
        }
}
