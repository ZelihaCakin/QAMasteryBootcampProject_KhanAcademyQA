package base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.MainPage;

public class BaseTest extends BaseLibrary {
    MainPage mainPage=new MainPage();
    @BeforeMethod
    public void openBrowser()throws InterruptedException {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.khanacademy.org/");
        mainPage.clickAcceptAllCookies();
        sleep(5000);

    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
