package main;


import Database.DBoperations;
import Database.Kullanicilar;
import StokProgrami.StokProgram;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


 
public class UserConnection extends javax.swing.JFrame {

   

    public UserConnection() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        tfkullanici = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfsifre = new javax.swing.JPasswordField();
        girisbuton = new javax.swing.JButton();
        background = new javax.swing.JLabel();
        Font font = new Font("Arial",Font.BOLD,17);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setMinimumSize(new Dimension(1210,800));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("KULLANICI ADI ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(380, 360, 200, 40);

        tfkullanici.setBackground(new java.awt.Color(255, 255, 255));
        tfkullanici.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(tfkullanici);
        tfkullanici.setBounds(380, 400, 540, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panelImage/icons8_Businessman_70px.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(300, 370, 70, 80);

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ŞİFRE");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(380, 480, 130, 40);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panelImage/icons8_Key_70px.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(300, 490, 70, 80);

        tfsifre.setBackground(new java.awt.Color(255, 255, 255));
        tfsifre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(tfsifre);
        tfsifre.setBounds(380, 520, 540, 40);
        tfkullanici.setFont(font);
        tfsifre.setFont(font);
        girisbuton.setBackground(new java.awt.Color(29, 96, 122));
        girisbuton.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        girisbuton.setForeground(new java.awt.Color(255, 255, 255));
        girisbuton.setText("GİRİŞ");
        getContentPane().add(girisbuton);
        girisbuton.setBounds(380, 590, 540, 40);
        girisbuton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int yetki;
                DBoperations baglan = DBoperations.createDBoperations();
                Kullanicilar kullancici = baglan.girisYap(tfkullanici.getText(),tfsifre.getText());
                baglan.close();
                if(kullancici.getYetki().equals("Kullanıcı")){
                    dispose();
                    new StokProgram(kullancici).setVisible(true);
                    return;
                }
                else{
                    dispose();
                    new StokProgram(kullancici).setVisible(true);
                    return;
                }
            }
        });

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/panelImage/tarikbackground.png"))); // NOI18N
        getContentPane().add(background);
        background.setBounds(0, 0, 1210, 800);
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(girisbuton);
        pack();
    }

    private javax.swing.JLabel background;
    private javax.swing.JButton girisbuton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField tfkullanici;
    private javax.swing.JPasswordField tfsifre;
}
