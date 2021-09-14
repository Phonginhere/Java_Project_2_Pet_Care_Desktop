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
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javaprojectpet.dao.ConnectDB.ketNoi;
import javaprojectpet.entitys.DatLich;
import javaprojectpet.entitys.KhachHang;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Phong
 */
public class Frame_Order_Edit extends javax.swing.JFrame {

    /**
     * Creates new form Frame_Order_Edit
     */
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    DefaultTableModel model;
    DefaultTableModel model1;
    DefaultTableModel model2;
    DefaultTableModel model3;
    public Frame_Order_Edit() {
        initComponents();
        this.setTitle("Thông tin chỉnh sửa phần đặt lịch");
        model = (DefaultTableModel)jTableGuest.getModel();
        model1 = (DefaultTableModel)jTablePet.getModel();
        model2 = (DefaultTableModel)JTablePetCompareGuest.getModel();
        model3 = (DefaultTableModel)jTable1.getModel();
        this.setLocationRelativeTo(null);
          try {
            con = ketNoi();
        } catch (Exception e) {
            System.out.println(e);
        }
          fill_idthucung();
          fill_idkhach();
          showTableGuest();
        showTablePet();
        showTable();
         choiceIdThuCung.setVisible(false);
        choiceIDGuest.setVisible(false);
        jLabel1.setVisible(false);
        jLabel2.setVisible(false);
        jTable1.setRowHeight(40);
        jTableGuest.setRowHeight(40);
        jTablePet.setRowHeight(40);
        JTablePetCompareGuest.setRowHeight(40);
    }
 public void showTable(){
        try{
           
        Connection con = ketNoi();
        PreparedStatement ps = con.prepareStatement("SELECT dl.id_datlich, dl.id_khachhang, kh.ten_khachhang, dl.id_thucung_datlich, tc.name_thucung, dl.thoigian_datlich, dl.trieuchung_datlich, dl.type from datlich as dl LEFT JOIN khachhang as kh on dl.id_khachhang = kh.id_khachhang LEFT JOIN thucung as tc on dl.id_thucung_datlich = tc.id_thucung");//chọn từ bảng datlich
        ResultSet rs=ps.executeQuery();//chạy lệnh dòng trên
        DefaultTableModel tm = (DefaultTableModel)jTable1.getModel();//tạo bảng mới trên form này
        tm.setRowCount(0);//măc định hàng thông tin là 0 
        while(rs.next()){
            Object o[]={rs.getInt("dl.id_datlich"), rs.getInt("dl.id_khachhang"), rs.getString("kh.ten_khachhang"), rs.getInt("dl.id_thucung_datlich"), rs.getString("tc.name_thucung"), rs.getString("dl.thoigian_datlich"), rs.getString("dl.trieuchung_datlich"), rs.getInt("dl.type")};
            //đưa thông tin bảng vào 1 biến obj
            tm.addRow(o);
            //sau đó gọi thêm hàng mới để trình bày biến obj là thông tin ở trên
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e);
            //có vấn đề sẽ hiện thông báo
        }
    }
 public void showTableGuest(){
        try{
         
        java.sql.Connection con = ketNoi();
        PreparedStatement ps = con.prepareStatement("select * from khachhang");
        java.sql.ResultSet rs=ps.executeQuery();
        DefaultTableModel tm = (DefaultTableModel)jTableGuest.getModel();
        tm.setRowCount(0);
        while(rs.next()){
            Object o[]={rs.getInt("id_khachhang"), rs.getString("ten_khachhang"), rs.getString("Email"), rs.getInt("sdt_khachhang"), rs.getString("ngaythem_khachhang"), rs.getString("Email")};
            tm.addRow(o);
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
    }
public void showTablePet(){
        try{
        
        java.sql.Connection con =ketNoi();
        PreparedStatement ps = con.prepareStatement("select * from thucung");
        java.sql.ResultSet rs=ps.executeQuery();
        DefaultTableModel tm = (DefaultTableModel)jTablePet.getModel();
        tm.setRowCount(0);
        while(rs.next()){
            Object o[]={rs.getInt("id_thucung"), rs.getString("name_thucung"), rs.getString("loaidongvat_thucung"), rs.getInt("tuoi_thucung")};
            tm.addRow(o);
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
    }
 private void fill_idthucung(){
     try{
         String sql = "select thucung.id_thucung from thucung";
         pst=con.prepareStatement(sql);
         rs=pst.executeQuery();
         
         while(rs.next()){
             String name = rs.getString("id_thucung");
             choiceIdThuCung.addItem(name);
         }
         
     }catch(Exception e){
          JOptionPane.showMessageDialog(null, e);
     }
 }
private void fill_idkhach(){
     try{
         String sql = "select khachhang.id_khachhang from khachhang";
         pst=con.prepareStatement(sql);
         rs=pst.executeQuery();
         
         while(rs.next()){
             String name = rs.getString("id_khachhang");
             choiceIDGuest.addItem(name);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableGuest = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTablePet = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButtonBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        choiceIdThuCung = new java.awt.Choice();
        choiceIDGuest = new java.awt.Choice();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jButtonEdit = new javax.swing.JButton();
        jButtonClear = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextFieldTrieuChung = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabelNamePet = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelNameGuest = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldTimKiemQuanHe = new javax.swing.JTextField();
        jTextFieldTimKiemDatLich = new javax.swing.JTextField();
        jTextFieldTimKiemThuCung = new javax.swing.JTextField();
        jTextFieldTKKhachHang = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        JTablePetCompareGuest = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableGuest.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jTableGuest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID khách hàng", "Tên khách hàng", "Email", "Số điện thoại", "Ngày thêm khách hàng"
            }
        ));
        jTableGuest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableGuestMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableGuest);

        jTablePet.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jTablePet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID thú cưng", "Tên thú cưng", "Loại động vật", "Tuổi"
            }
        ));
        jScrollPane3.setViewportView(jTablePet);

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "ID khách hàng", "Tên khách hàng", "Id thú cưng", "tên thú cưng", "Thời gian đặt lịch", "Triệu chưng", "Tình trạng"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBackground(new java.awt.Color(54, 33, 89));

        jButtonBack.setFont(new java.awt.Font("Tahoma", 0, 54)); // NOI18N
        jButtonBack.setText("Back");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID thú cưng");

        choiceIdThuCung.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N

        choiceIDGuest.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID khách hàng");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Triệu chứng");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Trình trạng");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("Chưa được Tiến Hành");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jRadioButton3.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton3.setText("Đã Tiến Hành Xong");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("Đang Tiến Hành");

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jRadioButton4.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton4.setText("Hủy");

        jButtonEdit.setBackground(new java.awt.Color(204, 255, 102));
        jButtonEdit.setFont(new java.awt.Font("Tahoma", 0, 47)); // NOI18N
        jButtonEdit.setForeground(new java.awt.Color(153, 204, 0));
        jButtonEdit.setText("Sửa");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });

        jButtonClear.setBackground(new java.awt.Color(255, 255, 102));
        jButtonClear.setFont(new java.awt.Font("Tahoma", 0, 47)); // NOI18N
        jButtonClear.setForeground(new java.awt.Color(204, 204, 0));
        jButtonClear.setText("Clear");
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });

        jTextFieldTrieuChung.setColumns(20);
        jTextFieldTrieuChung.setFont(new java.awt.Font("Monospaced", 0, 32)); // NOI18N
        jTextFieldTrieuChung.setRows(5);
        jScrollPane5.setViewportView(jTextFieldTrieuChung);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tên thú cưng");

        jLabelNamePet.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jLabelNamePet.setForeground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tên khách hàng");

        jLabelNameGuest.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jLabelNameGuest.setForeground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Tìm kiếm thông tin đặt lịch");

        jTextFieldTimKiemQuanHe.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jTextFieldTimKiemQuanHe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldTimKiemQuanHeKeyTyped(evt);
            }
        });

        jTextFieldTimKiemDatLich.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jTextFieldTimKiemDatLich.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldTimKiemDatLichKeyTyped(evt);
            }
        });

        jTextFieldTimKiemThuCung.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jTextFieldTimKiemThuCung.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldTimKiemThuCungKeyTyped(evt);
            }
        });

        jTextFieldTKKhachHang.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jTextFieldTKKhachHang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldTKKhachHangKeyTyped(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Tìm kiếm thông tin khách hàng ");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Tìm kiếm thông tin thú cưng");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Tìm kiếm thông tin về quan hệ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jButtonBack))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(725, 725, 725))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelNameGuest, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelNamePet, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(choiceIDGuest, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(choiceIdThuCung, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(68, 68, 68))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton1)
                                    .addComponent(jRadioButton3))
                                .addGap(39, 39, 39)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton2)
                                    .addComponent(jRadioButton4)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(374, 374, 374)
                                            .addComponent(jButtonEdit))
                                        .addComponent(jButtonClear))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(348, 348, 348)))
                                .addGap(202, 202, 202)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldTimKiemThuCung, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldTimKiemQuanHe, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldTimKiemDatLich, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(537, Short.MAX_VALUE)
                    .addComponent(jTextFieldTKKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(36, 36, 36)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(36, 36, 36)
                    .addComponent(jLabel12)
                    .addContainerGap(497, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(36, 36, 36)
                    .addComponent(jLabel13)
                    .addContainerGap(497, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(36, 36, 36)
                    .addComponent(jLabel14)
                    .addContainerGap(497, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButtonBack)
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(44, 44, 44)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(choiceIdThuCung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(choiceIDGuest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabelNamePet, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabelNameGuest, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4))
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEdit)
                    .addComponent(jButtonClear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 235, Short.MAX_VALUE)
                .addComponent(jTextFieldTimKiemThuCung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jTextFieldTimKiemQuanHe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTimKiemDatLich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(106, 106, 106))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(1144, Short.MAX_VALUE)
                    .addComponent(jTextFieldTKKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(422, 422, 422)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(1153, Short.MAX_VALUE)
                    .addComponent(jLabel12)
                    .addGap(419, 419, 419)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(1254, Short.MAX_VALUE)
                    .addComponent(jLabel13)
                    .addGap(318, 318, 318)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(1358, Short.MAX_VALUE)
                    .addComponent(jLabel14)
                    .addGap(214, 214, 214)))
        );

        jPanel4.setBackground(new java.awt.Color(110, 89, 222));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 54)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Thông tin Xóa đặt lịch");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Đặt Lịch/Chỉnh Đặt Lịch");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(jLabel10))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(540, 540, 540)
                        .addComponent(jLabel9)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(49, 49, 49)
                .addComponent(jLabel9)
                .addGap(39, 39, 39))
        );

        JTablePetCompareGuest.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        JTablePetCompareGuest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID khách hàng", "Tên khách hàng", "ID thú cưng", "Tên thú cưng"
            }
        ));
        JTablePetCompareGuest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTablePetCompareGuestMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(JTablePetCompareGuest);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1016, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 855, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane4))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        // TODO add your handling code here:
        jTextFieldTrieuChung.setText("");
        buttonGroup1.clearSelection();
        jLabelNameGuest.setText("");
        jLabelNamePet.setText("");
        jTextFieldTKKhachHang.setText("");
        jTextFieldTimKiemThuCung.setText("");
        jTextFieldTimKiemQuanHe.setText("");
        jTextFieldTimKiemDatLich.setText("");
    }//GEN-LAST:event_jButtonClearActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        // TODO add your handling code here:
        Frame_Guest_Edit frameguestedit = new Frame_Guest_Edit();
         String id_khach = choiceIDGuest.getSelectedItem().toString();
         String id_thucung = choiceIdThuCung.getSelectedItem().toString();
         String TrieuChung = jTextFieldTrieuChung.getText();
         

         DatLich datlich = new DatLich(id_khach, id_thucung, TrieuChung);

         if(jTextFieldTrieuChung.getText().trim().isEmpty()
                 || buttonGroup1.isSelected(null)
               || jLabelNameGuest.getText().trim().isEmpty()
                || jLabelNamePet.getText().trim().isEmpty()){
           JOptionPane.showMessageDialog(frameguestedit, "Chưa điền đầy đủ");
        }else{

             
             try {
            Class.forName("com.mysql.jdbc.Driver");
              Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ql_thucungcare", "root", "");
            Statement stm = con.createStatement();
          String sql1="select * from thucung where id_thucung='"+datlich.getId_thucung()+"' and id_khachhang_thucung='"+datlich.getId_khachhang()+"'";
           ResultSet rs =stm.executeQuery(sql1);
           if(rs.next()){
                //co  thong tin trung lap trong code sql se duoc them vao
              
                 JOptionPane.showMessageDialog(frameguestedit, "Thêm thành công!!. Sẽ Chuyển Trang trong 2 giây nữa.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Frame_Guest_Add.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.util.Date date=new java.util.Date(); //them doi tuong date

             java.sql.Date sqlDate=new java.sql.Date(date.getTime()); //lay thoi gian bay gio
             
        int row = jTable1.getSelectedRow(); //lay so hang minh muon nhan vao trong table
        TableModel model=jTable1.getModel(); // tao doi tuong tablemodel de lay thong tin o bang
        String value =  (jTable1.getModel().getValueAt(row, 0).toString()); // lay du lieu minh nhan vao trong hang o cot dau tien 
         String sql = "UPDATE `ql_thucungcare`.`datlich` SET`id_khachhang`=?,`id_thucung_datlich`=?,`trieuchung_datlich`=?,`type`=?  WHERE id_datlich='"+value+"'";
             try{
                pst = con.prepareStatement(sql);

                    pst.setString(1, datlich.getId_khachhang());
                pst.setString(2, datlich.getId_thucung());

                pst.setString(3, datlich.getTrieuchung());
               if(jRadioButton1.isSelected()){
                       pst.setInt(4, 1);
                   }else if(jRadioButton2.isSelected()){
                       pst.setInt(4, 2);
                   }else if(jRadioButton3.isSelected()){
                       pst.setInt(4, 3);
                   }else if(jRadioButton4.isSelected()){
                       pst.setInt(4, 4);
                   }
                   
                    pst.executeUpdate();
             }catch (Exception e) {
                 JOptionPane.showMessageDialog(null, e);
                // TODO: handle exception
    }
        new Frame_Order_Watch().setVisible(true);
        dispose();
         }else{
                JOptionPane.showMessageDialog(this, "Không có mối quan hệ giữa khách hàng và thú cưng.");
           }
             } catch (ClassNotFoundException ex) {
                Logger.getLogger(Frame_Order_Edit.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Frame_Order_Edit.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        // TODO add your handling code here:
        new Frame_Order_Watch().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
          int index=jTable1.getSelectedRow();
             TableModel model=jTable1.getModel();
             choiceIDGuest.select(model.getValueAt(index, 1).toString());
             choiceIdThuCung.select(model.getValueAt(index, 3).toString());
        jTextFieldTrieuChung.setText(model.getValueAt(index, 6).toString());
           jLabelNameGuest.setText(model.getValueAt(index, 2).toString());
        jLabelNamePet.setText(model.getValueAt(index, 4).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTableGuestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableGuestMouseClicked
        
            int row = jTableGuest.getSelectedRow();
        TableModel model=jTableGuest.getModel();
        String value =  (jTableGuest.getModel().getValueAt(row, 0).toString());
 try{
          
        java.sql.Connection con = ketNoi();
        PreparedStatement ps = con.prepareStatement("SELECT tc.id_khachhang_thucung, kh.ten_khachhang, tc.id_thucung, tc.name_thucung FROM thucung as tc LEFT JOIN khachhang as kh ON tc.id_khachhang_thucung = kh.id_khachhang WHERE kh.id_khachhang="+value);
        java.sql.ResultSet rs=ps.executeQuery();
        DefaultTableModel tm = (DefaultTableModel)JTablePetCompareGuest.getModel();
        tm.setRowCount(0);
        while(rs.next()){
            Object o[]={rs.getInt("tc.id_khachhang_thucung"), rs.getString("kh.ten_khachhang"), rs.getInt("tc.id_thucung"), rs.getString("tc.name_thucung")};
            tm.addRow(o);
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
        
    }//GEN-LAST:event_jTableGuestMouseClicked

    private void JTablePetCompareGuestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTablePetCompareGuestMouseClicked
        // TODO add your handling code here:
        int index=JTablePetCompareGuest.getSelectedRow();
        TableModel model=JTablePetCompareGuest.getModel();
        choiceIDGuest.select(model.getValueAt(index, 0).toString());
        choiceIdThuCung.select(model.getValueAt(index, 2).toString());
         jLabelNameGuest.setText(model.getValueAt(index, 1).toString());
        jLabelNamePet.setText(model.getValueAt(index, 3).toString());
    }//GEN-LAST:event_JTablePetCompareGuestMouseClicked
private void FilterQuanHe(String query){
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model2); 
        JTablePetCompareGuest.setRowSorter(tr);
        
        tr.setRowFilter(RowFilter.regexFilter(query));
    }
    private void jTextFieldTimKiemQuanHeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTimKiemQuanHeKeyTyped
        // TODO add your handling code here:
        String query = jTextFieldTimKiemQuanHe.getText();
        if(query != null && query.length() > 0){
            FilterQuanHe(query);
        }
    }//GEN-LAST:event_jTextFieldTimKiemQuanHeKeyTyped
private void FilterDatLich(String query){
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model3); 
        jTable1.setRowSorter(tr);
        
        tr.setRowFilter(RowFilter.regexFilter(query));
    }
    private void jTextFieldTimKiemDatLichKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTimKiemDatLichKeyTyped
        // TODO add your handling code here:
         String query = jTextFieldTimKiemDatLich.getText();
        if(query != null && query.length() > 0){
            FilterDatLich(query);
        }
    }//GEN-LAST:event_jTextFieldTimKiemDatLichKeyTyped
private void FilterThuCung(String query){
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model1); 
        jTablePet.setRowSorter(tr);
        
        tr.setRowFilter(RowFilter.regexFilter(query));
    }
    private void jTextFieldTimKiemThuCungKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTimKiemThuCungKeyTyped
        // TODO add your handling code here:
        String query = jTextFieldTimKiemThuCung.getText();
        if(query != null && query.length() > 0){
            FilterThuCung(query);
        }
    }//GEN-LAST:event_jTextFieldTimKiemThuCungKeyTyped
private void FilterKhachHang(String query){
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model); 
        jTableGuest.setRowSorter(tr);
        
        tr.setRowFilter(RowFilter.regexFilter(query));
    }
    private void jTextFieldTKKhachHangKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTKKhachHangKeyTyped
        // TODO add your handling code here:
         String query = jTextFieldTKKhachHang.getText();
        if(query != null && query.length() > 0){
            FilterKhachHang(query);
        }
    }//GEN-LAST:event_jTextFieldTKKhachHangKeyTyped

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
            java.util.logging.Logger.getLogger(Frame_Order_Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_Order_Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_Order_Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_Order_Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_Order_Edit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTablePetCompareGuest;
    private javax.swing.ButtonGroup buttonGroup1;
    private java.awt.Choice choiceIDGuest;
    private java.awt.Choice choiceIdThuCung;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelNameGuest;
    private javax.swing.JLabel jLabelNamePet;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableGuest;
    private javax.swing.JTable jTablePet;
    private javax.swing.JTextField jTextFieldTKKhachHang;
    private javax.swing.JTextField jTextFieldTimKiemDatLich;
    private javax.swing.JTextField jTextFieldTimKiemQuanHe;
    private javax.swing.JTextField jTextFieldTimKiemThuCung;
    private javax.swing.JTextArea jTextFieldTrieuChung;
    // End of variables declaration//GEN-END:variables
}
