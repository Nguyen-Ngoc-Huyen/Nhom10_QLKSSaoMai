
package QLKS.Models;
import java.util.Objects;
public class KhachHang {
    private String soCMNDKH, hoTenKH, ngaySinh,gioiTinh, soDT, email, diaChi, ghiChu;

    public KhachHang() {
    }

    public KhachHang(String soCMNDKH, String hoTenKH, String ngaySinh, String gioiTinh, String soDT, String email, String diaChi, String ghiChu) {
        this.soCMNDKH = soCMNDKH;
        this.hoTenKH = hoTenKH;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soDT = soDT;
        this.email = email;
        this.diaChi = diaChi;
        this.ghiChu = ghiChu;
    }
    public KhachHang(String soCMNDKH, String hoTenKH, String gioiTinh, String soDT, String ghiChu) {
        this.soCMNDKH = soCMNDKH;
        this.hoTenKH = hoTenKH;
        this.gioiTinh = gioiTinh;
        this.soDT = soDT;
        this.ghiChu = ghiChu;
    }
    public String getSoCMNDKH() {
        return soCMNDKH;
    }

    public void setSoCMNDKH(String soCMNDKH) {
        this.soCMNDKH = soCMNDKH;
    }

    public String getHoTenKH() {
        return hoTenKH;
    }

    public void setHoTenKH(String hoTenKH) {
        this.hoTenKH = hoTenKH;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.soCMNDKH);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KhachHang other = (KhachHang) obj;
        if (!Objects.equals(this.soCMNDKH, other.soCMNDKH)) {
            return false;
        }
        return true;
    }
    
    
}
