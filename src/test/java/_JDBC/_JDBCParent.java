package _JDBC;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class _JDBCParent {


    private Connection connection;//statik tanimlandi ise(classin adi ile ulasirim statik tek tir yani) verible metod denir,
    // statik degilse instence (nesne),statikten dinamige ulasilmaz. ama dinamikten statige ulasilir,cunku statik bir tane ve classi belli
   public Statement statement;

    @BeforeTest
    public void beforeTest() {
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

    @AfterTest
    public void afterTest() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
