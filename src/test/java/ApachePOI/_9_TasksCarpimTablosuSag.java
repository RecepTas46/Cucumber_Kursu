package ApachePOI;


import Utilities.BaseDriver;
import cucumber.api.Scenario;
import org.apache.poi.ss.usermodel.*;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Objects;


public class _9_TasksCarpimTablosuSag {
    public static void main(String[] args) throws IOException {


        /**  Soru 1:
         *  Çarpım tablosunu excele yazdırınız.
         *  1 x 1 = 1 şeklinde işaretleri de yazdırınız.
         *  sıfırdan excel oluşturarak.
         *  her bir onluktan sonra 1 satır boşluk bırakarak alt alata
         */

        /**  Soru 2:
         *  Çarpım tablosunu excele yazdırınız.
         *  1 x 1 = 1 şeklinde işaretleri de yazdırınız.
         *  sıfırdan excel oluşturarak.
         *  her bir onluktan sonra 1 kolon boşluk bırakarak yan yana
         */

        XSSFWorkbook workbook = new XSSFWorkbook();//hafizada worbook olustur
        XSSFSheet sheet = workbook.createSheet("Sayfa1");

        for (int i = 1; i <= 10; i++) {
            Cell cell;
            Row row = sheet.createRow(i);
            int sayi = 1;
            for (int j = 1; j <= 10; j++) {

                cell = row.createCell(sayi);
                cell.setCellValue(i);

                cell = row.createCell(sayi + 1);
                cell.setCellValue("x");

                cell = row.createCell(sayi + 2);
                cell.setCellValue(j);

                cell = row.createCell(sayi + 3);
                cell.setCellValue("=");

                cell = row.createCell(sayi + 4);
                cell.setCellValue(j * i);

                cell = row.createCell(sayi + 5);
                cell.setCellValue(" ");
                sayi += 6;
            }


        }
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("src/test/java/ApachePOI/resources/carpimTaplosu.xlsx");
            workbook.write(outputStream);// içine hafızadaki bilgileri yazdık.
            workbook.close(); // hafızayı boşalttık
            outputStream.close();// dosyayı kapattık.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

/**
 excel de hücreleri renklendirmek isterseniz
 XSSFCellStyle style = xssfWorkbook.createCellStyle();
 style.setFillForegroundColor(new XSSFColor(new java.awt.Color(32, 128, 0)));
 style.setFillPattern(SOLID_FOREGROUND);
 cell.setCellStyle(style);
 */