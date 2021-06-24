package AdminPanel;

import Database.DBoperations;
import Database.Kullanicilar;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class KullaniciSil extends javax.swing.JPanel {

    
    public KullaniciSil() {
        initComponents();
        jScrollPane1.setVisible(false);
        btnSil.setVisible(false);
    }

    
    @SuppressWarnings("unchecked")
    
    private void initComponents() {
        lbDeleteUser = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tfBilgi = new javax.swing.JTextField();
        btnAra = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbKullaniciListe = new javax.swing.JTable();
        btnSil = new javax.swing.JButton();

        setBackground(new java.awt.Color(112, 131, 154));
        setPreferredSize(new java.awt.Dimension(680, 570));
        setLayout(null);

        lbDeleteUser.setIcon(new javax.swing.ImageIcon("/home/clepz/Pictures/remove-user-100.png")); 
        add(lbDeleteUser);
        lbDeleteUser.setBounds(50, 30, 100, 100);

        jLabel1.setFont(new java.awt.Font("Arial", 3, 36)); 
        jLabel1.setText("      KULLANICI SİL");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabel1);
        jLabel1.setBounds(170, 40, 420, 80);
        add(tfBilgi);
        tfBilgi.setBounds(270, 170, 125, 40);

        btnAra.setText("ARA");
        btnAra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btnAraIslemler();
            }
        });
        add(btnAra);
        btnAra.setBounds(460, 170, 70, 40);

        jLabel3.setText("Adı veya Kullanıcı Adını giriniz : ");
        add(jLabel3);
        jLabel3.setBounds(20, 160, 250, 50);

        jScrollPane1.setBackground(new java.awt.Color(110, 130, 151));
        tbKullaniciListe.setBackground(new java.awt.Color(110, 130, 151));
        tbKullaniciListe.setFont(new java.awt.Font("Arial", 1, 16));
        tbKullaniciListe.setRowHeight(25);
        tbKullaniciListe.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "ID", "Kullanıcı Adı", "Parola", "Yetki", "Adı", "Soyadı", "Telefon"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbKullaniciListe);
        if (tbKullaniciListe.getColumnModel().getColumnCount() > 0) {
            tbKullaniciListe.getColumnModel().getColumn(0).setResizable(false);
            tbKullaniciListe.getColumnModel().getColumn(0).setPreferredWidth(10);
            tbKullaniciListe.getColumnModel().getColumn(1).setResizable(false);
            tbKullaniciListe.getColumnModel().getColumn(2).setResizable(false);
            tbKullaniciListe.getColumnModel().getColumn(3).setResizable(false);
            tbKullaniciListe.getColumnModel().getColumn(4).setResizable(false);
            tbKullaniciListe.getColumnModel().getColumn(5).setResizable(false);
            tbKullaniciListe.getColumnModel().getColumn(6).setResizable(false);
        }

        add(jScrollPane1);
        jScrollPane1.setBounds(10, 230, 660, 240);

        btnSil.setBackground(new java.awt.Color(118, 12, 5));
        btnSil.setText("SİL");
        btnSil.setForeground(Color.WHITE);
        btnSil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btnSilIslemler();
            }
        });
        add(btnSil);
        btnSil.setBounds(540, 480, 120, 50);
    }

    private void btnSilIslemler() {
        int i = tbKullaniciListe.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tbKullaniciListe.getModel();
        Object id = model.getValueAt(i,0);
        DBoperations dBoperations = DBoperations.createDBoperations();
        if(dBoperations.kullaniciSil(Integer.valueOf(id.toString()))){
            dBoperations.close();
            JOptionPane.showMessageDialog(null,"Silme Başarılı.");
            model.removeRow(i);
            tbKullaniciListe.revalidate();
            tbKullaniciListe.repaint();
            return;
        }
        JOptionPane.showMessageDialog(null,"Silme Sırasında Bir Hata Oluştu.");

    }

    private void btnAraIslemler() {
        DBoperations dBoperations = DBoperations.createDBoperations();
        ArrayList<Kullanicilar> liste = dBoperations.kullaniciVeriAl(tfBilgi.getText());
        dBoperations.close();
        DefaultTableModel model = (DefaultTableModel) tbKullaniciListe.getModel();
        model.getDataVector().removeAllElements();
        tbKullaniciListe.revalidate();
        tbKullaniciListe.repaint();
        while(!liste.isEmpty()){
            Kullanicilar kisi = liste.remove(0);
            model.addRow(new Object[]{kisi.getId(),kisi.getKullaniciAdi(),kisi.getParola(),kisi.getYetki(),kisi.getAd(),kisi.getSoyad(),kisi.getTelefon()});
        }
        jScrollPane1.setVisible(true);
        btnSil.setVisible(true);
    }


    private javax.swing.JButton btnAra;
    private javax.swing.JButton btnSil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbDeleteUser;
    private javax.swing.JTable tbKullaniciListe;
    private javax.swing.JTextField tfBilgi;
    
}
