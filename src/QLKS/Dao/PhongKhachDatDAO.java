/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.Dao;

import QLKS.Helper.DatabaseHelper;
import QLKS.Helper.DatabaseHelper_1;
import QLKS.Models.PhongKhachDat;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PhongKhachDatDAO {
    
    public List<PhongKhachDat> fillAllDangSuDung() throws Exception{
        String sql = "SELECT * FROM Phong_Khach_Dat WHERE TinhTrang=?";
        try(
                Connection con = DatabaseHelper_1.OpenConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setString(1,"Chờ thanh toán");
            try(ResultSet rs = pstmt.executeQuery()){
                List<PhongKhachDat> list = new ArrayList<>();
                while(rs.next()){
                    PhongKhachDat pkd = new PhongKhachDat();
                    pkd.setMaDatPhong(rs.getString("MaDatPhong"));
                    pkd.setMaPhong(rs.getString("MaPhong"));
                    pkd.setSoCMNDKH(rs.getString("SoCMNDKH"));
                    pkd.setSoNguoiO(rs.getString("SoNguoiO"));
                    pkd.setNgayDen(rs.getString("NgayDen"));
                    pkd.setNgayDi(rs.getString("NgayDi"));
                    pkd.setTienCoc(Float.parseFloat(rs.getString("TienCoc")));
                    pkd.setTinhTrang(rs.getString("TinhTrang"));
                    pkd.setGhiChu(rs.getString("GhiChu"));
                    list.add(pkd);
                }
                return list;
            }
        }
    }
    public List<PhongKhachDat> fillAllDaTraPhong() throws Exception{
        String sql = "SELECT * FROM Phong_Khach_Dat WHERE TinhTrang=?";
        try(
                Connection con = DatabaseHelper_1.OpenConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setString(1,"Đã thanh toán");
            try(ResultSet rs = pstmt.executeQuery()){
                List<PhongKhachDat> list = new ArrayList<>();
                while(rs.next()){
                    PhongKhachDat pkd = new PhongKhachDat();
                    pkd.setMaDatPhong(rs.getString("MaDatPhong"));
                    pkd.setMaPhong(rs.getString("MaPhong"));
                    pkd.setSoCMNDKH(rs.getString("SoCMNDKH"));
                   pkd.setSoNguoiO(rs.getString("SoNguoiO"));
                    pkd.setNgayDen(rs.getString("NgayDen"));
                    pkd.setNgayDi(rs.getString("NgayDi"));
                    pkd.setTienCoc(Float.parseFloat(rs.getString("TienCoc")));
                    pkd.setTinhTrang(rs.getString("TinhTrang"));
                    pkd.setGhiChu(rs.getString("GhiChu"));
                    list.add(pkd);
                }
                return list;
            }
        }
    }
    public List<PhongKhachDat> fillByDaTraPhong(String soCMNDKH) throws Exception{
        String sql = "SELECT * FROM Phong_Khach_Dat WHERE TinhTrang=? AND SoCMNDKH=?";
        try(
                Connection con = DatabaseHelper_1.OpenConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setString(1,"Đã thanh toán");
            pstmt.setString(2,soCMNDKH);
            try(ResultSet rs = pstmt.executeQuery()){
                List<PhongKhachDat> list = new ArrayList<>();
                while(rs.next()){
                    PhongKhachDat pkd = new PhongKhachDat();
                    pkd.setMaDatPhong(rs.getString("MaDatPhong"));
                    pkd.setMaPhong(rs.getString("MaPhong"));
                    pkd.setSoCMNDKH(rs.getString("SoCMNDKH"));
                    pkd.setSoNguoiO(rs.getString("SoNguoiO"));
                    pkd.setNgayDen(rs.getString("NgayDen"));
                    pkd.setNgayDi(rs.getString("NgayDi"));
                    pkd.setTienCoc(Float.parseFloat(rs.getString("TienCoc")));
                    pkd.setTinhTrang(rs.getString("TinhTrang"));
                    pkd.setGhiChu(rs.getString("GhiChu"));
                    list.add(pkd);
                }
                return list;
            }
        }
    }
    public PhongKhachDat fillByMaDatPhong(String maDatPhong) throws Exception{
        String sql = "SELECT * FROM Phong_Khach_Dat WHERE MaDatPhong=?";
        try(
                Connection con = DatabaseHelper_1.OpenConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setString(1,maDatPhong);
            try(ResultSet rs = pstmt.executeQuery()){
                if(rs.next()){
                    PhongKhachDat pkd = new PhongKhachDat();
                    pkd.setMaDatPhong(rs.getString("MaDatPhong"));
                    pkd.setMaPhong(rs.getString("MaPhong"));
                    pkd.setSoCMNDKH(rs.getString("SoCMNDKH"));
                    pkd.setSoNguoiO(rs.getString("SoNguoiO"));
                    pkd.setNgayDen(rs.getString("NgayDen"));
                    pkd.setNgayDi(rs.getString("NgayDi"));
                    pkd.setTienCoc(Float.parseFloat(rs.getString("TienCoc")));
                    pkd.setTinhTrang(rs.getString("TinhTrang"));
                    pkd.setGhiChu(rs.getString("GhiChu"));
                    return pkd;
                }
            }
            return null;
        }
    }
    
    //update trang thai phong khach dat - Huyen
        DatabaseHelper db = new DatabaseHelper();
        java.sql.Connection con = db.getConnection();
        PreparedStatement ps;
        ResultSet rs;
    public void upDatePhongKD(String maDatPhong){
            try {
                String sql ="UpDate Phong_Khach_Dat set TinhTrang=N'Đã thanh toán' \n" +
                    "From Phong_Khach_Dat\n" +
                    "where MaDatPhong=?";
                ps=con.prepareStatement(sql);
                ps.setString(1, maDatPhong);
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(QLPhongDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    public void upDateNgayDiHT(String maDatPhong,String ngayDi){
            try {
                String sql ="UpDate Phong_Khach_Dat set NgayDi=?\n" +
                    "From Phong_Khach_Dat\n" +
                    "where MaDatPhong=?";
                ps=con.prepareStatement(sql);
                ps.setString(1, ngayDi);
                ps.setString(2, maDatPhong);
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(QLPhongDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    public void upDateNgayDiDT(String maDatPhong){
            try {
                String sql ="UpDate Phong_Khach_Dat set TinhTrang=N'Đã thanh toán' \n" +
                    "From Phong_Khach_Dat\n" +
                    "where MaDatPhong=?";
                ps=con.prepareStatement(sql);
                ps.setString(1, maDatPhong);
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(QLPhongDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
   //tìm hóa đơn theo số CMND
    public ArrayList<PhongKhachDat> findHoaDonKH(String soCMND){
       String sql ="Select * from Phong_Khach_Dat where TinhTrang=N'Chờ thanh toán' and SoCMNDKH=?";
        try(
                Connection con = DatabaseHelper_1.OpenConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setString(1,soCMND);
            try(ResultSet rs = pstmt.executeQuery()){
                ArrayList<PhongKhachDat> list = new ArrayList<>();
                while(rs.next()){
                    PhongKhachDat pkd = new PhongKhachDat();
                    pkd.setMaDatPhong(rs.getString("MaDatPhong"));
                    pkd.setMaPhong(rs.getString("MaPhong"));
                    pkd.setSoCMNDKH(rs.getString("SoCMNDKH"));
                    pkd.setSoNguoiO(rs.getString("SoNguoiO"));
                    pkd.setNgayDen(rs.getString("NgayDen"));
                    pkd.setNgayDi(rs.getString("NgayDi"));
                    pkd.setTienCoc(Float.parseFloat(rs.getString("TienCoc")));
                    pkd.setTinhTrang(rs.getString("TinhTrang"));
                    pkd.setGhiChu(rs.getString("GhiChu"));
                    list.add(pkd);
                }
                return list;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhongKhachDatDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PhongKhachDatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
