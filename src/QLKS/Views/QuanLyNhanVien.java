/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.Views;

import QLKS.Models.NhanVien;
import QLKS.Helper.DatabaseHelper;
import QLKS.Dao.QuanlynhanvienController;
import QLKS.Models.CustomtableQuanLyNhanVien;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MinhQuan
 */
public class QuanLyNhanVien extends javax.swing.JPanel {

    /**
     * Creates new form QuanLyNhanVien
     */
//    DefaultTableModel modelQLNV= new DefaultTableModel();
    static QuanlynhanvienController nvcontroller= new QuanlynhanvienController();
    ArrayList<NhanVien> list= new ArrayList<>();
    ArrayList<NhanVien> list1= new ArrayList<>();
    int selectRow=-1;
    int yearNow = Calendar.getInstance().get(Calendar.YEAR);
    private DefaultTableModel tblModel= new DefaultTableModel();
    public QuanLyNhanVien() throws SQLException{
        initComponents();
//       setLocationRelativeTo(null);
        initCombobox();
         load();
      
    }
    public static boolean Kiemtra(String maNV)throws SQLException{
        DatabaseHelper a =new DatabaseHelper();
        Connection conn=a.getConnection();
        Statement st = conn.createStatement();
        ResultSet re = st.executeQuery("SELECT * FROM NhanVien WHERE MaNV= '" + maNV+ "'  ");
         if(re.next())
            return  true;
        else
            return false;
    }
    private void ClearTxt(){
        txtmaNV.setText("");
        txthoTen.setText("");
        txtCMND.setText("");
           
        
        txtemail.setText("");
        txtSDT.setText("");       
        txtdiaChi.setText("");
//        txtghiChu.setText("");        
        cbxngay.setSelectedIndex(0);  
        cbxthang.setSelectedIndex(0); 
        cbxnam.setSelectedIndex(0); 
        
        cbxchucVu.setSelectedIndex(0);    
        cbxgioiTinh.setSelectedIndex(0);
        txtmaNV.requestFocus();
        txtTimKiem.setText("");
    }
    private void initCombobox(){
      
        for(int i=1950;i<=yearNow;i++){
            cbxnam.addItem(""+i);
            
        }
        cbxnam.setSelectedIndex(0);
        for(int i=1;i<=12;i++){
            cbxthang.addItem(""+i);
            
        }
        cbxthang.setSelectedIndex(1);
        
        for(int i=1;i<=31;i++){
                cbxngay.addItem(""+i);
            }
        cbxngay.setSelectedIndex(0);
        
    }
    void load() throws SQLException{
        list = nvcontroller.getAllNhanVien();
        tblQLNV.setModel(new CustomtableQuanLyNhanVien(list) ); 
    }
    void load1(ArrayList<NhanVien> a){
        tblQLNV.setModel(new CustomtableQuanLyNhanVien(a) ); 
    }
    boolean check1(){
        
      
            StringBuilder sb = new StringBuilder();
//           for(NhanVien c:list){
//               if(c.getSoCMND().equals(txtCMND.getText()))
//               {
//                   sb.append("Không được nhập trùng CMND");
//                   break;
//               }
//           }
        
         if(txtmaNV.getText().equals("")){
            sb.append("Mã nhân viên không được để trống\n");
        }
        if(txthoTen.getText().equals("")){
            sb.append("Họ tên nhân viên không được để trống\n");
        }
        if(txtCMND.getText().equals("")){
            sb.append("số CMND nhân viên không được để trống\n");
        }
        if(cbxthang.getSelectedItem().equals("4")||cbxthang.getSelectedItem().equals("6")||cbxthang.getSelectedItem().equals("9")||cbxthang.getSelectedItem().equals("11")){
            if(cbxngay.getSelectedItem().equals("31")){
                sb.append("Các Tháng 4,6,9,11 có 30 ngày! Mời Chọn Lại Ngày!!\n");
            }
        }
        if(cbxthang.getSelectedItem().equals("2")){
           if(Integer.parseInt(""+cbxnam.getSelectedItem())%4==0){
                if(cbxngay.getSelectedItem().equals("30")||cbxngay.getSelectedItem().equals("31")){
                    sb.append("Năm Nhuận Tháng 2 có 29 ngày! Mời Chọn Lại Ngày!\n");
                }
           }else{
                if(cbxngay.getSelectedItem().equals("29")||cbxngay.getSelectedItem().equals("30")||cbxngay.getSelectedItem().equals("31")){
                    sb.append("Tháng 2 có 28 ngày! Mời Chọn Lại Ngày!\n");
                }
           }
        }
       
        if(txtemail.getText().equals("")){
            sb.append("Email nhân viên không được để trống\n");
        }
        if(txtSDT.getText().equals("")){
            sb.append("SĐT nhân viên không được để trống\n");
        }
        if(txtdiaChi.getText().equals("")){
            sb.append("Địa chỉ nhân viên không được để trống\n");
        }
        if(sb.length()>0){
               JOptionPane.showMessageDialog(null, sb, "Thông báo", JOptionPane.WARNING_MESSAGE);       
    }
        if(sb.length() >0){
            return false;
        }else{
         return true;
        }
    }
    boolean check(){
      
            StringBuilder sb = new StringBuilder();
           for(NhanVien c:list){
               if(c.getSoCMND().equals(txtCMND.getText()))
               {
                   sb.append("Không được nhập trùng CMND\n");
                   break;
               }
           }
        
         if(txtmaNV.getText().equals("")){
            sb.append("Mã nhân viên không được để trống\n");
        }
        if(txthoTen.getText().equals("")){
            sb.append("Họ tên nhân viên không được để trống\n");
        }
        if(txtCMND.getText().equals("")){
            sb.append("số CMND nhân viên không được để trống\n");
        }
        if(cbxthang.getSelectedItem().equals("4")||cbxthang.getSelectedItem().equals("6")||cbxthang.getSelectedItem().equals("9")||cbxthang.getSelectedItem().equals("11")){
            if(cbxngay.getSelectedItem().equals("31")){
                sb.append("Các Tháng 4,6,9,11 có 30 ngày! Mời Chọn Lại Ngày!!\n");
            }
        }
        if(cbxthang.getSelectedItem().equals("2")){
           if(Integer.parseInt(""+cbxnam.getSelectedItem())%4==0){
                if(cbxngay.getSelectedItem().equals("30")||cbxngay.getSelectedItem().equals("31")){
                    sb.append("Năm Nhuận Tháng 2 có 29 ngày! Mời Chọn Lại Ngày!\n");
                }
           }else{
                if(cbxngay.getSelectedItem().equals("29")||cbxngay.getSelectedItem().equals("30")||cbxngay.getSelectedItem().equals("31")){
                    sb.append("Tháng 2 có 28 ngày! Mời Chọn Lại Ngày!\n");
                }
           }
        }
       
        if(txtemail.getText().equals("")){
            sb.append("Email nhân viên không được để trống\n");
        }
        if(txtSDT.getText().equals("")){
            sb.append("SĐT nhân viên không được để trống\n");
        }
        if(txtdiaChi.getText().equals("")){
            sb.append("Địa chỉ nhân viên không được để trống\n");
        }
        if(sb.length()>0){
               JOptionPane.showMessageDialog(null, sb, "Thông báo", JOptionPane.WARNING_MESSAGE);
               System.out.println("da chay"); 
       
    }
        if(sb.length() >0){
            return false;
        }else{
         return true;
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtCMND = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtdiaChi = new javax.swing.JTextField();
        txtTimKiem = new javax.swing.JTextField();
        cbxchucVu = new javax.swing.JComboBox<>();
        cbxgioiTinh = new javax.swing.JComboBox<>();
        txtmaNV = new javax.swing.JTextField();
        txthoTen = new javax.swing.JTextField();
        cbxngay = new javax.swing.JComboBox<>();
        cbxthang = new javax.swing.JComboBox<>();
        cbxnam = new javax.swing.JComboBox<>();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblQLNV = new javax.swing.JTable();
        btnLamMoi = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setText("QUẢN LÝ NHÂN VIÊN");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Mã nhân viên");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Họ tên");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Số CMND");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("Ngày sinh");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("Giới tính");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("Email");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setText("SĐT");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setText("Địa chỉ");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setText("Chức vụ");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel11.setText("Tìm kiếm");

        txtTimKiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemCaretUpdate(evt);
            }
        });

        cbxchucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản lý", "Nhân viên" }));

        cbxgioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        txtmaNV.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtmaNVCaretUpdate(evt);
            }
        });

        cbxngay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxngayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCMND)
                    .addComponent(cbxgioiTinh, 0, 272, Short.MAX_VALUE)
                    .addComponent(txtmaNV)
                    .addComponent(txthoTen)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cbxngay, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxthang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxnam, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtemail)
                        .addComponent(txtSDT)
                        .addComponent(txtdiaChi)
                        .addComponent(cbxchucVu, 0, 256, Short.MAX_VALUE)))
                .addContainerGap(13594, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtmaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txthoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxchucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbxngay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxthang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxnam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxgioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel6))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        btnThem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLKS/icons/add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLKS/icons/edit.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLKS/icons/delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        tblQLNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblQLNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQLNVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblQLNV);

        btnLamMoi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLKS/icons/content.png"))); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(btnThem)
                        .addGap(73, 73, 73)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(btnXoa)
                        .addGap(73, 73, 73)
                        .addComponent(btnLamMoi)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(355, 355, 355)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnXoa)
                        .addComponent(btnSua)
                        .addComponent(btnLamMoi)))
                .addGap(31, 31, 31)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7261, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
            boolean check=false;
            for(NhanVien nv:list)
            {
                if(nv.getMaNV().equals(txtmaNV.getText()))
                {
                    check=true;
                    break;
                }
            }      
            if(check){
                int xn = JOptionPane.showConfirmDialog(null,
                "Bạn có chắc muốn xoá bản ghi này không?",
                "Xác nhận",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
                if (xn == JOptionPane.YES_OPTION) {
                    try {
                        nvcontroller.XoaNhanVien(txtmaNV.getText());
//                        JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        load();
                        ClearTxt();
                    }
                    catch (SQLException ex) {
                        Logger.getLogger(QuanLyNhanVien.class.getName()).log(Level.SEVERE,null, ex);
                    }
                }
            }
            else{
                JOptionPane.showMessageDialog(this,"Mã nhân viên không tồn tại");
                txtmaNV.setText("");
                txtmaNV.requestFocus();
            }
//        System.out.println("dat chay"+selectRow);
//        if(selectRow ==-1){
//             JOptionPane.showMessageDialog(null, "chua chon dong can xoa");
//        }else{
//            String mav =txtmaNV.getText();
//            System.out.println("ma "+mav);
//            // xoa nv trong csdl
//            nvcontroller.XoaNhanVien(mav);     
//            try {
//                load();
//            } catch (SQLException ex) {
//                Logger.getLogger(QuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
//            }  
//        }
//        ClearTxt();
//                
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblQLNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQLNVMouseClicked
     
        selectRow=tblQLNV.getSelectedRow();
        int i=0;
        for(NhanVien nhanVien:list){
            if(nhanVien.getMaNV().equals(tblQLNV.getValueAt(selectRow,0))){
            i=list.indexOf(nhanVien);
        }
        }
      NhanVien a=list.get(i);
      txtmaNV.setText(a.getMaNV());
      txthoTen.setText(a.getHoTenNV());
    
      txtemail.setText(a.getEmail());
      if(a.getChucVu().equals("Nhân viên")){
          cbxchucVu.setSelectedItem("Nhân viên");
      }else {
          cbxchucVu.setSelectedItem("Quản lý");
      }
      txtdiaChi.setText(a.getDiaChi());
      txtCMND.setText(a.getSoCMND());
      txtSDT.setText(a.getSoDienThoai());
//      txtghiChu.setText(a.getGhiChu());
      if(a.getGioiTinh().equals("Nam")){
          cbxgioiTinh.setSelectedItem("Nam");
      }else{
          cbxgioiTinh.setSelectedItem("Nữ");
      }

        String[] s = a.getNgaySinh().split("-");
            cbxnam.setSelectedItem(""+Integer.parseInt(s[0]));
            cbxthang.setSelectedItem(""+Integer.parseInt(s[1]));
            String tam = ""+s[2].charAt(0)+s[2].charAt(1);
            cbxngay.setSelectedItem(""+Integer.parseInt(tam));
    }//GEN-LAST:event_tblQLNVMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
      
        
       if(check()){
           System.out.println("check = "+check());
                 NhanVien nvd;
               NhanVien nv= new NhanVien();
         
                String MaNV=txtmaNV.getText();
                String HoTenNV=txthoTen.getText();
                String SoCMND= txtCMND.getText();
                
                 nv.setNgaySinh(cbxnam.getSelectedItem()+"-"+cbxthang.getSelectedItem()+"-"+cbxngay.getSelectedItem());
                 String NgaySinh;
                NgaySinh=nv.getNgaySinh();
                String GioiTinh=cbxgioiTinh.getSelectedItem().toString();
                String Email= txtemail.getText();
                String SoDienThoai= txtSDT.getText();
                String DiaChi= txtdiaChi.getText();
                String ChucVu= cbxchucVu.getSelectedItem().toString();
//                String GhiChu= txtghiChu.getText();
                nvd= new NhanVien(MaNV, HoTenNV, SoCMND,NgaySinh, GioiTinh,Email,SoDienThoai, DiaChi, ChucVu);
                System.out.println(nvd.toString());
                System.out.println("da chay");
              
                if( txtmaNV.getText().equals("")
                ||txthoTen.getText().equals("")
                ||txtCMND.getText().equals("")
               
              
                ||txtemail.getText().equals("")
                ||txtSDT.getText().equals("")
                ||txtdiaChi.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Không được để trống dữ liệu!", "Thông báo", JOptionPane.WARNING_MESSAGE);
               }
                try {
                    if(nvcontroller.themNhanVienDao(nvd)){
                        JOptionPane.showMessageDialog(null, "Thêm thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        ClearTxt();
                    }
                } catch (Exception ex) {
                    Logger.getLogger(QuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                  
                } catch (Exception ex) {
                     Logger.getLogger(QuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }
           
              list.add(nvd);
           try {
               load();
           } catch (SQLException ex) {
               Logger.getLogger(QuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
     
//        String tam;
//        tam=txtCMND.getText();
//        for(NhanVien b:list){
//            if(b.getSoCMND().equals(txtCMND.getText())){
//                
//            }
//        }
       
        
           if(check1()){
               boolean ktra=true;
//               NhanVien nv= new NhanVien();
            try {
                String MaNV=txtmaNV.getText();
                String HoTenNV=txthoTen.getText();
                String SoCMND= txtCMND.getText();
                 
//                 nv.setNgaySinh(cbxnam.getSelectedItem()+"-"+cbxthang.getSelectedItem()+"-"+cbxngay.getSelectedItem());
                 String NgaySinh=cbxnam.getSelectedItem()+"-"+cbxthang.getSelectedItem()+"-"+cbxngay.getSelectedItem();
//                NgaySinh=nv.getNgaySinh();
                String GioiTinh=cbxgioiTinh.getSelectedItem().toString();
                String Email= txtemail.getText();
                String SoDienThoai= txtSDT.getText();
                String DiaChi= txtdiaChi.getText();
                String ChucVu= cbxchucVu.getSelectedItem().toString();
//                String GhiChu= txtghiChu.getText();
                NhanVien nvd= new NhanVien( MaNV,HoTenNV, SoCMND, NgaySinh, GioiTinh,Email,SoDienThoai, DiaChi, ChucVu);
                
                System.out.println(nvd.toString());
                System.out.println("da chay");
                list.set(selectRow,nvd);
                
//                if( txtmaNV.getText().equals("")
//                ||txthoTen.getText().equals("")
//                ||txtCMND.getText().equals("")
//               
//              
//                ||txtemail.getText().equals("")
//                ||txtSDT.getText().equals("")
//                ||txtdiaChi.getText().equals("")
//               ){
//                JOptionPane.showMessageDialog(null, "Không được để trống dữ liệu!", "Thông báo", JOptionPane.WARNING_MESSAGE);
//               }
                for(NhanVien nv:list){
                    if(nv.getMaNV().equals(nvd.getMaNV()))
                        continue;
                    else if(nv.getSoCMND().equals(nvd.getSoCMND())){
                        ktra=false;
                        break;
                    }
                }
                if(ktra){
                try {
                    if(nvcontroller.SuaNhanVien(nvd)){
                        JOptionPane.showMessageDialog(null, "Sửa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        ClearTxt();
                    }
                } catch (Exception ex) {
                    Logger.getLogger(QuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }
//                try {
//                  
//                } catch (Exception ex) {
//                     Logger.getLogger(QuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                try {
//                  
//                } catch (Exception ex) {
//                     Logger.getLogger(QuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
//                }
            }
            else
                    JOptionPane.showMessageDialog(this, "Trùng số CMND!");
                    } catch (Exception ex) {
                System.out.print(ex);
                
            }
            try {
                load();
            } catch (SQLException ex) {
                Logger.getLogger(QuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
           }
       
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        try {
            load();
            ClearTxt();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void cbxngayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxngayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxngayActionPerformed

    private void txtmaNVCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtmaNVCaretUpdate
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtmaNVCaretUpdate

    private void txtTimKiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemCaretUpdate
         list1.clear();
        for(NhanVien a: list){
            if(a.getSoCMND().contains(txtTimKiem.getText())||a.getHoTenNV().contains(txtTimKiem.getText())||a.getMaNV().contains(txtTimKiem.getText())){
                list1.add(a);
//                tblModel.addRow(new Object[]{a.getMaNV(),a.getHoTenNV(),a.getSoCMND(),a.getNgaySinh(),a.getGioiTinh(),a.getEmail(),a.getSoDienThoai(),a.getDiaChi(),a.getChucVu()});
                if(a.getSoCMND().equals(txtTimKiem.getText())||a.getHoTenNV().equals(txtTimKiem.getText())||a.getMaNV().equals(txtTimKiem.getText())){
                    txtmaNV.setText(a.getMaNV());
                    txthoTen.setText(a.getHoTenNV());
                    txtemail.setText(a.getEmail());
                if(a.getChucVu().equals("Nhân viên")){
                    cbxchucVu.setSelectedItem("Nhân viên");
                 }else {
                      cbxchucVu.setSelectedItem("Quản lý");
                 }
                    txtdiaChi.setText(a.getDiaChi());
                    txtCMND.setText(a.getSoCMND());
                    txtSDT.setText(a.getSoDienThoai());
//      txtghiChu.setText(a.getGhiChu());
                if(a.getGioiTinh().equals("Nam")){
                     cbxgioiTinh.setSelectedItem("Nam");
                   }else{
                         cbxgioiTinh.setSelectedItem("Nữ");
                       }

              String[] s = a.getNgaySinh().split("-");
            cbxnam.setSelectedItem(""+Integer.parseInt(s[0]));
            cbxthang.setSelectedItem(""+Integer.parseInt(s[1]));
            String tam = ""+s[2].charAt(0)+s[2].charAt(1);
            cbxngay.setSelectedItem(""+Integer.parseInt(tam));
                }
                else{
                    txthoTen.setText("");
                    txtmaNV.setText("");
                    txtCMND.setText("");
           
        
        txtemail.setText("");
        txtSDT.setText("");       
        txtdiaChi.setText("");
//        txtghiChu.setText("");        
              
        txtmaNV.getAction();
        cbxchucVu.setSelectedIndex(0);    
        cbxgioiTinh.setSelectedIndex(0); 
                }
            }
        }
        
        load1(list1);
       
    }//GEN-LAST:event_txtTimKiemCaretUpdate


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbxchucVu;
    private javax.swing.JComboBox<String> cbxgioiTinh;
    private javax.swing.JComboBox<String> cbxnam;
    private javax.swing.JComboBox<String> cbxngay;
    private javax.swing.JComboBox<String> cbxthang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tblQLNV;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtdiaChi;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txthoTen;
    private javax.swing.JTextField txtmaNV;
    // End of variables declaration//GEN-END:variables

    
}
