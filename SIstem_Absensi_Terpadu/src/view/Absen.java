package view;

import java.awt.Cursor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import config.koneksi;
import dao.mahasiswaDAO;
import java.awt.Component;
import model.mahasiswa;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class Absen extends javax.swing.JFrame {

    public Absen() {
        setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        initbutton();
        // Asumsikan nama variabel tabel Anda adalah jtAbsensi
    tbllist.setModel(new javax.swing.table.DefaultTableModel(
    new Object [][] {},
    new String [] {
        "Nim", "Nama", "H", "I", "A", "S"
    }
    ) {
    // Memberitahu tabel bahwa kolom index 2-5 adalah Boolean (Checkbox)
    Class[] types = new Class [] {
        java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, 
        java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class
    };

    @Override
    public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
    }

    // Pastikan kolom checkbox bisa diedit
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex >= 2; // Kolom NIM dan Nama tidak bisa diedit
    }
    });
    tbllist.getModel().addTableModelListener(new javax.swing.event.TableModelListener() {
    private boolean isUpdating = false;

    @Override
    public void tableChanged(javax.swing.event.TableModelEvent e) {
        if (isUpdating) return; // Mencegah loop tak terbatas saat memperbarui data

        int row = e.getFirstRow();
        int column = e.getColumn();

        // Pastikan perubahan terjadi pada kolom H, I, A, atau S (index 2-5)
        if (column >= 2 && column <= 5) {
            DefaultTableModel model = (DefaultTableModel) tbllist.getModel();
            Boolean checked = (Boolean) model.getValueAt(row, column);

            if (checked) {
                isUpdating = true;
                // Matikan checkbox lain di baris yang sama
                for (int i = 2; i <= 5; i++) {
                    if (i != column) {
                        model.setValueAt(false, row, i);
                    }
                }
                isUpdating = false;
            }
        }
    }
});

    }
    private void initbutton(){
    btnrekap.setContentAreaFilled(false);
    btnrekap.setFocusPainted(false);
    btnrekap.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
    btnabsen.setContentAreaFilled(false);
    btnabsen.setFocusPainted(false);
    btnabsen.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
    btnhome.setContentAreaFilled(false);
    btnhome.setFocusPainted(false);
    btnhome.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnhome = new javax.swing.JButton();
        btnabsen = new javax.swing.JButton();
        btnrekap = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbllist = new javax.swing.JTable();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbperte = new javax.swing.JComboBox<>();
        btnsimpan = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbKelas = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/icons8-close-32.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1);
        jLabel1.setBounds(790, 20, 32, 29);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        btnhome.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnhome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/home.png"))); // NOI18N
        btnhome.setText("Home");
        btnhome.setToolTipText("");
        btnhome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnhome.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnhome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhomeActionPerformed(evt);
            }
        });
        jPanel1.add(btnhome);
        btnhome.setBounds(20, 140, 180, 60);

        btnabsen.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnabsen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/icons8-notebook-50.png"))); // NOI18N
        btnabsen.setText("Absen");
        btnabsen.setToolTipText("");
        btnabsen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnabsen.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnabsen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnabsenActionPerformed(evt);
            }
        });
        jPanel1.add(btnabsen);
        btnabsen.setBounds(20, 250, 180, 60);

        btnrekap.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnrekap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/icons8-notebook-50.png"))); // NOI18N
        btnrekap.setText("Rekap Absen");
        btnrekap.setToolTipText("");
        btnrekap.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnrekap.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnrekap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrekapActionPerformed(evt);
            }
        });
        jPanel1.add(btnrekap);
        btnrekap.setBounds(20, 330, 180, 60);

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setText("E - ABSEN");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(238, 67, 94, 24);

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel3.setText("E - ABSEN");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(60, 70, 90, 24);

        jPanel2.add(jPanel1);
        jPanel1.setBounds(0, 0, 210, 490);

        tbllist.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tbllist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nim", "Nama", "H", "S", "I", "A"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbllist.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbllist);
        if (tbllist.getColumnModel().getColumnCount() > 0) {
            tbllist.getColumnModel().getColumn(0).setResizable(false);
            tbllist.getColumnModel().getColumn(0).setPreferredWidth(3);
            tbllist.getColumnModel().getColumn(1).setResizable(false);
            tbllist.getColumnModel().getColumn(2).setResizable(false);
            tbllist.getColumnModel().getColumn(2).setPreferredWidth(1);
            tbllist.getColumnModel().getColumn(3).setResizable(false);
            tbllist.getColumnModel().getColumn(3).setPreferredWidth(1);
            tbllist.getColumnModel().getColumn(4).setResizable(false);
            tbllist.getColumnModel().getColumn(4).setPreferredWidth(1);
            tbllist.getColumnModel().getColumn(5).setResizable(false);
            tbllist.getColumnModel().getColumn(5).setPreferredWidth(1);
        }

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(300, 220, 470, 160);

        jCheckBox1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jCheckBox1.setText("Tandai Hadir Semua");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox1);
        jCheckBox1.setBounds(620, 70, 170, 20);

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ABSEN");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(510, 40, 80, 16);

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Pertemuan");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(260, 110, 80, 19);

        cbperte.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        cbperte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Minggu 1", "Minggu 2", "MInggu 3", "MInggu 4", "MInggu 5", "MInggu 6", "MInggu 7", "MInggu 8", "MInggu 9", "MInggu 10", "MInggu 11", "MInggu 12", "MInggu 13 ", "MInggu 14", "MInggu 15", "MInggu 16", "MInggu 17" }));
        jPanel2.add(cbperte);
        cbperte.setBounds(350, 110, 108, 25);

        btnsimpan.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnsimpan.setText("Sumbit");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });
        jPanel2.add(btnsimpan);
        btnsimpan.setBounds(720, 400, 90, 26);

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Kelas");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(260, 170, 60, 19);

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Jadwal");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(510, 110, 60, 16);

        cbKelas.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        cbKelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3A TIF", "3B TIF", "3C TIF", "3D TIF", "3E TIF" }));
        cbKelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKelasActionPerformed(evt);
            }
        });
        jPanel2.add(cbKelas);
        cbKelas.setBounds(350, 170, 81, 25);

        jComboBox2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pemograman Visual", "Sistem Operasi", "Manajemen & Organisasi", "Agama", "Bahasa Inggris", "Metode Numerik" }));
        jPanel2.add(jComboBox2);
        jComboBox2.setBounds(580, 110, 170, 25);

        jButton2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButton2.setText("Tampilkan");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(470, 170, 110, 26);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 862, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
    System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void btnabsenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnabsenActionPerformed
        // TODO add your handling code here:
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("NIM");
    model.addColumn("Nama");
    model.addColumn("Angkatan");
    try {
        // Koneksi ke database
        Connection conn = koneksi.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM mahasiswa");
        
        // Ambil data dari database
        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getString("nim"),
                rs.getString("nama_mahasiswa"),
                rs.getString("angkatan")
            });
        }

        // Tampilkan ke JTable
        tbllist.setModel(model);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, 
            "Data gagal ditampilkan\n" + e.getMessage());
    }
    }//GEN-LAST:event_btnabsenActionPerformed

    private void btnrekapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrekapActionPerformed
    new RekapDosen().setVisible(true);
    this.dispose();         // TODO add your handling code here:
    }//GEN-LAST:event_btnrekapActionPerformed

    private void btnhomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhomeActionPerformed
    MenuDosen menu = new MenuDosen(username);
    menu.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_btnhomeActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void cbKelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKelasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbKelasActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
int kelasTerpilih = getidbynama();
        System.out.println("kelas terpilih : "+kelasTerpilih);
// Siapkan tabel
DefaultTableModel model = (DefaultTableModel) tbllist.getModel();
model.setRowCount(0);

// Panggil DAO
mahasiswaDAO dao = new mahasiswaDAO();
List<mahasiswa> listMhs = dao.getMahasiswaByKelas(kelasTerpilih);

// Loop data mahasiswa
for (mahasiswa m : listMhs) {
    Object[] row = {
        m.getNim(),
        m.getNama(),
        false, false, false, false // H, I, A, S
    };
    model.addRow(row);
}
autoResizeKolom(tbllist);


    }//GEN-LAST:event_jButton2ActionPerformed
    private String username;
    public Absen(String username) {
    initComponents();
    this.username = username;
    }
    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
      // 1. Inisialisasi List untuk menampung data
    List<model.detailAbsensi> listAbsen = new ArrayList<>();
    
    // 2. Ambil ID Jadwal (Ganti dengan ID jadwal yang sesuai dari ComboBox atau sistem Anda)
    // Berdasarkan DAO Anda, parameter pertama adalah id_jadwal
    int idJadwal = 1; 

    DefaultTableModel model = (DefaultTableModel) tbllist.getModel();
    
    // 3. Iterasi baris tabel
    for (int i = 0; i < model.getRowCount(); i++) {
        String nim = model.getValueAt(i, 0).toString();
        String status = "";

        // Mapping Checkbox (2:H, 3:I, 4:A, 5:S)
        if ((Boolean) model.getValueAt(i, 2)) status = "hadir";
        else if ((Boolean) model.getValueAt(i, 3)) status = "izin";
        else if ((Boolean) model.getValueAt(i, 4)) status = "alpa";
        else if ((Boolean) model.getValueAt(i, 5)) status = "sakit";

        // 4. Masukkan ke dalam objek Model hanya jika status dipilih
        if (!status.isEmpty()) {
            model.detailAbsensi detail = new model.detailAbsensi();
            detail.setIdDetail(idJadwal); // Di DAO Anda ps.setInt(1) mengambil dari getIdDetail
            detail.setNim(nim);
            detail.setStatusKehadiran(status);
            
            listAbsen.add(detail);
        }
    }

    // 5. Kirim List ke DAO untuk disimpan sekaligus
    if (!listAbsen.isEmpty()) {
        dao.absensiDAO daoAbsen = new dao.absensiDAO();
        daoAbsen.simpanAbsensi(listAbsen);
        JOptionPane.showMessageDialog(this, "Berhasil menyimpan " + listAbsen.size() + " data kehadiran.");
    } else {
        JOptionPane.showMessageDialog(this, "Pilih status kehadiran terlebih dahulu!");
    }
    }//GEN-LAST:event_btnsimpanActionPerformed

    private int getidbynama(){
        String nama = cbKelas.getSelectedItem().toString();
        switch (nama) {
            case "3A TIF": return 1;
            case "3B TIF": return 2;
            case "3C TIF": return 3;
            case "3D TIF": return 4;
            case "3E TIF": return 5;
                
                
            default:return 1;
                
        }
    }
    private void autoResizeKolom(JTable table) {
    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

    for (int column = 0; column < table.getColumnCount(); column++) {
        int width = 50; // lebar minimum

        // Header
        TableColumn col = table.getColumnModel().getColumn(column);
        TableCellRenderer headerRenderer = table.getTableHeader().getDefaultRenderer();
        Component headerComp = headerRenderer.getTableCellRendererComponent(
                table, col.getHeaderValue(), false, false, 0, column);
        width = Math.max(width, headerComp.getPreferredSize().width);

        // Isi sel
        for (int row = 0; row < table.getRowCount(); row++) {
            TableCellRenderer renderer = table.getCellRenderer(row, column);
            Component comp = table.prepareRenderer(renderer, row, column);
            width = Math.max(width, comp.getPreferredSize().width);
        }

        col.setPreferredWidth(width + 10); // padding
    }
}

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
            java.util.logging.Logger.getLogger(Absen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Absen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Absen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Absen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new Absen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnabsen;
    private javax.swing.JButton btnhome;
    private javax.swing.JButton btnrekap;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JComboBox<String> cbKelas;
    private javax.swing.JComboBox<String> cbperte;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbllist;
    // End of variables declaration//GEN-END:variables
}
