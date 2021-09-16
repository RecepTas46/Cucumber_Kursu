package _JDBC.Gun01;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.*;

public class _02_BeforeAfter {

    private Connection connection;
    private Statement statement;

    @BeforeTest
    private void beforeTest() throws SQLException {
        String url = "jdbc:mysql://test.medis.mersys.io:33306/sakila";
        String user = "technostudy";
        String password = "zhTPis0l9#$&";
        connection = DriverManager.getConnection(url, user, password);// bağlantı sağlandı.
        statement = connection.createStatement(); // sorgularımı çalıştırabilmek için bir yol oluştur.
    }

    @AfterTest
    private void afterTest() throws SQLException {
        connection.close();
    }

    @Test
    private void test1() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from language");

        rs.next();
        String dilAdi = rs.getString("name");
        System.out.println("dilAdi = " + dilAdi);

        rs.next();
        dilAdi = rs.getString("name");
        System.out.println("dilAdi = " + dilAdi);

        rs.next();
        dilAdi = rs.getString("name");
        System.out.println("dilAdi = " + dilAdi);


    }
    @Test
    private void test2() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from language");

        rs.next();
        String dilAdi = rs.getString(2);
        System.out.println("dilAdi = " + dilAdi);

        rs.next();
        dilAdi = rs.getString(2);
        System.out.println("dilAdi = " + dilAdi);

        rs.next();
        dilAdi = rs.getString(2);
        System.out.println("dilAdi = " + dilAdi);


    }

    @Test
    private void test3() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from language");

        rs.next();//English
        String dilAdi = rs.getString(2);
        System.out.println("dilAdi = " + dilAdi);

        rs.next();//Italien
        dilAdi = rs.getString(2);
        System.out.println("dilAdi = " + dilAdi);

        rs.previous();// bir onceki  ,English
        dilAdi = rs.getString(2);
        System.out.println("dilAdi = " + dilAdi);


    }

}
