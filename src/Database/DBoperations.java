package Database;

import StokProgrami.UrunIslemleri;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;

public class DBoperations implements UrunIslemleri {
    private static DBoperations dBoperations;
    private static final String url = "jdbc:mysql://localhost:3306/stokTakip?autoReconnect=true&useSSL=false";
    private static final String user = "root";
    private static final String password = "root";
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;


    private DBoperations() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.getConnection();
    }

    public static DBoperations createDBoperations() {
        if (dBoperations != null)
            return dBoperations;
        return new DBoperations();
    }

    private void getConnection()  {
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Bağlantı Sağlanamadı Tekrar Deneyiniz.");
        }

    }
    public Kullanicilar girisYap(String id , String parola ) {
        Kullanicilar kisi = new Kullanicilar();
        try {
            resultSet = statement.executeQuery("SELECT * FROM yonetici where yonetici_adi = '"+id+"'");
            if(!resultSet.next()) {
                JOptionPane.showMessageDialog(null, "Hatali Giris Yaptiniz Tekrar Deneyiniz.");
                return null;
            }
            if (!(resultSet.getString("yonetici_sifre").equals(parola))){
                JOptionPane.showMessageDialog(null, "Hatali Giris Yaptiniz Tekrar Deneyiniz.");
                return null;
            }
            kisi.setId(resultSet.getInt(1));
            kisi.setKullaniciAdi(resultSet.getString(2));
            kisi.setParola(resultSet.getString(3));
            kisi.setYetki(resultSet.getInt(4));
            kisi.setAd(resultSet.getString(5));
            kisi.setSoyad(resultSet.getString(6));
            kisi.setTelefon(resultSet.getString(7));



        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Bir hata oluştu daha sonra tekrar deneyiniz.");
        }
        finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Bir hata oluştu");
            }
        }
        return kisi;
    }

    public ArrayList<Kullanicilar> kullaniciVeriAl(){
        ArrayList<Kullanicilar> liste = new ArrayList<>();
        try {
            resultSet = statement.executeQuery("SELECT * FROM yonetici");
            while (resultSet.next()){
                Kullanicilar kisi = new Kullanicilar();
                kisi.setId(resultSet.getInt(1));
                kisi.setKullaniciAdi(resultSet.getString(2));
                kisi.setParola(resultSet.getString(3));
                kisi.setYetki(resultSet.getInt(4));
                kisi.setAd(resultSet.getString(5));
                kisi.setSoyad(resultSet.getString(6));
                kisi.setTelefon(resultSet.getString(7));
                liste.add(kisi);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Bir hata oluştu. Daha sonra tekrar deneyiniz.");
        }
        finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Bir hata oluştu. Daha sonra tekrar deneyiniz.");
            }
        }
        return liste;

    }
    public ArrayList<Kullanicilar> kullaniciVeriAl(String bilgi){
        ArrayList<Kullanicilar> liste = new ArrayList<>();
        try {
            resultSet = statement.executeQuery("SELECT * FROM yonetici WHERE yonetici_adi = '"+bilgi+"' or ad = '"+bilgi+"'");
            while (resultSet.next()){
                Kullanicilar kisi = new Kullanicilar();
                kisi.setId(resultSet.getInt(1));
                kisi.setKullaniciAdi(resultSet.getString(2));
                kisi.setParola(resultSet.getString(3));
                kisi.setYetki(resultSet.getInt(4));
                kisi.setAd(resultSet.getString(5));
                kisi.setSoyad(resultSet.getString(6));
                kisi.setTelefon(resultSet.getString(7));
                liste.add(kisi);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Bir hata oluştu. Daha sonra tekrar deneyiniz.");
        }
        finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Bir hata oluştu. Daha sonra tekrar deneyiniz.");
            }
        }
        return liste;

    }

    public boolean kullaniciEkle(Kullanicilar kisi){
        try {
            int yetki = 0;
            if ((kisi.getYetki().equals("Admin"))) {
                yetki = 1;
            }
            else if(kisi.getYetki().equals("Kullanıcı")) {
                yetki = 2;
            }
            else
                yetki = 3;
            statement.execute("INSERT INTO yonetici (yonetici_adi,yonetici_sifre,yetki,ad,soyad,telefon) values" +
                    "('" +kisi.getKullaniciAdi()+"','" +kisi.getParola()+"','" +yetki+"'," +
                    "'" +kisi.getAd()+"','" +kisi.getSoyad()+"','" +kisi.getTelefon()+"')");
            close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    public void close(){
        try {
            if(resultSet != null)
                resultSet.close();
            if(statement != null)
                statement.close();
            if(connection != null)
                connection.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Veri Tabanına Bağlantı Sağlanamadı Tekrar Deneyiniz.");
            }

    }

    public boolean kullaniciAra(Kullanicilar kisi){
        try {
            resultSet = statement.executeQuery("SELECT * FROM yonetici");

            while (resultSet.next()){
                if(resultSet.getString(2).equals(kisi.getKullaniciAdi()))
                    return true;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Bir Hata Oluştu.");
        }

        return false;
    }

    

    public boolean kullaniciSil(int integer) {
        try {
            statement.execute("DELETE FROM yonetici WHERE idyonetici = "+integer);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean kullaniciGuncelle(Kullanicilar kisi) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE yonetici SET yonetici_adi = ? , yonetici_sifre = ?" +
                    ", yetki = ?, ad = ? , soyad = ? , telefon = ? WHERE idyonetici = ? ");
            preparedStatement.setString(1,kisi.getKullaniciAdi());
            preparedStatement.setString(2,kisi.getParola());
            preparedStatement.setInt(3,kisi.getYetkiSayi());
            preparedStatement.setString(4,kisi.getAd());
            preparedStatement.setString(5,kisi.getSoyad());
            preparedStatement.setString(6,kisi.getTelefon());
            preparedStatement.setInt(7,kisi.getId());
            preparedStatement.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}