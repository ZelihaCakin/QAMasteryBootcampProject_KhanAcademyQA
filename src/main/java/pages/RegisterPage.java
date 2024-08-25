package pages;

import base.BaseLibrary;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class RegisterPage extends BaseLibrary {
    @Step("Sign up butonuna tıklama Kontrolü.")
    public pages.RegisterPage clickRegister() {
        driver.findElement(By.cssSelector("[class=\"_320a97h\"]")).click();
        return this;
    }

    @Step("Learner butonuna tıklama Kontrolü.")
    public pages.RegisterPage clickLearner() {
        driver.findElement(By.cssSelector("[class=\"_gn30x3h\"]")).click();
        return this;
    }

    @Step("Teacher butonuna tıklama Kontrolü.")
    public pages.RegisterPage clickTeacher() {
        driver.findElement(By.xpath("//*[@id=\"app-shell-root\"]/div[2]/main/div[2]/div/section[2]/div/div/div[1]/div[2]/button[2]")).click();
        return this;
    }

    @Step("Teacher kullanıcı kaydında Apple ile kayıt olma buton Kontrolü.")
    public pages.RegisterPage clickContinueApple() {
        driver.findElements(By.cssSelector("[class=\"_uf8b05h\"]")).get(3).click();
        return this;
    }

    @Step("Apple ile giriş penceresi kontrolü")
    public pages.RegisterPage controlApple() {
        WebElement googleElement = driver.findElement(By.cssSelector("[class=\"ac-localnav-title\"]"));
        Assert.assertTrue(googleElement.getText().contains("Apple Kimliği"));
        return this;
    }

    @Step("Parent butonuna tıklama Kontrolü.")
    public pages.RegisterPage clickParent() {
        driver.findElement(By.cssSelector("[class=\"_gn30x3h\"]")).click();
        return this;
    }
    @Step("Doğum ayını seçme Kontrolü")
    public pages.RegisterPage clickMonth() {
        driver.findElement(By.cssSelector("button#uid-single-select-opener-10-wb-id")).click();
        driver.findElement(By.xpath("//span[text()='March']")).click();
        return this;
    }

    @Step("Soyadınızı Giriniz Alanı Doldurulur")
    public pages.RegisterPage fillLastnameField(String lastname) {
        driver.findElement(By.name("signup_soyad")).sendKeys(lastname);
        return this;
    }

    @Step("Apple E-mail Adresiniz Alanı Doldurulur")
    public pages.RegisterPage emailApple(String email) {
        driver.findElement(By.id("account_name_text_field")).sendKeys(email);
        driver.findElement(By.id("sign-in")).click();
        return this;
    }

    @Step("Apple Şifreniz Alanı Doldurulur")
    public pages.RegisterPage passwordApple(String password) {
        driver.findElement(By.id("password_text_field")).sendKeys(password);
        driver.findElement(By.id("sign-in")).click();
        return this;
    }

    @Step("Apple Hata Mesajı Penceresi Kontrolü: {text}")
    public pages.RegisterPage errorMessageControlA(String text) {
        String value = driver.findElement(By.cssSelector("[class=\"tk-subsection-headline\"]")).getText();
        screenshot();
        Assert.assertEquals(text, value);
        return this;
    }

    @Step("Teacher kullanıcı kaydında Apple ile kayıt olma buton Kontrolü.")
    public pages.RegisterPage clickContinueFacebook() {
        driver.findElements(By.cssSelector("[class=\"_uf8b05h\"]")).get(2).click();
        return this;
    }

    @Step("Facebook E-mail Adresiniz Alanı Doldurulur")
    public pages.RegisterPage emailFacebook(String email) {
        driver.findElement(By.id("email")).sendKeys(email);
        return this;
    }

    @Step("Facebook Şifreniz Alanı Doldurulur")
    public pages.RegisterPage passwordFacebook(String password) {
        driver.findElement(By.id("pass")).sendKeys(password);
        return this;
    }

    @Step("Facebook Şifreniz Alanı Doldurulur")
    public pages.RegisterPage clickFaceGiris() {
        driver.findElement(By.id("loginbutton")).click();
        return this;
    }

    @Step("Apple Hata Mesajı Penceresi Kontrolü: {text}")
    public pages.RegisterPage errorMessageControlF(String text) {
        String value = driver.findElement(By.id("error_box")).getText();
        screenshot();
        Assert.assertEquals(text, value);
        return this;
    }

    @Step("Teacher kullanıcı kaydında Apple ile kayıt olma buton Kontrolü.")
    public pages.RegisterPage clickContinueSingup() {
        driver.findElements(By.cssSelector("[class=\"_uf8b05h\"]")).get(4).click();
        return this;
    }

    @Step("Your Email Alanı Doldurulur")
    public pages.RegisterPage emailSignup(String email) {
        driver.findElement(By.id("uid-labeled-text-field-18-wb-id-field")).sendKeys(email);
        return this;
    }

    @Step("Firstname Alanı Doldurulur")
    public pages.RegisterPage firsnameSignup(String name) {
        driver.findElement(By.id("uid-labeled-text-field-19-wb-id-field")).sendKeys(name);
        return this;
    }

    @Step("Lastname Alanı Doldurulur")
    public pages.RegisterPage lastnameSignup(String lastname) {
        driver.findElement(By.id("uid-labeled-text-field-20-wb-id-field")).sendKeys(lastname);
        return this;
    }

    @Step("Create Password Alanı Doldurulur")
    public pages.RegisterPage createPassword(String password) {
        driver.findElement(By.id("uid-labeled-text-field-21-wb-id-field")).sendKeys(password);
        return this;
    }

    @Step("Sign Up Button Kontrolü")
    public pages.RegisterPage clickSignup() {
        driver.findElement(By.cssSelector("[class=\"_q7flqj6\"]")).click();
        return this;
    }

    @Step("Sign Up with Email Hata Mesajı Penceresi Kontrolü: {text}")
    public pages.RegisterPage errorMessageControlS(String text) {
        String value = driver.findElement(By.cssSelector("[class=\"_14hvi6g8\"]")).getText();
        screenshot();
        Assert.assertEquals(text, value);
        return this;
    }

    @Step("Enter Class Code Click Kontrolü")
    public pages.RegisterPage clickEnterClassCode() {
        driver.findElement(By.cssSelector("[class=\"_985p45\"]")).click();
        return this;
    }

    @Step("Class Code Doldurma Kontrolü: {text}")
    public pages.RegisterPage fillClassCode(String text) {
        driver.findElement(By.cssSelector("form._s5nn13 input._16et6z1")).sendKeys(text);
        screenshot();
        return this;
    }

    @Step("Continue Class Code Button Kontrolü")
    public pages.RegisterPage clickContinue() {
        driver.findElement(By.cssSelector("[class=\"_1f0fvyce\"]")).click();
        return this;
    }

    @Step("Geçersiz Class Code ile Hata Mesajı Penceresi Kontrolü: {text}")
    public pages.RegisterPage errorMessageControlE(String text) {
        String value = driver.findElement(By.cssSelector("[class=\"_1o1csyur\"]")).getText();
        screenshot();
        Assert.assertEquals(text, value);
        return this;
    }

}

