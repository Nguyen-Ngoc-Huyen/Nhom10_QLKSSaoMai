package QLKS.Models;
import QLKS.Helper.DatabaseHelper;
import QLKS.Helper.ShareDataPhongKhachDat;
import QLKS.Models.PhongKhachDat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PhongKhachDat_CustomTable extends AbstractTableModel{
    private ArrayList<PhongKhachDat> phongDats;
   

    //Khai báo xâu chứa tiêu đề của bảng.
    private String name[]={"Mã Đặt Phòng","Mã Phòng","Số CMNDKH",
        "Số Người Ở","Ngày Đến","Ngày Đi","Tiền Cọc","Trạng Thái", "Ghi Chú","Giá Phòng","Thành Tiền"};
    //Khai báo lớp Chứa kiểu dữ liệu của từng trường tương ứng.
    private Class classes[]={String.class,String.class,String.class,String.class,
        String.class,String.class,String.class,String.class,String.class,String.class,String.class};
    //Tạo một đối tượng arrayList có tên listThiSinh.

    public PhongKhachDat_CustomTable(ArrayList<PhongKhachDat> phongDats) {
        this.phongDats = phongDats;
    }

    @Override
    public int getRowCount() {
        return phongDats.size();
    }

    @Override
    public int getColumnCount() {
        return name.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            PhongKhachDat phongDat = phongDats.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return phongDat.getMaDatPhong();
                case 1:
                    return phongDat.getMaPhong();
                case 2:
                    return phongDat.getSoCMNDKH();
                case 3:
                    return phongDat.getSoNguoiO();
                case 4:
                    return phongDat.getNgayDen();
                case 5:
                    return phongDat.getNgayDi();
                case 6:
                    return phongDat.getTienCoc();
                case 7:
                    return phongDat.getTinhTrang();
                case 8:
                    return phongDat.getGhiChu();
                case 9:
                    return phongDat.getGiaPhong();
                case 10:
                    return phongDat.TinhSoNgay(phongDat.getNgayDen(),phongDat.getNgayDi());   
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

