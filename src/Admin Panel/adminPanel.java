package AdminPanel;

import main.UserConnection;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class adminPanel extends javax.swing.JFrame implements ActionListener {

    public adminPanel() {
        initComponents();
        setLocationRelativeTo(null);

    }


    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        bCikis = new javax.swing.JButton();
        bKullanicilar = new javax.swing.JButton();
        bKullaniciEkle = new javax.swing.JButton();
        bKullaniciSil = new javax.swing.JButton();
        bKullaniciGuncelle = new javax.swing.JButton();
        bProgramGit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Panel");
        setPreferredSize(new java.awt.Dimension(1000, 600));

        jPanel2.setBackground(new java.awt.Color(45, 76, 184));
        jPanel2.setMaximumSize(new java.awt.Dimension(500, 32767));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 600));

        bCikis.setBackground(java.awt.Color.darkGray);
        bCikis.setForeground(Color.WHITE);
        bCikis.setText("Çıkış");
        bCikis.addActionListener(this);
        bCikis.addActionListener(this);

        bKullanicilar.setBackground(java.awt.Color.darkGray);
        bKullanicilar.setForeground(Color.WHITE);
        bKullanicilar.setText("Kullanıcılar");
        bKullanicilar.addActionListener(this);

        bKullaniciEkle.setBackground(java.awt.Color.darkGray);
        bKullaniciEkle.setForeground(Color.WHITE);
        bKullaniciEkle.addActionListener(this);
        bKullaniciEkle.setText("Yeni Kullanıcı Ekle");

        bKullaniciSil.setBackground(java.awt.Color.darkGray);
        bKullaniciSil.setForeground(Color.WHITE);
        bKullaniciSil.setText("Kullanıcı Sil");
        bKullaniciSil.addActionListener(this);

        bKullaniciGuncelle.setBackground(java.awt.Color.darkGray);
        bKullaniciGuncelle.setForeground(Color.WHITE);
        bKullaniciGuncelle.setText("Kullanıcı Güncelle");
        bKullaniciGuncelle.addActionListener(this);

        bProgramGit.setBackground(java.awt.Color.darkGray);
        bProgramGit.setForeground(Color.WHITE);
        bProgramGit.setText("Kullanıcı Değiştir");
        bProgramGit.addActionListener(this);

        jLabel2.setIcon(new javax.swing.ImageIcon("/home/takoz/Pictures/administrative-tools.png")); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MENÜ");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bProgramGit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bKullaniciGuncelle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bCikis, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bKullanicilar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bKullaniciEkle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bKullaniciSil, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(bKullanicilar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(bKullaniciEkle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(bKullaniciSil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(bKullaniciGuncelle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(bProgramGit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(bCikis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(34, 34, 34))
        );

        jLabel1.getAccessibleContext().setAccessibleName("MENU");

        jPanel3.setBackground(new java.awt.Color(254, 254, 254));
        jPanel3.setPreferredSize(new java.awt.Dimension(700, 600));

        jLabel3.setIcon(new javax.swing.ImageIcon("/home/clepz/Downloads/tarik.png")); // NOI18N
        jLabel3.setAlignmentX(0.5F);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(131, 131, 131)
                                .addComponent(jLabel3)
                                .addContainerGap(163, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(jLabel3)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
 
    private javax.swing.JButton bCikis;
    private javax.swing.JButton bKullaniciEkle;
    private javax.swing.JButton bKullaniciGuncelle;
    private javax.swing.JButton bKullaniciSil;
    private javax.swing.JButton bKullanicilar;
    private javax.swing.JButton bProgramGit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bKullanicilar){
            jPanel3.removeAll();
            javax.swing.JPanel kullanicilar=new kullaniciListe();
            kullanicilar.setSize(680,570);
            jPanel3.add(kullanicilar);
            jPanel3.revalidate();
            jPanel3.repaint();
        }
        else if(e.getSource() == bKullaniciEkle){
            jPanel3.removeAll();
            javax.swing.JPanel kullanicilar=new KullaniciEkle();
            kullanicilar.setSize(680,570);
            jPanel3.add(kullanicilar);
            jPanel3.revalidate();
            jPanel3.repaint();
        }
        else if(e.getSource() == bKullaniciSil){
            jPanel3.removeAll();
            javax.swing.JPanel kullanicilar=new KullaniciSil();
            kullanicilar.setSize(680,570);
            jPanel3.add(kullanicilar);
            jPanel3.revalidate();
            jPanel3.repaint();
        }
        else if(e.getSource() == bKullaniciGuncelle){
            jPanel3.removeAll();
            javax.swing.JPanel kullanicilar=new KullaniciGuncelle();
            kullanicilar.setSize(680,570);
            jPanel3.add(kullanicilar);
            jPanel3.revalidate();
            jPanel3.repaint();

        }
        else if(e.getSource() == bProgramGit){
            this.dispose();
            new UserConnection().setVisible(true);
        }
        else if(e.getSource() == bCikis){
            this.dispose();
        }
    }
}
