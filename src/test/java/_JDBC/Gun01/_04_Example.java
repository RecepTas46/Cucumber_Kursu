package _JDBC.Gun01;

import _JDBC._JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _04_Example extends _JDBCParent {


    @Test
    private void test1() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from city");

        rs.relative(5);//adana
        String cityName = rs.getString(2);
        System.out.println("cityName = " + cityName);

        rs.relative(5);//Akishima
        cityName = rs.getString(2);
        System.out.println("cityName = " + cityName);


    }
    @Test
    private void test2_LastFirstKeyword() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from city");

        rs.last();//en son kayda gider
        String cityName = rs.getString(2);
        int countryId =rs.getInt("country_id");//burda hangi bolumu istyorsak rs ile cagiriyoruz
        int cityId=rs.getInt("city_id");
        System.out.println("cityName = " + cityName);
        System.out.println("countryId = " + countryId);
        System.out.println("cityId = " + cityId);


        rs.first();//ilk kayda gider
        cityName = rs.getString(2);
        countryId =rs.getInt("country_id");
        cityId=rs.getInt("city_id");
        System.out.println("cityName = " + cityName);
        System.out.println("countryId = " + countryId);
        System.out.println("cityId = " + cityId);


    }
}
