package QLKS.Dao;
import QLKS.Helper.DatabaseHelper;
import QLKS.Helper.DatabaseHelper;
import QLKS.Helper.DatabaseHelper_1;
import QLKS.Helper.ShareDataPhongKhachDat;
import QLKS.Models.KhachHang;
import QLKS.Models.Phong;
import QLKS.Models.PhongKhachDat;
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
import javax.swing.JOptionPane;

public class PhongKhachDat_Controller {
    
    Connection con = null;
    Statement st = null;
    String uRl = "jdbc:sqlserver://localhost:1433;databaseName=QLKhachSan;user=sa;password=123456";

    public PhongKhachDat_Controller() {
        try {
            //org.apache.derby.jdbc.ClientDriver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            con = DriverManager.getConnection(uRl);
            System.out.println("Ket noi thanh cong: PhongKhachDat_Controller ");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ket noi that bai: PhongKhachDat_Controller" + ex.toString());
        }
    }
     
    public ArrayList<PhongKhachDat> getAllPhongKhachDat() throws SQLException {
        
        ArrayList<PhongKhachDat> phongDatList = new ArrayList<>();
        try {
            String query1 = "SELECT MaDatPhong, Phong_Khach_Dat.MaPhong, "
                    + "SoCMNDKH, SoNguoiO, NgayDen, NgayDi, TienCoc, Phong_Khach_Dat.TinhTrang, "
                    + "Phong_Khach_Dat.GhiChu, GiaPhong From Phong_Khach_Dat INNER JOIN Phong ON Phong_Khach_Dat.MaPhong=Phong.MaPhong";
           
            

            st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            PhongKhachDat hd;
            while (rs.next()) {
//                ChiSo cs = new ChiSo(rs.getInt("Chisothangtruoc"), rs.getInt("Chisothangnay"), rs.getString("Ngayghi"));
//                KhachHang kh = new KhachHang(rs.getString("maKhachHang"), rs.getString("HoTen"), rs.getString("DiaChi"));
                hd = new PhongKhachDat(rs.getString("MaDatPhong"), rs.getString("MaPhong"),
                        rs.getString("SoCMNDKH"),rs.getString("SoNguoiO"), rs.getString("NgayDen"),
                        rs.getString("NgayDi"), rs.getFloat("TienCoc"),rs.getString("TinhTrang"),rs.getString("GhiChu"),rs.getFloat("GiaPhong"));
                
                phongDatList.add(hd);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi lấy dữ liệu " + ex.toString());
            return null;
        }
        return phongDatList;
    }

    public boolean addPhongKhachDat(PhongKhachDat hd) throws SQLException {
        try {
            String query = "SELECT * FROM Phong_Khach_Dat"
                    + " WHERE MaDatPhong = '" + hd.getMaDatPhong() + "'";
            st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            String querymkh = "SELECT * FROM KhachHang "
                    + " WHERE SoCMNDKH = '" + hd.getSoCMNDKH() + "'";
            st = con.createStatement();
            ResultSet rs1 = st.executeQuery(querymkh);

//            String testma = "Trống";
//            String queryptr = "SELECT * FROM Phong "
//                    + " WHERE TinhTrang = N'" + testma + "'";
//            st = con.createStatement();
//            ResultSet rs2 = st.executeQuery(queryptr);
//            
            StringBuilder sb = new StringBuilder();
            if (rs.next()) {
                sb.append("Không được nhập trùng mã đặt phòng!\n");
            }
            if (!rs1.next()) {
                sb.append("Số CMND khách hàng không tồn tại trong CSDL KhachHang!\n");
            }
//            if (!rs2.next()) {
//                sb.append("Phòng được chọn hiện không ở trạng thái TRỐNG!\n");
//            }
            if (sb.length() > 0) {
                JOptionPane.showMessageDialog(null, sb);
            } else {
//                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//                df.setLenient(false);
//                df.parse(hd.getNgaylamhoadon());
//                df.parse(cs.getNgayghi());

                String query1 = "INSERT INTO Phong_Khach_Dat(MaDatPhong,MaPhong,SoCMNDKH,SoNguoiO,NgayDen,NgayDi,TienCoc,TinhTrang,GhiChu) VALUES (?,?,?,?,?,?,?,?,?)";
                
//                String query2 = "INSERT INTO CHISO(Chisothangnay,Chisothangtruoc,Ngayghi,maKhachHang) VALUES (?,?,?,?)";
                PreparedStatement pst1 = con.prepareStatement(query1);
                
//                PreparedStatement pst2 = con.prepareStatement(query2);
                pst1.setString(1, hd.getMaDatPhong());
                pst1.setString(2, hd.getMaPhong());               
                pst1.setString(3, hd.getSoCMNDKH());
                pst1.setString(4, hd.getSoNguoiO());                
                
                pst1.setString(5, hd.getNgayDen());
                pst1.setString(6, hd.getNgayDi());
                pst1.setFloat(7, hd.getTienCoc());
                pst1.setString(8, hd.getTinhTrang());
                pst1.setString(9, hd.getGhiChu());

//                pst2.setInt(1, cs.getChiSoThangNay());
//                pst2.setInt(2, cs.getChiSoThangTruoc());
//                pst2.setString(3, cs.getNgayghi());
//                pst2.setString(4, kh.getMakh());
                pst1.executeUpdate();
//                pst2.executeUpdate();
                return true;
            }
        }catch (Exception ex) {
            System.out.println("Lỗi nhập dữ liệu: addPhongKhachDat" + ex.toString());
        }
        // quăng lỗi nếu dateString ko hợp lệ
        return false;
    }

    public void delPhongKhachDat(String MaDatPhong) {
        try {
            String query1 = "DELETE FROM Phong_Khach_Dat WHERE MaDatPhong = '" + MaDatPhong + "'";
//            String query2 = "DELETE FROM HOADON WHERE maHoaDon = '" + maHD + "'";
            PreparedStatement pst1 = con.prepareStatement(query1);
//            PreparedStatement pst2 = con.prepareStatement(query2);
            pst1.executeUpdate();
//            pst2.executeUpdate();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi: delPhongKhachDat" + ex);
        }
        
    }

    public boolean updatePhongKhachDat(PhongKhachDat hd) throws SQLException {
        try {            
            String querymkh = "SELECT * FROM KhachHang "
                    + " WHERE SoCMNDKH = '" + hd.getSoCMNDKH() + "'";
            st = con.createStatement();
            ResultSet rs1 = st.executeQuery(querymkh);

            StringBuilder sb = new StringBuilder();
            if (!rs1.next()) {
                sb.append("Số CMND khách hàng không tồn tại trong CSDL KhachHang!\n");
            }
            if (sb.length() > 0) {
                JOptionPane.showMessageDialog(null, sb);
            }else{
            
                String query1 = "UPDATE Phong_Khach_Dat SET MaPhong= ?,SoCMNDKH= ?,"
                    + "SoNguoiO=?,NgayDen=?,NgayDi=?,TienCoc=?,TinhTrang=?,GhiChu=? WHERE MaDatPhong= ?";
//            String query2 = "UPDATE CHISO SET Chisothangnay= ?,Chisothangtruoc= ? WHERE maKhachHang= ? AND Ngayghi=  ? ";
            PreparedStatement pst1 = con.prepareStatement(query1);
//            PreparedStatement pst2 = con.prepareStatement(query2);
                pst1.setString(1, hd.getMaPhong());
                pst1.setString(2, hd.getSoCMNDKH());
                pst1.setString(3, hd.getSoNguoiO());
                pst1.setString(4, hd.getNgayDen());
                pst1.setString(5, hd.getNgayDi());
                pst1.setFloat(6, hd.getTienCoc());
                pst1.setString(7, hd.getTinhTrang());
                pst1.setString(8, hd.getGhiChu());
                pst1.setString(9, hd.getMaDatPhong());
            
//            pst2.setInt(1, cs.getChiSoThangNay());
//            pst2.setInt(2, cs.getChiSoThangTruoc());
//            pst2.setString(3, kh.getMakh());
//            pst2.setString(4, cs.getNgayghi());
                pst1.executeUpdate();
//            pst2.executeUpdate();
            return true;
            }
            
            

           
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi nhập dữ liệu: updatePhongKhachDat" + ex.toString());
        }
        return false;
    }

//    public ArrayList<HoaDon> finddHoaDon(String maHD) {
//        ArrayList<HoaDon> hdfind = new ArrayList<HoaDon>();
//        try {
//            String query1 = "SELECT * FROM HOADON "
//                    + "INNER JOIN CHISO ON HOADON.maKhachHang = CHISO.maKhachHang "
//                    + "AND MONTH(ngayLap)=MONTH(Ngayghi) AND YEAR(ngayLap)=YEAR(Ngayghi) "
//                    + "INNER JOIN KHACHHANG ON HOADON.maKhachHang = KHACHHANG.maKhachHang "
//                    + "INNER JOIN THONGTINCANHAN ON THONGTINCANHAN.CMND = KHACHHANG.CMND"
//                    + " WHERE maHoaDon = '" + maHD + "'";
//            st = con.createStatement();
//            ResultSet rs = st.executeQuery(query1);
//            HoaDon hd;
//            while (rs.next()) {
//                ChiSo cs = new ChiSo(rs.getInt("Chisothangtruoc"), rs.getInt("Chisothangnay"), rs.getString("Ngayghi"));
//                KhachHang kh = new KhachHang(rs.getString("maKhachHang"), rs.getString("HoTen"), rs.getString("DiaChi"));
//                hd = new HoaDon(rs.getString("maHoaDon"), rs.getString("ngayLap"),
//                        rs.getString("tinhTrang"), cs, kh, rs.getInt("Chisothangnay") - rs.getInt("Chisothangtruoc"));
//                hdfind.add(hd);
//            }
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, "Lỗi lấy dữ liệu " + ex.toString());
//            return null;
//        }
//        return hdfind;
    
    public PhongKhachDat findBySoCMND_PKD(String soCMNDKH) throws Exception{
        String sql = "SELECT MaDatPhong, Phong_Khach_Dat.MaPhong, "
                    + "SoCMNDKH, SoNguoiO, NgayDen, NgayDi, TienCoc, Phong_Khach_Dat.TinhTrang, "
                    + "Phong_Khach_Dat.GhiChu, GiaPhong From Phong_Khach_Dat INNER JOIN Phong ON Phong_Khach_Dat.MaPhong=Phong.MaPhong";
        try(
                Connection con = DatabaseHelper_1.OpenConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
            ){
            pstmt.setString(1, soCMNDKH);
            try( ResultSet rs = pstmt.executeQuery()){
                if(rs.next()){
                    PhongKhachDat pkd1 = new PhongKhachDat();
                    
                    pkd1.setMaDatPhong(rs.getString("MaDatPhong"));
                    pkd1.setMaPhong(rs.getString("MaPhong"));
                    pkd1.setSoCMNDKH(rs.getString("SoCMNDKH"));
                    
                    pkd1.setSoNguoiO(rs.getString("SoNguoiO"));
                    pkd1.setNgayDen(rs.getString("NgayDen"));
                    pkd1.setNgayDi(rs.getString("NgayDi"));
                    pkd1.setTienCoc(rs.getFloat("TienCoc"));
                    pkd1.setTinhTrang(rs.getString("TinhTrang"));
                    pkd1.setGhiChu(rs.getString("GhiChu"));
                    pkd1.setGhiChu(rs.getString("GiaPhong"));
                    return pkd1;
                }
            }
        }
        return null;
    }
    public boolean updatePhong_PKD_DangThue(Phong p) throws SQLException {
        try {
            String query1 = "UPDATE Phong SET  TinhTrang=N'Đang sử dụng' WHERE MaPhong= ?";

            PreparedStatement pst1 = con.prepareStatement(query1);
            pst1.setString(1, p.getMaPhong());
            pst1.executeUpdate();
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi nhập dữ liệu: updatePhong_PKD_DangThue" + ex.toString());
        }
        return false;
    }
    public boolean updatePhong_PKD_VeKhoa(Phong p) throws SQLException {
        try {
            String query1 = "UPDATE Phong SET  TinhTrang=N'Khoá' WHERE MaPhong= ?";

            PreparedStatement pst1 = con.prepareStatement(query1);
            pst1.setString(1, p.getMaPhong());
            pst1.executeUpdate();
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi nhập dữ liệu: updatePhong_PKD_VeKhoa" + ex.toString());
        }
        return false;
    }
}
