/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojectpet;

import java.net.PasswordAuthentication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javaprojectpet.dao.ConnectDB.ketNoi;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author linh, nhi
 */
public class Frame_TimeCare_Information extends javax.swing.JFrame {

    /**
     * Creates new form FrameTimeCareForPet
     */
      Connection con;
    PreparedStatement pst;
    ResultSet rs;
    DefaultTableModel model;
    public Frame_TimeCare_Information() {
         initComponents();
         this.setTitle("Lịch Chăm Sóc Thú Cưng");
        this.setLocationRelativeTo(null);
        model = (DefaultTableModel)jTable1.getModel();
          try {
            con = ketNoi();
        } catch (Exception e) {
            System.out.println(e);
        }
          jLabel4.setVisible(false);
          choiceIDChamSoc.setVisible(false);
          try {
              totalMoneyForCuring();
              averageMoneyForCuring();
              countMoneyForCuring();
          } catch (SQLException ex) {
              Logger.getLogger(Frame_TimeCare_Information.class.getName()).log(Level.SEVERE, null, ex);
          }
        showTable();
        jTable1.setRowHeight(40);
    }
    public void totalMoneyForCuring() throws SQLException{
         String sql="Select Sum(price_chamsoc) as sumprice from chamsoc";
                          pst=con.prepareStatement(sql);
                          rs=pst.executeQuery();
                          if(rs.next()){
                              String sum = rs.getString("sumprice");
                       jLabelTotalMoney.setText(sum);
        }
    }
    public void averageMoneyForCuring() throws SQLException{
         String sql="Select AVG(price_chamsoc) as sumprice from chamsoc";
                          pst=con.prepareStatement(sql);
                          rs=pst.executeQuery();
                          if(rs.next()){
                              String sum = rs.getString("sumprice");
                       jLabelAVGMoney.setText(sum);
        }
    }
    public void countMoneyForCuring() throws SQLException{
         String sql="Select COUNT(price_chamsoc) as sumprice from chamsoc";
                          pst=con.prepareStatement(sql);
                          rs=pst.executeQuery();
                          if(rs.next()){
                              String sum = rs.getString("sumprice");
                       jLabelCount.setText(sum);
        }
    }
public void showTable(){
        try{
           
        java.sql.Connection con = ketNoi();
        PreparedStatement ps = con.prepareStatement("SELECT cs.id_chamsoc, cs.idnhanvien_chamsoc, "
                + "nv.fullname_nhanvien, cs.id_datlich, dl.id_khachhang, kh.ten_khachhang, "
                + "dl.id_thucung_datlich, tc.name_thucung, tc.loaidongvat_thucung, "
                + "dl.trieuchung_datlich, cs.cachchua_chamsoc, cs.thoigiankethuc_chamsoc, "
                + "cs.price_chamsoc, cs.sendemail from chamsoc AS cs "
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
        tm.setRowCount(0);
        while(rs.next()){
            Object o[]={rs.getInt("cs.id_chamsoc"), rs.getInt("cs.idnhanvien_chamsoc"), 
                rs.getString("nv.fullname_nhanvien"), rs.getInt("cs.id_datlich"), 
                rs.getInt("dl.id_khachhang"), rs.getString("kh.ten_khachhang"), 
                rs.getInt("dl.id_thucung_datlich"), rs.getString("tc.name_thucung"), 
                rs.getString("tc.loaidongvat_thucung"), 
                rs.getString("dl.trieuchung_datlich"), 
                rs.getString("cs.cachchua_chamsoc"), 
                rs.getString("cs.thoigiankethuc_chamsoc"),
                rs.getInt("cs.price_chamsoc"),
                rs.getString("cs.sendemail")};
            tm.addRow(o);
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButtonDelete = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();
        jButtonAdd = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();
        jLabelNameWel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelAVGMoney = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelTotalMoney = new javax.swing.JLabel();
        jLabelCount = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        choiceIDChamSoc = new java.awt.Choice();
        jButtonSendEmail = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldToEmail = new javax.swing.JTextField();
        jLabelDatLich = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "ID nhân viên", "tên nhân viên", "id đặt lịch", "id khách hàng", "tên khách hàng", "id thú cưng", "tên thú cưng", "loài động vật", "triệu chưng", "cách chữa", "thời gian kết thúc chăm sóc", "giá tiền chăm sóc", "TT gửi email"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.setBackground(new java.awt.Color(54, 33, 89));

        jButtonDelete.setBackground(new java.awt.Color(255, 102, 102));
        jButtonDelete.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jButtonDelete.setText("Xóa lịch chăm sóc");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonEdit.setBackground(new java.awt.Color(255, 255, 153));
        jButtonEdit.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jButtonEdit.setText("Sửa lịch chăm sóc");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });

        jButtonAdd.setBackground(new java.awt.Color(153, 255, 153));
        jButtonAdd.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jButtonAdd.setForeground(new java.awt.Color(51, 51, 51));
        jButtonAdd.setText("thêm lịch chăm sóc");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

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
        jLabel1.setText("Trung bình số tiền:");

        jLabelAVGMoney.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jLabelAVGMoney.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tổng số tiền: ");

        jLabelTotalMoney.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jLabelTotalMoney.setForeground(new java.awt.Color(255, 255, 255));

        jLabelCount.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jLabelCount.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Số lượng thông tin:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ID");

        choiceIDChamSoc.setFont(new java.awt.Font("Dialog", 0, 32)); // NOI18N

        jButtonSendEmail.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jButtonSendEmail.setText("Gửi");
        jButtonSendEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendEmailActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Gửi email");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("nhập email khách hàng");

        jTextFieldToEmail.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N

        jLabelDatLich.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jLabelDatLich.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("ID đặt lịch");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelTotalMoney, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelAVGMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(jButtonSendEmail))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonDelete)
                                    .addComponent(jButtonEdit)))
                            .addComponent(jButtonAdd))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(choiceIDChamSoc, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNameWel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelDatLich, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextFieldToEmail)
                        .addGap(79, 79, 79))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(jLabelNameWel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonAdd)
                .addGap(38, 38, 38)
                .addComponent(jButtonEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addComponent(choiceIDChamSoc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldToEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonSendEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelCount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabelTotalMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelAVGMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelDatLich, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(110, 89, 222));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 37)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Chăm Sóc/Xem Chăm Sóc");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 54)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Thông tin chăm sóc");

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
                .addContainerGap(860, Short.MAX_VALUE))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        // TODO add your handling code here:
        new Frame_Employee_Options().setVisible(true);
        dispose();
        
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        // TODO add your handling code here:
       new Frame_TimeCare_Add().setVisible(true);
        dispose(); 
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        // TODO add your handling code here:
         new Frame_TimeCare_Edit().setVisible(true);
        dispose();
       
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
        new Frame_TimeCare_Delete().setVisible(true);
        dispose(); 
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
         int index=jTable1.getSelectedRow();
             TableModel model=jTable1.getModel();
        choiceIDChamSoc.select(model.getValueAt(index, 0).toString());
        jLabelDatLich.setText(model.getValueAt(index, 3).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButtonSendEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSendEmailActionPerformed
        // TODO add your handling code here:
        int index=jTable1.getSelectedRow();
                TableModel model=jTable1.getModel();
        String ID = model.getValueAt(index, 0).toString();
        String ID_nhanvien = model.getValueAt(index, 1).toString();
        String Ten_nhanvien = model.getValueAt(index, 2).toString();
        String ID_datlich = model.getValueAt(index, 3).toString();
        String ID_khach = model.getValueAt(index, 4).toString();
        String tenkhachhang = model.getValueAt(index, 5).toString();
        String ID_thucung = model.getValueAt(index, 6).toString();
        String tenthucung = model.getValueAt(index, 7).toString();
        String loaidongvat = model.getValueAt(index, 8).toString();
        String trieuchung = model.getValueAt(index, 9).toString();
        String cachchua = model.getValueAt(index, 10).toString();
        String thoigianketthuc_chamsoc = model.getValueAt(index, 11).toString();
        String giatien = model.getValueAt(index, 12).toString();
        
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
        // them cac phan tu vao hashMap
        hashMap.put(1, ID);
        hashMap.put(2, ID_nhanvien);
        hashMap.put(3, Ten_nhanvien);
        hashMap.put(4, ID_datlich);
        hashMap.put(5, ID_khach);
        hashMap.put(6, tenkhachhang);
        hashMap.put(7, ID_thucung);
        hashMap.put(8, tenthucung);
        hashMap.put(9, loaidongvat);
        hashMap.put(10, trieuchung);
        hashMap.put(11, cachchua);
        hashMap.put(12, thoigianketthuc_chamsoc);
        hashMap.put(13, giatien);
        
      String ToEmail = jTextFieldToEmail.getText();
        String FromEmail = "tranhaiphong2016fpt@gmail.com";//studyviral2@gmail.com
        String FromEmailPassword = "<anhdangshit>27854";//You email Password from you want to send email
        String Subjects = "hóa đơn đặt lịch";
        
       Properties properties = new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        
      PasswordAuthentication Auth = new PasswordAuthentication(FromEmail, FromEmailPassword);
        Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() 
        {
            protected PasswordAuthentication getPasswordAuthentication() {
                return Auth;
            }
        });
        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(FromEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(ToEmail));
            message.setSubject(Subjects);
            message.setText(String.valueOf(hashMap));
            Transport.send(message);
        }catch(Exception ex){
            System.out.println(""+ex);
        }
    }//GEN-LAST:event_jButtonSendEmailActionPerformed
 
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
            java.util.logging.Logger.getLogger(Frame_TimeCare_Information.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_TimeCare_Information.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_TimeCare_Information.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_TimeCare_Information.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_TimeCare_Information().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Choice choiceIDChamSoc;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonSendEmail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelAVGMoney;
    private javax.swing.JLabel jLabelCount;
    private javax.swing.JLabel jLabelDatLich;
    private javax.swing.JLabel jLabelNameWel;
    private javax.swing.JLabel jLabelTotalMoney;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldToEmail;
    // End of variables declaration//GEN-END:variables
}
