/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojectpet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javaprojectpet.dao.ConnectDB.ketNoi;
import javaprojectpet.entitys.ChamSoc;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Phong
 */
public class Frame_TimeCare_Edit extends javax.swing.JFrame {

    /**
     * Creates new form Frame_TimeCare_Add
     */
     Connection con;
    PreparedStatement pst;
    ResultSet rs;
     DefaultTableModel model;
     DefaultTableModel model1;
     DefaultTableModel model2;
    public Frame_TimeCare_Edit() {
        initComponents();
        this.setTitle("Trang chỉnh sửa thông tin chăm sóc thú cưng"); //đặt tiêu đề
        this.setLocationRelativeTo(null);//đặt mặc định 
        model = (DefaultTableModel)jTable1.getModel();
        model1 = (DefaultTableModel)jTableNhanVien.getModel();
        model2 = (DefaultTableModel)jTableDatLich.getModel();
         try {
            con = ketNoi();
        } catch (Exception e) {
            System.out.println(e);
        }
        showTable();
        jTable1.setRowHeight(40);  
         jTableNhanVien.setRowHeight(40); 
       jTableDatLich.setRowHeight(40); 
        fill_idnhanvien();
        fill_idDatlich();
        
          showTableNhanvien();
          showTableDatLich();
          
        choiceIdNhanVien.setVisible(false);
        choiceID_Datlich.setVisible(false);
        jLabel4.setVisible(false);
        jLabel2.setVisible(false);
          
    }
   
  public void showTable(){
        try{
          
        java.sql.Connection con = ketNoi();
        PreparedStatement ps = con.prepareStatement("SELECT cs.id_chamsoc, cs.idnhanvien_chamsoc, "
                + "nv.fullname_nhanvien, cs.id_datlich, dl.id_khachhang, kh.ten_khachhang, "
                + "dl.id_thucung_datlich, tc.name_thucung, tc.loaidongvat_thucung, "
                + "dl.trieuchung_datlich, cs.cachchua_chamsoc, cs.thoigiankethuc_chamsoc, "
                + "cs.price_chamsoc from chamsoc AS cs "
                + "LEFT JOIN nhanvien AS nv "
                + "on cs.idnhanvien_chamsoc = nv.id_nhanvien "
                + "LEFT JOIN datlich AS dl "
                + "on cs.id_datlich = dl.id_datlich "
                + "LEFT JOIN khachhang AS kh "
                + "on dl.id_khachhang = kh.id_khachhang "
                + "LEFT JOIN thucung AS tc "
                + "on dl.id_thucung_datlich = tc.id_thucung");
        ResultSet rs=ps.executeQuery();
        DefaultTableModel tm = (DefaultTableModel)jTable1.getModel();
        tm.setRowCount(0);// lấy đc thông tin thì thêm vào một hàng
        while(rs.next()){
            Object o[]={rs.getInt("cs.id_chamsoc"), rs.getInt("cs.idnhanvien_chamsoc"), 
                rs.getString("nv.fullname_nhanvien"), rs.getInt("cs.id_datlich"), 
                rs.getInt("dl.id_khachhang"), rs.getString("kh.ten_khachhang"), 
                rs.getInt("dl.id_thucung_datlich"), rs.getString("tc.name_thucung"), 
                rs.getString("tc.loaidongvat_thucung"), 
                rs.getString("dl.trieuchung_datlich"), 
                rs.getString("cs.cachchua_chamsoc"), 
                rs.getString("cs.thoigiankethuc_chamsoc"),
                rs.getInt("cs.price_chamsoc")};
            tm.addRow(o);
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
    }
  public void showTableNhanvien(){
        try{
          
        java.sql.Connection con = ketNoi();
        PreparedStatement ps = con.prepareStatement("SELECT id_nhanvien, fullname_nhanvien FROM nhanvien");
        java.sql.ResultSet rs=ps.executeQuery();
        DefaultTableModel tm = (DefaultTableModel)jTableNhanVien.getModel();
        tm.setRowCount(0);
        while(rs.next()){
            Object o[]={rs.getInt("id_nhanvien"), rs.getString("fullname_nhanvien")};
            //tạo đối tượng chứa thông tin
             tm.addRow(o);
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
    } 
    public void showTableDatLich(){
        try{
          
        java.sql.Connection con = ketNoi();
        PreparedStatement ps = con.prepareStatement("SELECT dl.id_datlich, kh.ten_khachhang, tc.name_thucung, tc.loaidongvat_thucung, dl.trieuchung_datlich "
                + "from datlich as dl LEFT JOIN khachhang AS kh "
                + "ON dl.id_khachhang = kh.id_khachhang "
                + "LEFT JOIN thucung AS tc "
                + "ON dl.id_thucung_datlich = tc.id_thucung");
        java.sql.ResultSet rs= ps.executeQuery();
        DefaultTableModel tm = (DefaultTableModel)jTableDatLich.getModel();
        tm.setRowCount(0);
        while(rs.next()){
            Object o[]={rs.getInt("dl.id_datlich"), rs.getString("kh.ten_khachhang"), rs.getString("tc.name_thucung"), rs.getString("tc.loaidongvat_thucung"), rs.getString("dl.trieuchung_datlich")};
             tm.addRow(o);
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
    } 
 private void fill_idDatlich(){
     try{
         String sql = "select datlich.id_datlich from datlich";
         pst=con.prepareStatement(sql);
         rs=pst.executeQuery();
         
         while(rs.next()){
             String name = rs.getString("id_datlich");
             choiceID_Datlich.addItem(name);//thêm vào hàm chọn 
         }
         
     }catch(Exception e){
          JOptionPane.showMessageDialog(null, e);
     }
 }
 private void fill_idnhanvien(){
     try{
         String sql = "select nhanvien.id_nhanvien from nhanvien";
         pst=con.prepareStatement(sql);
         rs=pst.executeQuery();
         
         while(rs.next()){
             String name = rs.getString("id_nhanvien");
             choiceIdNhanVien.addItem(name);
         }
         
     }catch(Exception e){
          JOptionPane.showMessageDialog(null, e);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jTextFieldGiaTien = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        choiceID_Datlich = new java.awt.Choice();
        jLabel2 = new javax.swing.JLabel();
        choiceIdNhanVien = new java.awt.Choice();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButtonEdit = new javax.swing.JButton();
        jButtonReset = new javax.swing.JButton();
        jTextFieldTimKiemNhanVien = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButtonBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabelNamePersonDatLich = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelNameNV = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextFieldCachchua = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldTimKiemChamSoc = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldTimKiemDatLich = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableNhanVien = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableDatLich = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(54, 33, 89));

        jTextFieldGiaTien.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jTextFieldGiaTien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldGiaTienKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Giá tiền");

        choiceID_Datlich.setFont(new java.awt.Font("Dialog", 0, 40)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 34)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID đặt lịch");

        choiceIdNhanVien.setFont(new java.awt.Font("Dialog", 0, 40)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 34)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ID nhân viên");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cách chữa");

        jButtonEdit.setBackground(new java.awt.Color(204, 255, 51));
        jButtonEdit.setFont(new java.awt.Font("Tahoma", 0, 47)); // NOI18N
        jButtonEdit.setForeground(new java.awt.Color(153, 204, 0));
        jButtonEdit.setText("Sửa");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });

        jButtonReset.setBackground(new java.awt.Color(255, 255, 153));
        jButtonReset.setFont(new java.awt.Font("Tahoma", 0, 47)); // NOI18N
        jButtonReset.setForeground(new java.awt.Color(204, 204, 0));
        jButtonReset.setText("Reset");
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });

        jTextFieldTimKiemNhanVien.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jTextFieldTimKiemNhanVien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldTimKiemNhanVienKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Tìm kiếm thông tin nhân viên");

        jButtonBack.setFont(new java.awt.Font("Tahoma", 0, 54)); // NOI18N
        jButtonBack.setText("Back");
        jButtonBack.setToolTipText("");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tên người đặt lịch");

        jLabelNamePersonDatLich.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jLabelNamePersonDatLich.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tên nhân viên");

        jLabelNameNV.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jLabelNameNV.setForeground(new java.awt.Color(255, 255, 255));

        jTextFieldCachchua.setColumns(20);
        jTextFieldCachchua.setFont(new java.awt.Font("Monospaced", 0, 30)); // NOI18N
        jTextFieldCachchua.setRows(5);
        jScrollPane2.setViewportView(jTextFieldCachchua);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Tìm kiếm thông tin chăm sóc");

        jTextFieldTimKiemChamSoc.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jTextFieldTimKiemChamSoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldTimKiemChamSocKeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Tìm kiếm thông tin đặt lịch");

        jTextFieldTimKiemDatLich.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jTextFieldTimKiemDatLich.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldTimKiemDatLichKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jButtonBack))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldTimKiemNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jTextFieldTimKiemChamSoc, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(141, 141, 141)
                            .addComponent(jButtonReset)
                            .addGap(210, 210, 210)
                            .addComponent(jButtonEdit))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(73, 73, 73)
                            .addComponent(jTextFieldGiaTien, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(63, 63, 63)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(32, 32, 32)
                                .addComponent(choiceID_Datlich, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(choiceIdNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelNameNV, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelNamePersonDatLich, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(45, 45, 45)
                    .addComponent(jLabel13)
                    .addContainerGap(295, Short.MAX_VALUE)))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(45, Short.MAX_VALUE)
                    .addComponent(jTextFieldTimKiemDatLich, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(39, 39, 39)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jButtonBack)
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(17, 17, 17))
                            .addComponent(choiceID_Datlich, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(choiceIdNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel4)))
                        .addGap(63, 63, 63)
                        .addComponent(jLabel1))
                    .addComponent(jLabelNamePersonDatLich, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNameNV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldGiaTien, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(54, 54, 54)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonReset)
                    .addComponent(jButtonEdit))
                .addGap(145, 145, 145)
                .addComponent(jLabel9)
                .addGap(7, 7, 7)
                .addComponent(jTextFieldTimKiemNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldTimKiemChamSoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(1229, Short.MAX_VALUE)
                    .addComponent(jLabel13)
                    .addGap(202, 202, 202)))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(1290, Short.MAX_VALUE)
                    .addComponent(jTextFieldTimKiemDatLich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(135, 135, 135)))
        );

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "ID nhân viên", "tên nhân viên", "id đặt lịch", "id khách hàng", "tên khách hàng", "id thú cưng", "tên thú cưng", "loài động vật", "triệu chưng", "cách chữa", "thời gian kết thúc chăm sóc", "giá tiền chăm sóc"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel4.setBackground(new java.awt.Color(110, 89, 222));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Chăm Sóc/Sửa Chăm Sóc");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 54)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Thông tin sửa chăm sóc");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(394, 394, 394)
                        .addComponent(jLabel11))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(729, 729, 729)
                        .addComponent(jLabel12)))
                .addContainerGap(753, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel11)
                .addGap(59, 59, 59)
                .addComponent(jLabel12)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        jTableNhanVien.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jTableNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID nhân viên", "Tên nhân viên"
            }
        ));
        jTableNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableNhanVienMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableNhanVien);

        jTableDatLich.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jTableDatLich.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id đặt lịch", "tên khách", "tên thú cưng", "Loài thú cưng", "Triệu chứng"
            }
        ));
        jTableDatLich.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDatLichMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTableDatLich);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 872, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
        // TODO add your handling code here:
       jTextFieldGiaTien.setText("");
       jLabelNamePersonDatLich.setText("");
        jTextFieldCachchua.setText("");
        jTextFieldGiaTien.setText("");
        jLabelNameNV.setText("");
        jTextFieldTimKiemNhanVien.setText("");
        jTextFieldTimKiemDatLich.setText("");
       jTextFieldTimKiemChamSoc.setText("");
    }//GEN-LAST:event_jButtonResetActionPerformed

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        // TODO add your handling code here:
        new Frame_TimeCare_Information().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        // TODO add your handling code here:
        Frame_TimeCare_Edit edittimetocare = new Frame_TimeCare_Edit();
        String id_nhanvienchamsoc = choiceIdNhanVien.getSelectedItem().toString();
        String id_datlich = choiceID_Datlich.getSelectedItem().toString();
        String giaTien = jTextFieldGiaTien.getText();
        String CachChua = jTextFieldCachchua.getText();
        
        ChamSoc chamsoc = new ChamSoc(giaTien, CachChua, id_nhanvienchamsoc,  id_datlich);
        
         if(jTextFieldCachchua.getText().trim().isEmpty()
                || jLabelNameNV.getText().trim().isEmpty()
                || jLabelNamePersonDatLich.getText().trim().isEmpty()
                || jTextFieldGiaTien.getText().trim().isEmpty()){
           JOptionPane.showMessageDialog(edittimetocare, "Chưa điền đầy đủ");
        }else{
        JOptionPane.showMessageDialog(edittimetocare, "Sửa thành công!!. Sẽ Chuyển Trang trong 2 giây nữa.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Frame_TimeCare_Edit.class.getName()).log(Level.SEVERE, null, ex);
        }
       
         int row = jTable1.getSelectedRow();
        TableModel model=jTable1.getModel();
        String value =  (jTable1.getModel().getValueAt(row, 0).toString());
         String sql = "UPDATE `ql_thucungcare`.`chamsoc` SET `price_chamsoc`=?,`cachchua_chamsoc`=?,`idnhanvien_chamsoc`=?,`id_datlich`=? WHERE id_chamsoc="+value;
         
             try{
                 pst = con.prepareStatement(sql);
                 
                  pst.setString(1, chamsoc.getPrice_cham_soc());
                 
                  
                   pst.setString(2, chamsoc.getCachchua_chamsoc());
                   pst.setString(3, chamsoc.getId_nhanvienchamsoc());
                    pst.setString(4, chamsoc.getId_datlich());
                   
                   
                    pst.executeUpdate();
             }catch (Exception e) {
//                 System.out.println(e);
                // TODO: handle exception
    }
        new Frame_TimeCare_Information().setVisible(true);
        dispose();
         }
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jTextFieldGiaTienKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldGiaTienKeyTyped
        // TODO add your handling code here:
        if(!Character.isDigit(evt.getKeyChar())){
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldGiaTienKeyTyped
 private void FilterNhanVien(String query){
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model1); 
        jTableNhanVien.setRowSorter(tr);
        
        tr.setRowFilter(RowFilter.regexFilter(query));
    }
    private void jTextFieldTimKiemNhanVienKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTimKiemNhanVienKeyTyped
        // TODO add your handling code here:
          String query = jTextFieldTimKiemNhanVien.getText();
        if(query != null && query.length() > 0){
           FilterNhanVien(query); 
        }
    }//GEN-LAST:event_jTextFieldTimKiemNhanVienKeyTyped

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
           int index=jTable1.getSelectedRow();
             TableModel model=jTable1.getModel();
             choiceID_Datlich.select(model.getValueAt(index, 3).toString());
             choiceIdNhanVien.select(model.getValueAt(index, 1).toString());
            jTextFieldCachchua.setText(model.getValueAt(index, 10).toString());
             jTextFieldGiaTien.setText(model.getValueAt(index, 12).toString());
             jLabelNamePersonDatLich.setText(model.getValueAt(index, 5).toString());
             jLabelNameNV.setText(model.getValueAt(index, 2).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTableNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableNhanVienMouseClicked
        // TODO add your handling code here:
          int index=jTableNhanVien.getSelectedRow();
             TableModel model=jTableNhanVien.getModel();
        choiceIdNhanVien.select(model.getValueAt(index, 0).toString());
        jLabelNameNV.setText(model.getValueAt(index, 1).toString());
    }//GEN-LAST:event_jTableNhanVienMouseClicked

    private void jTableDatLichMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDatLichMouseClicked
        // TODO add your handling code here:
         int index=jTableDatLich.getSelectedRow();
             TableModel model=jTableDatLich.getModel();
        choiceID_Datlich.select(model.getValueAt(index, 0).toString());

    }//GEN-LAST:event_jTableDatLichMouseClicked
private void FilterChamSoc(String query){
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model); 
        jTable1.setRowSorter(tr);
        
        tr.setRowFilter(RowFilter.regexFilter(query));
    }
    private void jTextFieldTimKiemChamSocKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTimKiemChamSocKeyTyped
        // TODO add your handling code here:
            String query = jTextFieldTimKiemChamSoc.getText();
        if(query != null && query.length() > 0){
           FilterChamSoc(query); 
        }
    }//GEN-LAST:event_jTextFieldTimKiemChamSocKeyTyped
private void FilterDatLich(String query){
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model2); 
        jTableDatLich.setRowSorter(tr);
        
        tr.setRowFilter(RowFilter.regexFilter(query));
    }
    private void jTextFieldTimKiemDatLichKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTimKiemDatLichKeyTyped
        // TODO add your handling code here:
          String query = jTextFieldTimKiemDatLich.getText();
        if(query != null && query.length() > 0){
           FilterDatLich(query); 
        }
    }//GEN-LAST:event_jTextFieldTimKiemDatLichKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame_TimeCare_Add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_TimeCare_Add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_TimeCare_Add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_TimeCare_Add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_TimeCare_Edit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private java.awt.Choice choiceID_Datlich;
    private java.awt.Choice choiceIdNhanVien;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelNameNV;
    private javax.swing.JLabel jLabelNamePersonDatLich;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableDatLich;
    private javax.swing.JTable jTableNhanVien;
    private javax.swing.JTextArea jTextFieldCachchua;
    private javax.swing.JTextField jTextFieldGiaTien;
    private javax.swing.JTextField jTextFieldTimKiemChamSoc;
    private javax.swing.JTextField jTextFieldTimKiemDatLich;
    private javax.swing.JTextField jTextFieldTimKiemNhanVien;
    // End of variables declaration//GEN-END:variables
}
