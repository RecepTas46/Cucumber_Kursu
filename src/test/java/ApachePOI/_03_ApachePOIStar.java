package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _03_ApachePOIStar {
    public static void main(String[] args) throws IOException {
//ECXEL OKUMA ISLEMI
        //Dosyanin yolu alindi
        String path = "src/test/java/ApachePOI/resources/ApacheExcel2.xlsx";

        //Dosya okuma islemcisine dosyanin yolunu veriyoruz
        FileInputStream dosyaOkumaIslmemcisi=new FileInputStream(path);//try catch yapacagiz sonra..

        //bunun uzerinden calisma kitabini aliyorum
        Workbook calismaKitabi= WorkbookFactory.create(dosyaOkumaIslmemcisi);

        //Istedegm isimdeki calisma sayfasini aliyorum
        Sheet calismaSayfasi=calismaKitabi.getSheet("Sheet1");
        //Sheet calismaSayfasi=calismaKitabi.getSheetAt(0);

        //istenen satiri aliyorum
        Row satir=calismaSayfasi.getRow(0);

        Cell hucre=satir.getCell(0);
        System.out.println("hucre= "+hucre);






    }

}
