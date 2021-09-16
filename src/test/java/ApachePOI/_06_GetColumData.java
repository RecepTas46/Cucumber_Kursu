package ApachePOI;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * LoginData.xlsx i kullanarak, istneilen kolondaki bilgileri
 * ekrana yazdıran programı metod kullanarak yazdırınız.metod kolon numarası alsın.
 * * src/test/java/ApachePOI/resources/LoginData.xlsx
 */
public class _06_GetColumData {
    public static void main(String[] args) {
        System.out.println("Istenen kolon=");
        Scanner oku = new Scanner(System.in);
        int colomn = oku.nextInt();

        String donenSonuc = bul(colomn);
        System.out.println("donenSonuc = " + donenSonuc);

    }

    public static String bul(int colomn) {
        String path = "src/test/java/ApachePOI/resources/LoginData.xlsx";
        String donecek = "";
        Workbook workbook = null;
        try {

            FileInputStream dosyaOkumaIslmemcisi = new FileInputStream(path);
            workbook = WorkbookFactory.create(dosyaOkumaIslmemcisi);
        } catch (Exception ex) {
            System.out.println("ex = " + ex);
        }

        Sheet sheet = workbook.getSheetAt(0);
        int rowCount = sheet.getPhysicalNumberOfRows();

        for (int i = 0; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            int cellCaunt = row.getPhysicalNumberOfCells();

            if (cellCaunt > colomn)
                donecek += row.getCell(colomn) + " ";

        }
        return donecek;
    }
}
