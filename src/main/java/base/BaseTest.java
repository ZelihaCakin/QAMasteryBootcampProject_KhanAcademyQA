package base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.MainPage;

public class BaseTest extends BaseLibrary {
    MainPage mainPage=new MainPage();
    @BeforeMethod
    public void openBrowser()throws InterruptedException {
        String tarayici = System.getProperty("browser");
        if(tarayici.equals("chrome")){
            driver = new ChromeDriver();
        }
        else if (tarayici.equals("firefox")) {
            driver = new FirefoxDriver();
        }
        else if (tarayici.equals("edge")) {
            driver = new EdgeDriver();
        }

        //driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        mainPage.clickAcceptAllCookies();
        sleep(5000);

    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
