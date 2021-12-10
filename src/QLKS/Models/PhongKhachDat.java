
package QLKS.Models;
import QLKS.Helper.DatabaseHelper;
import QLKS.Helper.ShareDataPhongKhachDat;
import QLKS.Models.Phong;
import java.awt.LayoutManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PhongKhachDat{
    private String MaDatPhong;
    private String MaPhong; 
    private String SoCMNDKH;
    private String SoNguoiO;
    private String NgayDen; 
    private String NgayDi;
    private float  TienCoc;
    private String TinhTrang;
    private String GhiChu;
    private float GiaPhong;
    private float ThanhTien;

    public PhongKhachDat() {
    }

    public PhongKhachDat(String MaDatPhong, String MaPhong, String SoCMNDKH, String SoNguoiO,String NgayDen, String NgayDi, Float TienCoc, String TinhTrang, String GhiChu, float GiaPhong) {
        this.MaDatPhong = MaDatPhong;
        this.MaPhong = MaPhong;
        this.SoCMNDKH = SoCMNDKH;
        this.SoNguoiO = SoNguoiO;
        this.NgayDen = NgayDen;
        this.NgayDi = NgayDi;
        this.TienCoc = TienCoc;
        this.TinhTrang = TinhTrang;
        this.GhiChu = GhiChu;
        this.GiaPhong = GiaPhong;
    }

    public String getMaDatPhong() {
        return MaDatPhong;
    }

    public void setMaDatPhong(String MaDatPhong) {
        this.MaDatPhong = MaDatPhong;
    }

    public String getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(String MaPhong) {
        this.MaPhong = MaPhong;
    }

    public String getSoCMNDKH() {
        return SoCMNDKH;
    }

    public void setSoCMNDKH(String SoCMNDKH) {
        this.SoCMNDKH = SoCMNDKH;
    }

    public String getSoNguoiO() {
        return SoNguoiO;
    }

    public void setSoNguoiO(String SoNguoiO) {
        this.SoNguoiO = SoNguoiO;
    }

    public String getNgayDen() {
        return NgayDen;
    }

    public void setNgayDen(String NgayDen) {
        this.NgayDen = NgayDen;
    }

    public String getNgayDi() {
        return NgayDi;
    }

    public void setNgayDi(String NgayDi) {
        this.NgayDi = NgayDi;
    }

    public Float getTienCoc() {
        return TienCoc;
    }

    public void setTienCoc(Float TienCoc) {
        this.TienCoc = TienCoc;
    }

    public String getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(String TinhTrang) {
        this.TinhTrang = TinhTrang;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }
    
    public double getGiaPhong() {
        return GiaPhong;
    }

    public void setGiaPhong(float GiaPhong) {
        this.GiaPhong = GiaPhong;
    }
    
    public double getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(float ThanhTien) {
        this.ThanhTien = ThanhTien;
    }
      
    public PhongKhachDat(String MaDatPhong, String MaPhong, String SoCMNDKH, String SoNguoiO, String NgayDen, String NgayDi, float TienCoc, String TinhTrang, String GhiChu) {
        this.MaDatPhong = MaDatPhong;
        this.MaPhong = MaPhong;
        this.SoCMNDKH = SoCMNDKH;
        this.SoNguoiO = SoNguoiO;
        this.NgayDen = NgayDen;
        this.NgayDi = NgayDi;
        this.TienCoc = TienCoc;
        this.TinhTrang = TinhTrang;
        this.GhiChu = GhiChu;
    }
    
    public double TinhSoNgay (String NgayDen, String NgayDi) throws ParseException{
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date datedi = format.parse(NgayDi);
        Date dateden = format.parse(NgayDen);
        
        long diff = datedi.getTime() - dateden.getTime();
        
        long Songay = (diff /(1000 * 60 * 60 * 24) % 1096) + 1;
        ThanhTien = Songay*GiaPhong;
        
        return ThanhTien;        
    }   
}
    
