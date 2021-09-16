package Utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtility {
    // Gönderilen sorgunun sonucunu List olarak geri gönderen
    // bir Reusable bir fonksiyon yazınız.
    private static Connection connection;
    protected static Statement statement;

    public static void DBConnectionOpen() {
        String url = "jdbc:mysql://test.medis.mersys.io:33306/sakila";
        String user = "technostudy";
        String password = "zhTPis0l9#$&";

        try {
            connection = DriverManager.getConnection(url, user, password);// bağlantı sağlandı.
            statement = connection.createStatement(); // sorgularımı çalıştırabilmek için bir yol oluştur.
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public static void DBConnectionClose() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static List<List<String>> getListData(String guery) {
        DBConnectionOpen();
        List<List<String>> returnList = new ArrayList<>();

        try {
            ResultSet rs = statement.executeQuery(guery);

            ResultSetMetaData rsnd = rs.getMetaData();
            int columnCount = rsnd.getColumnCount();

            while ((rs.next())) {//bir sonraki satira geciriyor
                List<String> rowList = new ArrayList<>();
                // her satırın bilgileri kolon kolon yazdırılıyor
                for (int i = 1; i <= columnCount; i++) {
                    rowList.add(rs.getString(i));
                }

                returnList.add(rowList);
            }
        } catch (SQLException ex) {
            System.out.println("ex.getMessage() = " + ex.getMessage());
        }
        DBConnectionClose();
        return returnList;

    }

    public static String getData(String query) {
        DBConnectionOpen();
        //*********
        //*********
        //*********
        //*********
        DBConnectionClose();
        return "sonucu";//burasi ornek calisacagimiz yer..
    }

    public static void main(String[] args) {
        List<List<String>>data=getListData("select * from city");//buraaya ne gonderirsek o gelecek(city,address,actor vs)

        for (List<String> a:data) {
            System.out.println(a);
        }
    }
    
}
