/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.Models;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author admin
 */
public class CustomTaiKhoan extends AbstractTableModel{
    //Khai báo xâu chứa tiêu đề của bảng.
    private String name[]={"Tên đăng nhập","Mật khẩu","Quyền","Mã nhân viên"};
    //Khai báo lớp Chứa kiểu dữ liệu của từng trường tương ứng.
    private Class classes[]={String.class,String.class,Integer.class, String.class};
    //Tạo một đối tượng arrayList có tên listThiSinh.
    static ArrayList<TaiKhoan> dsTK=new ArrayList<TaiKhoan>();
    
    //phương thức khởi tạo cho class có tham số truyền vào.
    public CustomTaiKhoan(ArrayList<TaiKhoan> lstTaiKhoan)
   {
       this.dsTK=lstTaiKhoan;
   }
    //lấy số phần tử của listThiSinh
    @Override
    public int getRowCount()
    {
        return dsTK.size();
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
            case 0: return dsTK.get(rowIndex).getTenDangNhap();

            case 1: return dsTK.get(rowIndex).getMatKhau();

            case 2: return dsTK.get(rowIndex).getQuyen();
            
            case 3: return dsTK.get(rowIndex).getMaNV();
            
            
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
