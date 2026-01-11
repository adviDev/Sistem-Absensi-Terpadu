package view;

import dao.mahasiswaDAO;
import java.awt.Cursor;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.mahasiswa;



public class Absen extends javax.swing.JFrame {
    String nip;
    String kelas;
    String matkul;
    String idKelas;
    int currentIdSesi;
    public Absen(String  nip, String idKelas, String matkul, String kelas, int idSesi) {
        setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        initbutton();
        this.nip=nip;
        this.matkul=matkul;
        this.kelas=kelas;
        this.idKelas=idKelas;
        this.currentIdSesi=idSesi;
        LketPertemuan.setText(null);
        LketMatkul1.setText(matkul);
        LketKelas.setText(kelas);   
        initTableListener();
        tampilDaftarMahasiswa();
       
    } //end of constructor
    
public void tampilDaftarMahasiswa() {
        // Kita mendefinisikan ulang Model Tabel agar kolom Checkbox BISA DIKLIK (true)
        // Kolom 0 (NIM) & 1 (Nama) -> false (Tidak bisa diedit)
        // Kolom 2,3,4,5 (Checkbox) -> true (Bisa diedit/diklik)
        
        DefaultTableModel model = new DefaultTableModel(
            new Object [][] {},
            new String [] {"Nim", "Nama", "H", "S", "I", "A"}
        ) {
            // Tipe data kolom (Penting agar tampil sebagai Checkbox)
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, 
                java.lang.Boolean.class, java.lang.Boolean.class, 
                java.lang.Boolean.class, java.lang.Boolean.class
            };
            
            // Pengaturan Edit: NIM & Nama (False), Checkbox (True)
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true 
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };

        tbllist.setModel(model); // Set model baru ke tabel

        // --- MULAI ISI DATA ---
        dao.mahasiswaDAO dao = new mahasiswaDAO();
        List<model.mahasiswa> dataSiswa = dao.getMahasiswaByKelas(idKelas);
        
        for (mahasiswa m : dataSiswa) {
            Object[] row = {
                m.getNim(),
                m.getNama(),
                false, // Default H kosong
                false, // Default S kosong
                false, // Default I kosong
                false  // Default A kosong
            };
            model.addRow(row);
        }
        aturLebarKolom();
        initTableListener();
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
    cbhadirs.setContentAreaFilled(false);
    cbhadirs.setFocusPainted(false);
    cbhadirs.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
        cbhadirs = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        LPertemuan = new javax.swing.JLabel();
        btnsimpan = new javax.swing.JButton();
        LketPertemuan = new javax.swing.JLabel();
        LMatkul = new javax.swing.JLabel();
        btnTutupSesi = new javax.swing.JButton();
        Lkelas1 = new javax.swing.JLabel();
        LketKelas = new javax.swing.JLabel();
        LketMatkul1 = new javax.swing.JLabel();

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

        cbhadirs.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        cbhadirs.setForeground(new java.awt.Color(255, 255, 255));
        cbhadirs.setText("Tandai Hadir Semua");
        cbhadirs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbhadirsActionPerformed(evt);
            }
        });
        jPanel2.add(cbhadirs);
        cbhadirs.setBounds(610, 170, 170, 20);

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ABSEN");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(510, 40, 80, 16);

        LPertemuan.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        LPertemuan.setForeground(new java.awt.Color(255, 255, 255));
        LPertemuan.setText("Pertemuan            :");
        jPanel2.add(LPertemuan);
        LPertemuan.setBounds(260, 70, 130, 19);

        btnsimpan.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnsimpan.setText("Simpan Absensi");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });
        jPanel2.add(btnsimpan);
        btnsimpan.setBounds(530, 400, 140, 26);

        LketPertemuan.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        LketPertemuan.setForeground(new java.awt.Color(255, 255, 255));
        LketPertemuan.setText("Kelas");
        jPanel2.add(LketPertemuan);
        LketPertemuan.setBounds(400, 70, 370, 19);

        LMatkul.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        LMatkul.setForeground(new java.awt.Color(255, 255, 255));
        LMatkul.setText("Mata Kuliah           :");
        jPanel2.add(LMatkul);
        LMatkul.setBounds(260, 110, 130, 16);

        btnTutupSesi.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnTutupSesi.setText("Tutup Sesi");
        btnTutupSesi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTutupSesiActionPerformed(evt);
            }
        });
        jPanel2.add(btnTutupSesi);
        btnTutupSesi.setBounds(690, 400, 120, 26);

        Lkelas1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        Lkelas1.setForeground(new java.awt.Color(255, 255, 255));
        Lkelas1.setText("Kelas                     :");
        jPanel2.add(Lkelas1);
        Lkelas1.setBounds(260, 150, 130, 19);

        LketKelas.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        LketKelas.setForeground(new java.awt.Color(255, 255, 255));
        LketKelas.setText("Kelas");
        jPanel2.add(LketKelas);
        LketKelas.setBounds(400, 150, 370, 19);

        LketMatkul1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        LketMatkul1.setForeground(new java.awt.Color(255, 255, 255));
        LketMatkul1.setText("Kelas");
        jPanel2.add(LketMatkul1);
        LketMatkul1.setBounds(400, 110, 370, 19);

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

    }//GEN-LAST:event_btnabsenActionPerformed

    private void btnrekapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrekapActionPerformed
    
    }//GEN-LAST:event_btnrekapActionPerformed

    private void btnhomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhomeActionPerformed
            // TODO add your handling code here:
    }//GEN-LAST:event_btnhomeActionPerformed

    private void cbhadirsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbhadirsActionPerformed
        boolean isChecked = cbhadirs.isSelected();
        int rows = tbllist.getRowCount();
        
        for (int i = 0; i < rows; i++) {
            
            tbllist.setValueAt(isChecked, i, 2); 
            
            
            if (!isChecked) {
                 tbllist.setValueAt(false, i, 3);
                 tbllist.setValueAt(false, i, 4);
                 tbllist.setValueAt(false, i, 5);
            }
        }
    }//GEN-LAST:event_cbhadirsActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
try {
            dao.absensiDAO aDAO = new dao.absensiDAO();

            int rows = tbllist.getRowCount();
            int countSimpan = 0;
            
            for (int i = 0; i < rows; i++) {
                String nim = tbllist.getValueAt(i, 0).toString();
                
                // Ambil status checkbox (H/S/I/A)
                boolean h = (boolean) tbllist.getValueAt(i, 2);
                boolean s = (boolean) tbllist.getValueAt(i, 3);
                boolean i_zin = (boolean) tbllist.getValueAt(i, 4);
                boolean a = (boolean) tbllist.getValueAt(i, 5);
                
                String status = "Alpa"; 
                if (h) status = "Hadir";
                else if (s) status = "Sakit";
                else if (i_zin) status = "Izin";
                else if (a) status = "Alpa";
                
                // Simpan Detail Absensi menggunakan currentIdSesi
                aDAO.simpanDetailAbsensi(this.currentIdSesi, nim, status);
                countSimpan++;
            }
            
            JOptionPane.showMessageDialog(this, "Berhasil menyimpan data absensi!");
            btnsimpan.setEnabled(false); // Matikan tombol agar tidak double input
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error simpan: " + e.getMessage());
        }
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btnTutupSesiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTutupSesiActionPerformed
        // TODO add your handling code here:
        // Jika user langsung klik tutup tanpa simpan, konfirmasi dulu
        if (currentIdSesi == 0) {
            int confirm = JOptionPane.showConfirmDialog(this, "Anda belum menyimpan absensi. Yakin ingin keluar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                new MenuDosen(this.nip).setVisible(true);
                this.dispose();
            }
        } else {
            // Update status sesi jadi 'Selesai'
            dao.absensiDAO aDAO = new dao.absensiDAO();
            aDAO.tutupSesi(currentIdSesi);
            
            JOptionPane.showMessageDialog(this, "Sesi ditutup. Terima kasih.");
            new MenuDosen(this.nip).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnTutupSesiActionPerformed


private void initTableListener() {
        
        tbllist.getModel().addTableModelListener(new javax.swing.event.TableModelListener() {
            @Override
            public void tableChanged(javax.swing.event.TableModelEvent e) {
                if (e.getType() == javax.swing.event.TableModelEvent.UPDATE) {
                    int row = e.getFirstRow();
                    int col = e.getColumn();

                    if (row >= 0 && col >= 2 && col <= 5) {
                        DefaultTableModel model = (DefaultTableModel) tbllist.getModel();
                        Boolean isChecked = (Boolean) model.getValueAt(row, col);

                        if (isChecked) {
                            javax.swing.SwingUtilities.invokeLater(() -> {
                                if (col != 2) model.setValueAt(false, row, 2); // Uncheck H
                                if (col != 3) model.setValueAt(false, row, 3); // Uncheck S
                                if (col != 4) model.setValueAt(false, row, 4); // Uncheck I
                                if (col != 5) model.setValueAt(false, row, 5); // Uncheck A
                            });
                        }
                    }
                }
            }
        });
    }

    
    private void aturLebarKolom() {
        
        int checkboxWidth = 30; 
        for (int i = 2; i <= 5; i++) {
            javax.swing.table.TableColumn column = tbllist.getColumnModel().getColumn(i);
            column.setMinWidth(checkboxWidth);
            column.setMaxWidth(checkboxWidth);
            column.setPreferredWidth(checkboxWidth);
        }
        for (int i = 0; i <= 1; i++) { 
            javax.swing.table.TableColumn column = tbllist.getColumnModel().getColumn(i);
            int preferredWidth = column.getMinWidth();
            int maxWidth = 300; 
            javax.swing.table.TableCellRenderer headerRenderer = tbllist.getTableHeader().getDefaultRenderer();
            java.awt.Component headerComp = headerRenderer.getTableCellRendererComponent(tbllist, column.getHeaderValue(), false, false, 0, i);
            preferredWidth = Math.max(preferredWidth, headerComp.getPreferredSize().width);

            for (int row = 0; row < tbllist.getRowCount(); row++) {
                javax.swing.table.TableCellRenderer cellRenderer = tbllist.getCellRenderer(row, i);
                java.awt.Component c = tbllist.prepareRenderer(cellRenderer, row, i);
                int width = c.getPreferredSize().width + tbllist.getIntercellSpacing().width;
                preferredWidth = Math.max(preferredWidth, width);
            }

            preferredWidth += 10; 

            column.setPreferredWidth(Math.min(preferredWidth, maxWidth));
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


//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Absen().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LMatkul;
    private javax.swing.JLabel LPertemuan;
    private javax.swing.JLabel Lkelas1;
    private javax.swing.JLabel LketKelas;
    private javax.swing.JLabel LketMatkul1;
    private javax.swing.JLabel LketPertemuan;
    private javax.swing.JButton btnTutupSesi;
    private javax.swing.JButton btnabsen;
    private javax.swing.JButton btnhome;
    private javax.swing.JButton btnrekap;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JCheckBox cbhadirs;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbllist;
    // End of variables declaration//GEN-END:variables
}
