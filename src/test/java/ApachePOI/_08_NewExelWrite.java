package ApachePOI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.FileOutputStream;
import java.io.IOException;

public class _08_NewExelWrite {
    public static void main(String[] args) throws IOException {
        //Bu degiskenin manasi hafizada bir exel degiskeni olusturma
        XSSFWorkbook workbook=new XSSFWorkbook();//hafizada worbook olustur
        XSSFSheet sheet=workbook.createSheet("Sayfa1");

        Row row=sheet.createRow(0);//satir olustur
        Cell cell=row.createCell(0);//hucre olustur
        cell.setCellValue("Merhaba Dunya Biz Geliyoruz");//hucreyi hafizada yaz

        for (int i = 1; i < 10; i++) {
            row=sheet.createRow(i);
            cell=row.createCell(0);//yanyana yazmak icin i olmali
            cell.setCellValue(i);
        }
        //dosyayi olusturduk
        FileOutputStream outputStream=new FileOutputStream("src/test/java/ApachePOI/resources/yeniExel.xlsx");
        workbook.write(outputStream);//icine hafizadaki bilgileri yazdik
        workbook.close();//hafizayi bosalttik
        outputStream.close();//dosyayi kapattik




    }
}
