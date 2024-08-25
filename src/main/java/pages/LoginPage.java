package pages;

import base.BaseLibrary;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends BaseLibrary {
    @Step("Login sayfasına geçiş Kontrolü")
    public LoginPage clickLogin() throws InterruptedException {
        WebElement element = driver.findElement(By.id("login-or-signup"));
        if (element.isDisplayed())
            driver.findElement(By.id("login-or-signup")).click();
        sleep(4000);
        return this;
    }
    @Step("Email veya Kullanıcı Adı Alanı Doldurulur")
    public LoginPage fillEmail(String email) {
        driver.findElement(By.id("uid-login-form-8-wb-id-identifier-field")).sendKeys(email);
        return this;
    }
    @Step("Parola Alanı Doldurulur")
    public LoginPage fillPassword(String password) throws InterruptedException{
        driver.findElement(By.id("uid-labeled-text-field-10-wb-id-field")).sendKeys(password);
        screenshot();
        sleep(1000);
        return this;
    }
    @Step("Login Butonuna Tıklanır")
    public LoginPage clickLoginButton() throws InterruptedException{
        driver.findElement(By.cssSelector("button[data-testid='log-in-submit-button']")).click();
        sleep(2000);
        return this;
    }
    @Step("Hata Mesajı Penceresi Kontrolü: {text}")
    public LoginPage errorMessageControl(String text) {
        String value = driver.findElement(By.cssSelector("[class=\"_11reb8sm\"]")).getText();
        screenshot();
        Assert.assertEquals(text, value);
        return this;
    }

    @Step("Login Butonunun Tıklanabilir Olmadığının Kontrolü")
    public LoginPage verifyLoginButtonIsDisabled() {
        boolean isDisabled = driver.findElement(By.cssSelector("[data-testid='log-in-submit-button']")).getAttribute("aria-disabled").equals("true");
        screenshot();
        Assert.assertTrue(isDisabled, "Login butonunun devre dışı olduğu doğrulanamadı");
        return this;
    }

    @Step("Email Alanı İçeriği Temizlenir")
    public LoginPage emailClear(){
        WebElement emailField=driver.findElement(By.id("uid-login-form-8-wb-id-identifier-field"));
        emailField.sendKeys(Keys.BACK_SPACE);
        screenshot();
        return this;
    }
    @Step("Password İçeriği Temizlenir")
    public LoginPage passwordClear(){
            WebElement passwordField=driver.findElement(By.id("uid-labeled-text-field-10-wb-id-field"));
            passwordField.sendKeys(Keys.BACK_SPACE);
            screenshot();
            return this;
        }
    @Step("Google ile Devam Et butonuna tıklanır.")
    public LoginPage continueGoogle() {
        driver.findElement(By.cssSelector("[class=\"_uf8b05h\"]")).click();
        return this;
    }
    @Step("Google ile giriş penceresi kontrolü")
    public LoginPage controlGoogle() {
        WebElement googleElement = driver.findElement(By.id("headingText"));
        Assert.assertTrue(googleElement.getText().contains("Oturum açın"));
        return this;
    }

    @Step("Facebook ile Devam Et butonuna tıklanır.")
    public LoginPage continueFace() {
        driver.findElement(By.xpath("//*[@id=\"app-shell-root\"]/div[2]/main/div[2]/div/section[2]/div/div/div[1]/div[3]/div/button")).click();
        return this;
    }

    @Step("Facebook ile giriş penceresi kontrolü")
    public LoginPage controlFacebook() {
        WebElement googleElement = driver.findElement(By.xpath("//*[@id=\"content\"]/span"));
        Assert.assertTrue(googleElement.getText().contains("Khan Academy"));
        return this;
    }

    @Step("Clever ile Devam Et butonuna tıklanır.")
    public LoginPage continueClever() {
        driver.findElement(By.xpath("//*[@id=\"app-shell-root\"]/div[2]/main/div[2]/div/section[2]/div/div/div[1]/div[2]/div/button")).click();
        return this;
    }

    @Step("Apple ile Devam Et butonuna tıklanır.")
    public LoginPage continueApple() {
        driver.findElement(By.xpath("//*[@id=\"app-shell-root\"]/div[2]/main/div[2]/div/section[2]/div/div/div[1]/div[4]/div/button")).click();
        return this;
    }
    @Step("Apple ile giriş penceresi kontrolü")
    public LoginPage controlApple() {
        WebElement googleElement = driver.findElement(By.cssSelector("[class=\"ac-localnav-title\"]"));
        Assert.assertTrue(googleElement.getText().contains("Apple Kimliği"));
        return this;
    }
    @Step("Creat an Account üzerine tıklanır.")
    public LoginPage clickCreatanAccount() {
        driver.findElement(By.cssSelector("[class=\"_10p2zakf\"]")).click();
        return this;
    }


}

