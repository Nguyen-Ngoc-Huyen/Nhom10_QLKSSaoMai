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

public class PhongKhachDat_CustomTable_PhongTrong extends AbstractTableModel{
    private ArrayList<Phong> phongTrongs;

    //Khai báo xâu chứa tiêu đề của bảng.
    private String name[]={"Mã Phòng","Loại Phòng","Giá Phòng","Tình Trạng"};
    //Khai báo lớp Chứa kiểu dữ liệu của từng trường tương ứng.
    private Class classes[]={String.class,String.class,String.class,String.class};
    //Tạo một đối tượng arrayList có tên listThiSinh.

    public PhongKhachDat_CustomTable_PhongTrong(ArrayList<Phong> phongTrongs) {
        this.phongTrongs = phongTrongs;
    }

    @Override
    public int getRowCount() {
        return phongTrongs.size();
    }

    @Override
    public int getColumnCount() {
        return name.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        
        
        try {
            Phong phongTrong = phongTrongs.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return phongTrong.getMaPhong();
                case 1:
                    return phongTrong.getLoaiPhong();
                case 2:
                    return phongTrong.getGiaPhong();
                case 3:
                    return phongTrong.getTinhTrang();
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

