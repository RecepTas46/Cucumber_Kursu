package ApachePOI;



import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class _07_WriteInTheExcelFile {
    public static void main(String[] args) throws IOException {

        //Dosya okuma islemleri
        String path = "src/test/java/ApachePOI/resources/WriteInTheExcelFile.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);//try catch yapacagiz sonra..
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheet("Sheet1");

        //hafizada olusturma ve yazma islemleri
        Row row = sheet.createRow(0);//satir acildi ama kullanilir degil
        Cell cell= row.createCell(0);//hucre olusturuldu A! kullanilir bir hucre var
        cell.setCellValue("Merhaba Dunya");//Bilgi yazildi
        //yazma islemine gecebilmek icin okuma modu kapatilmali.

        for (int i = 1; i <10 ; i++) {
            row=sheet.createRow(i);
            cell= row.createCell(0);
            cell.setCellValue(i);
        }
        //buraya okumayi kapat var
        fileInputStream.close();

        FileOutputStream outputStream=new FileOutputStream(path);
        workbook.write(outputStream);
        outputStream.close();


    }
}
/*
for (int i=1;i<=10;i++)
{
    for (int j=1;j<=10;j++)
        System.out.println(i +"  * "+j+"  = "+(i*j));

    System.out.println();
}
    }
 */