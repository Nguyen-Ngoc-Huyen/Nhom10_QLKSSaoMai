/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.Dao;

import QLKS.Helper.DatabaseHelper;
import QLKS.Models.Phong;
import com.sun.jdi.connect.spi.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class QLPhongDao {
        DatabaseHelper db = new DatabaseHelper();
        java.sql.Connection con = db.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Phong> lstPhong = new ArrayList<>();
        public ArrayList<Phong> selectAllPhong(){
            try {
                String sql="select * from Phong";
                ps=con.prepareStatement(sql);
                rs=ps.executeQuery();
                while(rs.next()){
                    Phong p = new Phong(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5));
                    lstPhong.add(p);
                }
            } catch (SQLException ex) {
                Logger.getLogger(QLPhongDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return lstPhong;
        }
        
        //them moi
        public void insertPhong(String maP, String loaiP, Double giaP,String tinhTrang, String ghiChu){
            try {
                String sql = "Insert into Phong values(?,?,?,?,?)";
                ps=con.prepareStatement(sql);
                ps.setString(1, maP);
                ps.setString(2, loaiP);
                ps.setDouble(3, giaP);
                ps.setString(4, tinhTrang);
                ps.setString(5, ghiChu);
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(QLPhongDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        public void updatePhong(String maP, String loaiP, Double giaP,String tinhTrang, String ghiChu){
            try {
                String sql="Update Phong set LoaiPhong=?,GiaPhong=?,TinhTrang=?,GhiChu=? where MaPhong=?";
                ps=con.prepareStatement(sql);
                ps.setString(5, maP);
                ps.setString(1, loaiP);
                ps.setDouble(2, giaP);
                ps.setString(3, tinhTrang);
                ps.setString(4, ghiChu);
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(QLPhongDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        public void detelePhong(String maP){
            try {
                String sql="Delete from Phong where MaPhong=?";
                ps=con.prepareStatement(sql);
                ps.setString(1, maP);
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(QLPhongDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        public ArrayList<Phong> findPhong(String maP){
            ArrayList<Phong> lstTim = new ArrayList<>();
            try {
                String sql = "Select * from Phong where MaPhong=?";
                ps=con.prepareStatement(sql);
                ps.setString(1, maP);
                rs=ps.executeQuery();
                while(rs.next()){
                    Phong p = new Phong(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5));
                    lstTim.add(p); 
                }
            } catch (SQLException ex) {
                Logger.getLogger(QLPhongDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return lstTim;
        }
        //Update trạng thái
        public void upDatePhongKD(String maDatPhong){
            try {
                String sql ="UpDate Phong set TinhTrang=N'Còn trống' \n" +
                        "From Phong inner join Phong_Khach_Dat on Phong.MaPhong=Phong_Khach_Dat.MaPhong\n" +
                        "where Phong_Khach_Dat.MaDatPhong=?";
                ps=con.prepareStatement(sql);
                ps.setString(1, maDatPhong);
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(QLPhongDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         public void upDatePhongDangSD(String maDatPhong){
            try {
                String sql ="UpDate Phong set TinhTrang=N'Đang sử dụng' \n" +
                        "From Phong inner join Phong_Khach_Dat on Phong.MaPhong=Phong_Khach_Dat.MaPhong\n" +
                        "where Phong_Khach_Dat.MaDatPhong=?";
                ps=con.prepareStatement(sql);
                ps.setString(1, maDatPhong);
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(QLPhongDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }       
}
