package QLKS.Models;
import QLKS.Helper.DatabaseHelper;
import QLKS.Helper.ShareDataPhongKhachDat;
import QLKS.Models.PhongKhachDat;
import QLKS.Models.Phong;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PhongKhachDat_CustomTable_KhachHang extends AbstractTableModel{
    private ArrayList<KhachHang> khachHangs;

    //Khai báo xâu chứa tiêu đề của bảng.
    private String name[]={"Số CMND","Họ Tên","Giới Tính","Số ĐT","Ghi Chú"};
    //Khai báo lớp Chứa kiểu dữ liệu của từng trường tương ứng.
    private Class classes[]={String.class,String.class,String.class,String.class,String.class};
    //Tạo một đối tượng arrayList có tên listThiSinh.

    public PhongKhachDat_CustomTable_KhachHang(ArrayList<KhachHang> khachHangs) {
        this.khachHangs = khachHangs;
    }

    @Override
    public int getRowCount() {
        return khachHangs.size();
    }

    @Override
    public int getColumnCount() {
        return name.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        
        try {
            KhachHang kh1 = khachHangs.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return kh1.getSoCMNDKH();
                case 1:
                    return kh1.getHoTenKH();
                case 2:
                    return kh1.getGioiTinh();
                case 3:
                    return kh1.getSoDT();
                case 4:
                    return kh1.getGhiChu();
            }
        } catch (Exception e) {

        }

        return null;
    }
    @Override
    public Class getColumnClass(int columnIndex)
    {
        return classes[columnIndex];
    }

    @Override
    public String getColumnName(int column)
    {
        return name[column];
    }

   
    
}

