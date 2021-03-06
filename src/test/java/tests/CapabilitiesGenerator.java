//package tests;
//
//import org.openqa.selenium.chrome.ChromeOptions;
//
//import java.sql.SQLOutput;
//
//public class CapabilitiesGenerator { //для кроссплатферменности
//    public static ChromeOptions getChromeOptions() {
//        String driverPath = "src/test/resources";
//        ChromeOptions options = new ChromeOptions();
//        String os = System.getProperty("os.name").toLowerCase();
//        System.out.println("Operational system: " + os + "; Driver path: " + driverPath) ;
//        if (os.contains("win")) {
//            System.setProperty("webdriver.chrome.driver", driverPath + "/chromedriver.exe");
//        } else if (os.contains("mac")) {
//            System.setProperty("webdriver.chrome.driver", driverPath + "/chromedriver");
//        } else {
//            System.setProperty("webdriver.chrome.driver", driverPath + "/linux/chromedriver");
//        }
//        options.addArguments("--ignore-certificate-errors");//когда нет сертификата
//        options.addArguments("--disable-popup-blocking");//хром, ничего не блокируй, пожалуйста
//        options.addArguments("--disable-notifications");//подписка на обновления
//        //options.addArguments("--headless");
//        //options.addArguments("--no-sandbox"); //https://stackoverflow.com/a/50725918/1689770
//        //options.addArguments("--disable-infobars"); //https://stackoverflow.com/a/43840128/1689770
//        //options.addArguments("--disable-dev-shm-usage"); //https://stackoverflow.com/a/50725918/1689770
//        //options.addArguments("--disable-browser-side-navigation"); //https://stackoverflow.com/a/49123152/1689770
//        //options.addArguments("--disable-gpu"); //https://stackoverflow.com/questions/51959986/how-to-solve-selenium-chromedriver-timed-out-receiving-message-from-renderer-exc
//
//        return options;
//    }
//}
