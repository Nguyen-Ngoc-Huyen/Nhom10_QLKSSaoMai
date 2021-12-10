
package QLKS.Models;

import java.util.Date;

public class NhanVien {
    private String MaNV, HoTenNV, SoCMND,NgaySinh, GioiTinh, Email, SoDienThoai, DiaChi, ChucVu;
    
    public NhanVien() {
    }

    public NhanVien(String MaNV, String HoTenNV, String SoCMND, String NgaySinh, String GioiTinh, String Email, String SoDienThoai, String DiaChi, String ChucVu) {
        this.MaNV = MaNV;
        this.HoTenNV = HoTenNV;
        this.SoCMND = SoCMND;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.Email = Email;
        this.SoDienThoai = SoDienThoai;
        this.DiaChi = DiaChi;
        this.ChucVu = ChucVu;
//        this.GhiChu = GhiChu;
    }

    public NhanVien(String HoTenNV, String SoCMND, String NgaySinh, String GioiTinh, String Email, String SoDienThoai, String DiaChi, String ChucVu) {
        this.HoTenNV = HoTenNV;
        this.SoCMND = SoCMND;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.Email = Email;
        this.SoDienThoai = SoDienThoai;
        this.DiaChi = DiaChi;
        this.ChucVu = ChucVu;
//        this.GhiChu = GhiChu;
    }
    
    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getHoTenNV() {
        return HoTenNV;
    }

    public void setHoTenNV(String HoTenNV) {
        this.HoTenNV = HoTenNV;
    }

    public String getSoCMND() {
        return SoCMND;
    }

    public void setSoCMND(String SoCMND) {
        this.SoCMND = SoCMND;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }

    
    
   
}
