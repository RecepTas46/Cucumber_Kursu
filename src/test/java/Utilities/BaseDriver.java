package Utilities;

import Pages.Parent;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseDriver {

    /**
     * Interview Sorusu
     * Singleton driver nedir?
     * Bütün projede aynı ve tek bir driverın kullanılmasıdır.
     */

    // Her thread e özel driver olacak ve static olduğu için o thread deki bütün classlaar aynı DRİVER ı kullanmış olacak.
    // thread coklu yol anlamina geliyor.
    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();  // WebDriver1  , WebDriver 2
    public static ThreadLocal<String> threadBrowserName = new ThreadLocal<>(); // chrome , firefox

    public static WebDriver getDriver() {

        // XML den gelmeyen tarayıcı adı ile çalışan scenario lar için
        // default setleme yapıldı
        if (threadBrowserName.get() == null) {
            threadBrowserName.set("chrome");
        }

        if (threadDriver.get() == null) { //bu hatta driver var mı ?

            // yoksa hangi türü isteniyor ise o setleniyor
            switch (threadBrowserName.get()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    if (!runningFromIntelliJ()) {
                        ChromeOptions options = new ChromeOptions();
                        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage", "--disable-gpu", "--window-size=1400,2400"); //width, height
                        threadDriver.set(new ChromeDriver(options));//jenkis icin eklendi,normal calismalrda bu uc satir yoruma alinmali,alttaki satir yorumdan cikarilmali

                    } else {
                        threadDriver.set(new ChromeDriver());
                    }
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    threadDriver.set(new FirefoxDriver());
                    break;
            }
        }

        return threadDriver.get();
    }

    public static void DriverQuit() {
        // bekleme
        Parent.delay(5);

        if (threadDriver.get() != null) {
            threadDriver.get().quit();
            WebDriver driver = threadDriver.get();
            driver = null;
            threadDriver.set(driver);
        }
    }

    public static boolean runningFromIntelliJ() {//bunu ekleyerek jenkis haricinde browser normal calisacak hale geldi
        String classPath = System.getProperty("java.class.path");
        return classPath.contains("idea_rt.jar");
    }
}
