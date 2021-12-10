
package QLKS.Dao;

import QLKS.Helper.DatabaseHelper;
import QLKS.Models.TaiKhoan;
import java.sql.*;
import com.sun.jdi.connect.spi.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class TaiKhoanDao {
    DatabaseHelper db = new DatabaseHelper();
    java.sql.Connection con = db.getConnection();
    PreparedStatement ps;
    ResultSet rs;
    public ArrayList<TaiKhoan> lstTK= new ArrayList<>();
    public ArrayList<TaiKhoan> showTaiKhoan(){
        try {
            String sql="select * from TaiKhoan";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                TaiKhoan tk = new TaiKhoan(rs.getString(1), rs.getString(2), rs.getInt(3),rs.getString(4));
                lstTK.add(tk);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstTK;
    }
    public void insertTaiKhoan(String tenDN, String matKhau, String quyen, String maNV) {
        try {
            String sql = "Insert into TaiKhoan values(?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, tenDN);
            ps.setString(2, matKhau);
            ps.setString(3, quyen);
            ps.setString(4, maNV);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateTaiKhoan(String tenDN, String matKhau, String quyen, String maNV) {
        try {
            String sql = "Update TaiKhoan set MatKhau=?,IsAdmin=?,MaNV=? where TenDangNhap=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, matKhau);
            ps.setString(2, quyen);
            ps.setString(3, maNV);
            ps.setString(4, tenDN);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deteleTaiKhoan(String tenDN) {
        try {
            String sql = "Delete from TaiKhoan where TenDangNhap=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, tenDN);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<TaiKhoan> findTaiKhoan(String maNV) {
        ArrayList<TaiKhoan> lstTim = new ArrayList<>();
        try {
            String sql = "Select * from TaiKhoan where MaNV=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, maNV);
            rs = ps.executeQuery();
            while (rs.next()) {
                TaiKhoan tk = new TaiKhoan(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4));
                lstTim.add(tk);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstTim;
    }
}
