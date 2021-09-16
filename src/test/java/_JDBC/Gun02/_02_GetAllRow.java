package _JDBC.Gun02;

import _JDBC._JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _02_GetAllRow extends _JDBCParent {

    @Test
    private void test1() throws SQLException {


        ResultSet rs = statement.executeQuery("select * from customer");//eger istenilen kayda kadar ise parantez icine
        // limit 200 gibi yazilabilir..asagidaki gibi
        // ResultSet rs = statement.executeQuery("select * from customer limit 100")

        int rowCount = 0;
        while (rs.next()) {
            String ad = rs.getString("first_name");
            String soyad = rs.getString("last_name");

            System.out.println(ad + soyad);
            rowCount++;
        }
        System.out.println("rowCount = " + rowCount);
        System.out.println("rs.getRow() = " + rs.getRow());//bu nokta while in olmadigi nokta,yani satirin olmadigi yer

        rs.last();
        System.out.println("rs.getRow() = " + rs.getRow());
    }


    @Test
    private void test1For() throws SQLException {
        // yukardaki ornegi for dongusu ile yapiniz..
        ResultSet rs = statement.executeQuery("select * from customer");

        rs.last();//sona kadar yaz
        int rowCount = rs.getRow();
        rs.first();//gosterge tekrar basa getirildi
        for (int i = 1; i < rowCount; i++) {
            String ad = rs.getString("first_name");
            String soyad = rs.getString("last_name");
            String email = rs.getString("email"); //buna benzer adimlar eklenebilir

            System.out.println(ad + " " + soyad + " " + email);
            rs.next();//bunu demez isek hep ayni ismi yazar,bir sonrakine atlamaz
        }
        System.out.println("rowCount = " + rowCount);
        System.out.println("rs = " + rs.getRow());
    }
    @Test
    private void test2For() throws SQLException {
        //   // Yukarıdaki örneği for döngüsü ile yapınız (Absolute ile yapıldı)
        ResultSet rs = statement.executeQuery("select * from customer");

        rs.last();
        int rowCount = rs.getRow();
       // rs.first();//buna gerek yok absolute for icinde hep artiriyor,basa aliyor
        for (int i =1; i <rowCount; i++) {
            rs.absolute(i);// verilen index deki satira gider
            String ad = rs.getString("first_name");
            String soyad = rs.getString("last_name");

            System.out.println(ad + " " + soyad);
        }

    }
    @Test
    private void test3For() throws SQLException {
        // Yukarıdaki örneği for döngüsü ile TERSTEN yapınız
        ResultSet rs = statement.executeQuery("select * from customer");

        rs.last();
        int rowCount = rs.getRow();

        for (int i = rowCount; i > 0; i--) {
            rs.absolute(i);// verilen index deki satira gider
            String ad = rs.getString("first_name");
            String soyad = rs.getString("last_name");

            System.out.println(ad + " " + soyad);
        }

    }
}
