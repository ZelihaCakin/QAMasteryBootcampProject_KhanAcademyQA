package pages;

import base.BaseLibrary;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage extends BaseLibrary {
    @Step("Kabul Et Alanı Kontrolü")
    public MainPage clickAcceptAllCookies() throws InterruptedException {
        sleep(4000);
        WebElement element = driver.findElement(By.cssSelector("[id=\"onetrust-accept-btn-handler\"]"));
        if (element.isDisplayed())
            driver.findElement(By.cssSelector("[id=\"onetrust-accept-btn-handler\"]")).click();
        return this;
    }

    /*@Step("Kullanıcı Girişi veya Kayıt İçin User Form Tıklama Kontrolü")
    public MainPage clickFeatherUser() throws InterruptedException {
        WebElement element = driver.findElement(By.cssSelector("[class=\"user inl-blk\"]"));
        if (element.isDisplayed())
            driver.findElement(By.cssSelector("[class=\"user inl-blk\"]")).click();
        sleep(4000);
        return this;
    }
    @Step("User Form Penceresi Kontrolü")
    public MainPage featherUserWindowOpen() throws InterruptedException {
        String value = driver.findElement(By.cssSelector("[class*=\"oturumTitle\"]")).getText();
        screenshot();
        Assert.assertEquals("GİRİŞ YAP", value);
        sleep(4000);
        return this;
    }*/

    }



