/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ayu Arum
 */

import Koneksi.koneksiDB;
import java.sql.*;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class form_utama extends javax.swing.JFrame {
    String user;
    String pass;
    String level;
    ResultSet Data;
    String hasil;
    /**
     * Creates new form form_utama
     */
    public form_utama() {
        initComponents();
        this.pack();
        this.setSize(500,340);
        this.setLocationRelativeTo(null);
        jPanel1.hide();
    }
    
    public String CekLogin(){
        if (user.isEmpty() || pass.isEmpty()){
            return "Form belum lengkap";
        } else {
            try{
                Statement stat = koneksiDB.getKoneksi().createStatement();
                Data = stat.executeQuery("select * from login where username='"+user+"' and password='"+pass+"'");
            if (Data.next()){
                level = Data.getString("level");
                return level;
            } else {
                return "Gagal login";
            }   
            } catch (SQLException salahe){
                return "Kesalahan : "+salahe;
            }
        }
    }
    
    public void admin(){
        cmdKaryawan.setEnabled(true);
        cmdKategori.setEnabled(true);
        cmdProduk.setEnabled(true);
        cmdTransaksi.setEnabled(false);
        cmdLaporan.setEnabled(true);
        lpkategori.setEnabled(true);
        lpobat.setEnabled(true);
        lppenjualan.setEnabled(true);
    }
    public void kasir(){
        cmdKaryawan.setEnabled(false);
        cmdKategori.setEnabled(false);
        cmdProduk.setEnabled(false);
        cmdTransaksi.setEnabled(true);
        cmdLaporan.setEnabled(false);
        lpkategori.setEnabled(false);
        lpobat.setEnabled(false);
        lppenjualan.setEnabled(true);
        
    }
    public void login(){
        user = username.getText();
        pass = password.getText();
        hasil = CekLogin();
        if (hasil.equals("admin")) {
            jPanel2.hide();
            jPanel1.show();
            admin();
            JOptionPane.showMessageDialog(null, "Selamat Datang Admin");
            /*this.dispose();
            new formUtama().setVisible(true);*/
        } else if(hasil.equals("kasir")){
            jPanel2.hide();
            jPanel1.show();
            kasir();
            JOptionPane.showMessageDialog(null, "Selamat Datang Kasir");
        } else {
            JOptionPane.showMessageDialog(null, hasil);
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

        jPanel1 = new javax.swing.JPanel();
        cmdProduk = new javax.swing.JButton();
        cmdTransaksi = new javax.swing.JButton();
        cmdLaporan = new javax.swing.JButton();
        cmdKeluar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmdKaryawan = new javax.swing.JButton();
        labelJudul = new javax.swing.JLabel();
        cmdKategori = new javax.swing.JButton();
        lpkategori = new javax.swing.JButton();
        lpobat = new javax.swing.JButton();
        lppenjualan = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 102));

        cmdProduk.setText("OBAT");
        cmdProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdProdukActionPerformed(evt);
            }
        });

        cmdTransaksi.setText("PENJUALAN");
        cmdTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdTransaksiActionPerformed(evt);
            }
        });

        cmdLaporan.setText("KARYAWAN");
        cmdLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLaporanActionPerformed(evt);
            }
        });

        cmdKeluar.setText("KELUAR");
        cmdKeluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmdKeluarMouseClicked(evt);
            }
        });
        cmdKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdKeluarActionPerformed(evt);
            }
        });

        jLabel1.setText("MASTER");

        jLabel2.setText("TRANSAKSI");

        jLabel3.setText("LAPORAN");

        cmdKaryawan.setText("KARYAWAN");
        cmdKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdKaryawanActionPerformed(evt);
            }
        });

        labelJudul.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        labelJudul.setText("SISTEM PENJUALAN APOTEK SUMBER WARAS");

        cmdKategori.setText("KATEGORI");
        cmdKategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmdKategoriMouseClicked(evt);
            }
        });

        lpkategori.setText("KATEGORI");
        lpkategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lpkategoriActionPerformed(evt);
            }
        });

        lpobat.setText("OBAT");
        lpobat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lpobatActionPerformed(evt);
            }
        });

        lppenjualan.setText("PENJUALAN");
        lppenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lppenjualanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(jLabel1)
                            .addGap(70, 70, 70)
                            .addComponent(jLabel2)
                            .addGap(51, 51, 51)
                            .addComponent(jLabel3))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cmdProduk, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmdKategori, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmdKaryawan))
                            .addGap(28, 28, 28)
                            .addComponent(cmdTransaksi)
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lppenjualan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lpobat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lpkategori, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmdLaporan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addComponent(cmdKeluar)))
                    .addComponent(labelJudul))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelJudul)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdTransaksi)
                    .addComponent(cmdLaporan)
                    .addComponent(cmdKaryawan)
                    .addComponent(cmdKeluar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdKategori)
                    .addComponent(lpkategori))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdProduk)
                    .addComponent(lpobat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lppenjualan)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(51, 255, 255));

        jLabel4.setText("LOGIN");

        jLabel5.setText("USERNAME");

        jLabel6.setText("PASSWORD");

        jButton4.setText("LOGIN");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton1.setText("BATAL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGap(70, 70, 70)
                            .addComponent(jButton4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                            .addComponent(jButton1))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGap(38, 38, 38)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6))
                            .addGap(40, 40, 40)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                .addComponent(password)))))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel4)
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton1))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdKategoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdKategoriMouseClicked
        new form_kategori().setVisible(true);
    }//GEN-LAST:event_cmdKategoriMouseClicked

    private void cmdProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdProdukActionPerformed
        new form_obat().setVisible(true);
    }//GEN-LAST:event_cmdProdukActionPerformed

    private void cmdTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdTransaksiActionPerformed
        new form_transaksi().setVisible(true);
    }//GEN-LAST:event_cmdTransaksiActionPerformed

    private void cmdLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLaporanActionPerformed
        try {
        JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("LapKaryawan.jasper"), null, koneksiDB.getKoneksi());
        JasperViewer.viewReport(jp, false);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }  
    }//GEN-LAST:event_cmdLaporanActionPerformed

    private void cmdKeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdKeluarMouseClicked
        
    }//GEN-LAST:event_cmdKeluarMouseClicked

    private void cmdKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdKeluarActionPerformed
        // TODO add your handling code here:
        jPanel1.hide();
        jPanel2.show();
    }//GEN-LAST:event_cmdKeluarActionPerformed

    private void cmdKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdKaryawanActionPerformed
        new form_karyawan().setVisible(true);
    }//GEN-LAST:event_cmdKaryawanActionPerformed

    private void lpkategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lpkategoriActionPerformed
        try {
        JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("LapKategori.jasper"), null, koneksiDB.getKoneksi());
        JasperViewer.viewReport(jp, false);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_lpkategoriActionPerformed

    private void lpobatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lpobatActionPerformed
        try {
        JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("LapObat.jasper"), null, koneksiDB.getKoneksi());
        JasperViewer.viewReport(jp, false);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_lpobatActionPerformed

    private void lppenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lppenjualanActionPerformed
        try {
        JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("LapTransaksiPenjualan.jasper"), null, koneksiDB.getKoneksi());
        JasperViewer.viewReport(jp, false);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_lppenjualanActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        login();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        username.setText("");
        password.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(form_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                form_utama FL = new form_utama();
                /*FL.pack();
                FL.setSize(370, 280);
                FL.setLocationRelativeTo(null);*/
                FL.setVisible(true);
                FL.jPanel1.hide();
                FL.jPanel2.show();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdKaryawan;
    private javax.swing.JButton cmdKategori;
    private javax.swing.JButton cmdKeluar;
    private javax.swing.JButton cmdLaporan;
    private javax.swing.JButton cmdProduk;
    private javax.swing.JButton cmdTransaksi;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelJudul;
    private javax.swing.JButton lpkategori;
    private javax.swing.JButton lpobat;
    private javax.swing.JButton lppenjualan;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
