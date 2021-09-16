package _JDBC.Gun02;

import _JDBC._JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _01_SqlExample extends _JDBCParent {

    // address tablosundaki teki disrict alanını önce 10.satırdakini sonra, 22.satırdaki,
    // sonra en son satırdaki bilgisini yazdırınız.
    @Test
    private void test2_LastFirstKeyword() throws SQLException {
        ResultSet rs = statement.executeQuery("select district from address");

       // rs.absolute(10);//absolute istenilen satira gider.
        rs.relative(10);//10. satira gittim(relativ en son kalan yerden ileri gider istenilen kadar)
        String disrict = rs.getString(1);
        System.out.println("disrict = " + disrict);

        rs.relative(12);//22.satira gittim
        disrict = rs.getString(1);
        System.out.println("disrict = " + disrict);

        rs.last();//last en son satiri alir
        disrict = rs.getString(1);//"district" de yazilabilir.
        System.out.println("disrict = " + disrict);


    }
}
