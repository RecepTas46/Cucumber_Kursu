package _JDBC.Gun01;

import _JDBC._JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _03_AbsoluteRelativ extends _JDBCParent {
    @Test
    private void test1() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from film");

        rs.absolute(10);//istenlen satir
        String title = rs.getString("title");
        System.out.println("title = " + title);

        rs.absolute(15);//istenilen satir
        title = rs.getString("title");
        System.out.println("title = " + title);

        rs.absolute(-15);//sondan 15. satir
        title = rs.getString("title");
        System.out.println("title = " + title);

        rs.relative(5);//en son bulundugun yerden 5 ileri gider  yani absolute -10. ye gider
        title = rs.getString("title");
        System.out.println("title = " + title);

        rs.relative(-5);//en son bulundugun yerden 5 geri gider yani absolute 15. ye gider
        title = rs.getString("title");
        System.out.println("title = " + title);


    }
}
