package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class _04_ApachePOIGetAllData {
    public static void main(String[] args) throws IOException {

        String path = "src/test/java/ApachePOI/resources/ApacheExcel2.xlsx";
        FileInputStream dosyaOkumaIslmemcisi = new FileInputStream(path);//try catch yapacagiz sonra..
        Workbook workbook = WorkbookFactory.create(dosyaOkumaIslmemcisi);
        Sheet sheet = workbook.getSheet("Sheet1");

        //calisma sayfasindaki satir sayisini veriyor
        int rowCount = sheet.getPhysicalNumberOfRows();
        for (int i = 0; i < rowCount; i++)
        {
            //bu satirdaki toplam hucre sayisini veriyor
            Row row=sheet.getRow(i);
            int cellCount=row.getPhysicalNumberOfCells();

            for (int j = 0; j <cellCount; j++)//i.satirdaki hucre sayisi kadar donecek
            {
                Cell cell=row.getCell(j);//bu satirdaki siradaki hucreyi aldim
                System.out.print(cell +" ");
            }
            System.out.println();
        }


    }

}
