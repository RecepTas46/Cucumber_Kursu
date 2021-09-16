package ApachePOI;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;


public class _9_TasksCarpimTablosuAlt {
    public static void main(String[] args)  {


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
        Cell cell;
        Row row ;
        int sayi = 1;

        for (int i = 1; i <= 10; i++) {

            for (int j = 1; j <= 10; j++) {

                row = sheet.createRow(sayi);

                cell = row.createCell(0);
                cell.setCellValue(i);

                cell = row.createCell( 1);
                cell.setCellValue("x");

                cell = row.createCell( 2);
                cell.setCellValue(j);

                cell = row.createCell( 3);
                cell.setCellValue("=");

                cell = row.createCell( 4);
                cell.setCellValue(i * j);

                sayi ++;
            }

            row = sheet.createRow(sayi++);

        }
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("src/test/java/ApachePOI/resources/carpimTaplosuAsagi.xlsx");
            workbook.write(outputStream);// içine hafızadaki bilgileri yazdık.
            workbook.close(); // hafızayı boşalttık
            outputStream.close();// dosyayı kapattık.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
