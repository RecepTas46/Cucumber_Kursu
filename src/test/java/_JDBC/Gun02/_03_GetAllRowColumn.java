package _JDBC.Gun02;

import _JDBC._JDBCParent;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class _03_GetAllRowColumn extends _JDBCParent {

    @Test
    public void test1() throws SQLException {

        ResultSet rs = statement.executeQuery("select * from language");

        ResultSetMetaData rsnd = rs.getMetaData();
        //sonuclar haricindeki bilgileri,,colon baslik kisimlarini alir,colon sayısı, isimleri, tipleri

        int columnCount = rsnd.getColumnCount();// kolon sayisi
        System.out.println("columnCount = " + columnCount);


        for (int i = 1; i <= columnCount; i++) {

            String columName = rsnd.getColumnName(i);
            String columType = rsnd.getColumnTypeName(i);

            System.out.println(columName + " " + columType);

        }
    }

    @Test
    public void test2() throws SQLException {
        //language taplosundaki tum satirlari ve sutunlari yazdiriniz,ayni mysql sonuc ekraninda oldugu gibi
        ResultSet rs = statement.executeQuery("select * from language");


        ResultSetMetaData rsnd = rs.getMetaData();
        int columnCount = rsnd.getColumnCount();

        for (int i = 1; i <= columnCount; i++) {
            String columName = rsnd.getColumnName(i);
            System.out.print(columName + " ");
        }

        System.out.println();
        rs.last();
        int rowCount = rs.getRow();
        rs.first();
        for (int i = 1; i < rowCount; i++) {
            rs.absolute(i);
            String language_id = rs.getString("language_id");
            String name = rs.getString("name");
            String last_update = rs.getString("last_update");

            System.out.println(language_id + " " + name + " " + last_update);
        }
    }


    //ikinci cozum
    @Test
    private void test3() throws SQLException {
        //language taplosundaki tum satirlari ve sutunlari yazdiriniz,ayni mysql sonuc ekraninda oldugu gibi
        ResultSet rs = statement.executeQuery("select * from language");


        ResultSetMetaData rsnd = rs.getMetaData();
        int columnCount = rsnd.getColumnCount();

        for (int j = 1; j <= columnCount; j++) {
            String columName = rsnd.getColumnName(j);
            System.out.print(columName + " ");
        }

        System.out.println();

        while ((rs.next())) {
            // her satırın bilgileri kolon kolon yazdırılıyor
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(rs.getString(i) + " ");
            }

            System.out.println();
        }

    }


    @Test
    private void test4() throws SQLException {
        //language taplosundaki tum satirlari ve sutunlari yazdiriniz,ayni mysql sonuc ekraninda oldugu gibi
        ResultSet rs = statement.executeQuery("select * from language");


        ResultSetMetaData rsnd = rs.getMetaData();
        int columnCount = rsnd.getColumnCount();

        for (int j = 1; j <= columnCount; j++) {

            System.out.printf("%-15s", rsnd.getColumnName(j) + " ");//tablo seklinde yazildi
        }
        System.out.println();

        while ((rs.next())) {

            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%-15s", rs.getString(i) + " ");
            }

            System.out.println();
        }

    }


    @Test
    private void task1() throws SQLException {
        // actor tablosundaki tüm satırları ve tüm sütunları yazdırınız, aynı mysql sonuç ekranında olduğu gibi
        // fakat metod kullanınız, metoda sorguyu gönderiniz ve orada yazdırınız.

        getTable("select * from actor");
    }

    public void getTable(String query) throws SQLException {
        ResultSet rs = statement.executeQuery(query);

        ResultSetMetaData rsnd = rs.getMetaData();
        int columnCount = rsnd.getColumnCount();

        for (int j = 1; j <= columnCount; j++) {

            System.out.printf("%-25s", rsnd.getColumnName(j) + " ");
        }
        System.out.println();

        while ((rs.next())) {

            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%-25s", rs.getString(i) + " ");
            }

            System.out.println();
        }
    }
    @Test //test olan seylerde direk scanner yapamiyoruz..bunun icin xml le parameters yapip bilgi alinabilir mysql den
    @Parameters("tableName")
    public void task2(String tableName) throws SQLException {
        // Kullanıcıdan alacağını tablo adındaki tüm satırları ve tüm sütunları yazdırınız,
        // aynı mysql sonuç ekranında olduğu gibi
        // fakat metod kullanınız, metoda sorguyu gönderiniz ve orada yazdırınız.

        getTable("select * from "+tableName);
    }
}
/*
language_id   name        last_update
1             English     2006-02-15 05:02:19
2             Italian     2006-02-15 05:02:19
3             Japanese    2006-02-15 05:02:19
4             Mandarin    2006-02-15 05:02:19
5             French      2006-02-15 05:02:19
6             German      2006-02-15 05:02:19
FORMATLI YAZDIRMA
printf("%15s", değişken adı)  değeri 15 haneye yaz(default sağa dayalı yazar)
printf("%-15s", değişken adı) değeri 15 haneye yaz(default sola dayalı yazar)
 */