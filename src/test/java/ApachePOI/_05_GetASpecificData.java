package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Verilen Exceldeki password bilgisini bir metoda aracılığı bularak yazdırınız,
 * yani metoda "password" kelimesi gönderilecek, dönen değr password un kendisi olacak.
 * src/test/java/ApachePOI/resources/LoginData.xlsx
 */
public class _05_GetASpecificData {
    public static void main(String[] args) {
        System.out.println("Aranacak Kelime=");
        Scanner oku = new Scanner(System.in);
        String arananKelime = oku.nextLine();

        String donenSonuc = bul(arananKelime);
        System.out.println("donenSonuc = " + donenSonuc);

    }

    public static String bul(String arananKelime) {
        String path = "src/test/java/ApachePOI/resources/LoginData.xlsx";
        StringBuilder donecek = new StringBuilder();
        Workbook workbook = null;
        try {

            FileInputStream dosyaOkumaIslmemcisi = new FileInputStream(path);
            workbook = WorkbookFactory.create(dosyaOkumaIslmemcisi);
        } catch (Exception ex) {
            System.out.println("ex = " + ex);
        }

        Sheet sheet = workbook.getSheetAt(0);//istenilen sayfayi getirecek
        int rowCount = sheet.getPhysicalNumberOfRows();//sayfada ki satir sayisi
        for (int i = 0; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            if (row.getCell(0).toString().equalsIgnoreCase(arananKelime)) {
                int cellCaunt = row.getPhysicalNumberOfCells();//satirdaki hucre sayisi

                for (int j = 0; j < cellCaunt; j++) {
                    donecek.append(row.getCell(j));//(append += anlamina geliyor)
                }
            }

        }


        return donecek.toString();
    }
}
