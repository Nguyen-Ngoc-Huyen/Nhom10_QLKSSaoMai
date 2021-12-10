
package QLKS.Models;

import java.util.Objects;
public class TaiKhoan {
    private String tenDangNhap, matKhau;
    private int quyen;
    private String maNV;

    public TaiKhoan() {
    }
    public TaiKhoan(String tenDangNhap, String matKhau, int quyen, String maNV) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.quyen = quyen;
        this.maNV = maNV;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public int getQuyen() {
        return quyen;
    }

    public void setQuyen(int quyen) {
        this.quyen = quyen;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.tenDangNhap);
        hash = 59 * hash + Objects.hashCode(this.matKhau);
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
        final TaiKhoan other = (TaiKhoan) obj;
        if (!Objects.equals(this.tenDangNhap, other.tenDangNhap)) {
            return false;
        }
        if (!Objects.equals(this.matKhau, other.matKhau)) {
            return false;
        }
        return true;
    }
    
    public String toString() {
        return "TaiKhoan{" + "tenTaiKhoan=" + tenDangNhap + ", matKhau=" + matKhau + ", quyen=" + quyen + ", manv="+maNV+'}';
    }
}
