package ApachePOI;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;


public class _9_TasksCarpimTablosuYANaltt5ER {
    public static void main(String[] args) {


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
        Row row;
        int sayi ;
        int a = 0;

        for (int i = 1; i <= 10; i++) {
            row = sheet.createRow(i);
            sayi = 0;

            for (int j = 1; j <=5; j++) {

                cell = row.createCell(sayi);
                cell.setCellValue(j);

                cell = row.createCell(sayi + 1);
                cell.setCellValue("x");

                cell = row.createCell(sayi + 2);
                cell.setCellValue(i);

                cell = row.createCell(sayi + 3);
                cell.setCellValue("=");

                cell = row.createCell(sayi + 4);
                cell.setCellValue(i * j);

                sayi += 6;
            }

            sheet.createRow(a++);

            for (int k = 1; k <= 10; k++) {

                row = sheet.createRow(a + 11);

                cell = row.createCell(0);
                cell.setCellValue(k);

                cell = row.createCell(1);
                cell.setCellValue("x");

                cell = row.createCell(2);
                cell.setCellValue(i+5);

                cell = row.createCell(3);
                cell.setCellValue("=");

                cell = row.createCell(4);
                cell.setCellValue((i +5) * k);

                a++;

            }

        }


        FileOutputStream outputStream;
        try {
            outputStream = new FileOutputStream("src/test/java/ApachePOI/resources/carpimTaplosuYanaltt5.xlsx");
            workbook.write(outputStream);// içine hafızadaki bilgileri yazdık.
            workbook.close(); // hafızayı boşalttık
            outputStream.close();// dosyayı kapattık.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
