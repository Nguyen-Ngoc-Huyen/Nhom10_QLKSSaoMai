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

public class PhongKhachDat_KhachHang_Controller {
    
    
    Connection con = null;
    Statement st = null;
    String uRl = "jdbc:sqlserver://localhost:1433;databaseName=QLKhachSan;user=sa;password=123456";

    public PhongKhachDat_KhachHang_Controller() {
        try {
            //org.apache.derby.jdbc.ClientDriver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            con = DriverManager.getConnection(uRl);
            System.out.println("Ket noi thanh cong: PhongKhachDat_KhachHang_Controller ");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ket noi that bai: PhongKhachDat_KhachHang_Controller" + ex.toString());
        }
    }

    public ArrayList<KhachHang> getAllKH_PKD() throws SQLException{ 
        
        ArrayList<KhachHang> khList = new ArrayList<>();
        try {
            String query1 = "SELECT SoCMNDKH, HoTenKH, GioiTinh, SoDT, GhiChu FROM KhachHang";
            st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            KhachHang hd;
            while (rs.next()) {
                hd = new KhachHang(rs.getString("SoCMNDKH"),rs.getString("HoTenKH"),rs.getString("GioiTinh"),
                        rs.getString("SoDT"),rs.getString("GhiChu"));            
                khList.add(hd);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi lấy dữ liệu từ bảng KhachHang" + ex.toString());
            return null;
        }
        return khList;
    }
    
}
