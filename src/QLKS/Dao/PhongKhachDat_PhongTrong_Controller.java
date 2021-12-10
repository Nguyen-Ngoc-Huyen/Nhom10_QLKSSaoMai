package QLKS.Dao;
import QLKS.Models.KhachHang;
import QLKS.Models.NhanVien;
import QLKS.Models.Phong;
import QLKS.Models.PhongKhachDat;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PhongKhachDat_PhongTrong_Controller {
    
    
    Connection con = null;
    Statement st = null;
    String uRl = "jdbc:sqlserver://localhost:1433;databaseName=QLKhachSan;user=sa;password=123456";

    public PhongKhachDat_PhongTrong_Controller() {
        try {
            //org.apache.derby.jdbc.ClientDriver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            con = DriverManager.getConnection(uRl);
            System.out.println("Ket noi thanh cong: PhongKhachDat_PhongTrong_Controller ");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ket noi that bai: PhongKhachDat_PhongTrong_Controller " + ex.toString());
        }
    }

    public ArrayList<Phong> getAllPhongTrong() throws SQLException{ 
        
        ArrayList<Phong> phongTrongList = new ArrayList<>();
        String test1 = "Còn trống";
        try {
//            String query1 = "SELECT MaPhong, LoaiPhong, GiaPhong, TinhTrang FROM Phong ";

            String query1 = "SELECT * FROM Phong WHERE TinhTrang = N'" + test1 + "'";
            st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            Phong hd;
            while (rs.next()) {
                hd = new Phong(rs.getString("MaPhong"), rs.getString("LoaiPhong"),
                        rs.getDouble("GiaPhong"),rs.getString("TinhTrang"));
                
                phongTrongList.add(hd);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi lấy dữ liệu: getAllPhongTrong " + ex.toString());
            return null;
        }
        return phongTrongList;
    }
    
    public ArrayList<Phong> getAllPhong() throws SQLException{ 
        
        ArrayList<Phong> phongTrongList = new ArrayList<>();
        try {
//            String query1 = "SELECT MaPhong, LoaiPhong, GiaPhong, TinhTrang FROM Phong ";

            String query1 = "SELECT * FROM Phong";
            st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            Phong hd;
            while (rs.next()) {
                hd = new Phong(rs.getString("MaPhong"), rs.getString("LoaiPhong"),
                        rs.getDouble("GiaPhong"),rs.getString("TinhTrang"));
                
                phongTrongList.add(hd);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi lấy dữ liệu: getAllPhong" + ex.toString());
            return null;
        }
        return phongTrongList;
    }
    
//    public boolean checkPhongTrong(Phong nvd) throws Exception{
//            
//            ArrayList<Phong> phongTrongList = new ArrayList<>();
//            String test1 = "Trống";    
//            try {
//                String query1 = "SELECT * FROM Phong WHERE TinhTrang = N'" + test1 + "'";
//                PreparedStatement pst1 = con.prepareStatement(query1);               
//              
//            return true;
//            } catch (Exception ex) {
//                JOptionPane.showMessageDialog(null, "Lỗi nhập dữ liệu: checkPhongTrong" + ex.toString());
//            }
//              return false;
//        }
    
//    public double layGiaPhongTuongUng(Phong nvd){
//        ArrayList<Phong> phongTrongList = new ArrayList<>();
//        
//        
//    }
    
    
    
}
