
package QLKS.Models;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
public class CustomPhong extends AbstractTableModel{
    //Khai báo xâu chứa tiêu đề của bảng.
    private String name[]={"Mã phòng","Loại phòng","Giá phòng","Tình trạng","Ghi chú"};
    //Khai báo lớp Chứa kiểu dữ liệu của từng trường tương ứng.
    private Class classes[]={String.class,String.class,Double.class, String.class, String.class};
    //Tạo một đối tượng arrayList có tên listThiSinh.
    static ArrayList<Phong> dsPhong=new ArrayList<Phong>();
    
    //phương thức khởi tạo cho class có tham số truyền vào.
    public CustomPhong(ArrayList<Phong> lstPhong)
   {
       this.dsPhong=lstPhong;
   }
    //lấy số phần tử của listThiSinh
    @Override
    public int getRowCount()
    {
        return dsPhong.size();
    }
    //Lấy số lượng tiêu để của mảng.
    @Override
    public int getColumnCount()
    {
        return name.length;
    }
    //Đưa thông tin của phần tử trong arrayList lên jTable
    public Object getValueAt(int rowIndex,int columnIndex)
    {
        switch(columnIndex)
        {
            case 0: return dsPhong.get(rowIndex).getMaPhong();

            case 1: return dsPhong.get(rowIndex).getLoaiPhong();

            case 2: return dsPhong.get(rowIndex).getGiaPhong();
            
            case 3: return dsPhong.get(rowIndex).getTinhTrang();
            
            case 4: return dsPhong.get(rowIndex).getGhiChu();
            
            default :return null;
        }
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
