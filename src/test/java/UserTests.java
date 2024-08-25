import base.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

import java.util.Set;

public class UserTests extends BaseTest {
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    HomePage homePage=new HomePage();

    @Test(description = "Başarılı Login Kullanıcı Giriş Kontrolü")
    @Severity(SeverityLevel.CRITICAL)
    public void loginSuccessful()throws InterruptedException {
        loginPage.clickLogin();
        loginPage
                .fillEmail(email)
                .fillPassword(password)
                .clickLoginButton();
        sleep(4000);
        homePage.loginControl();
    }

    @Test(description = "Hatalı Şifre ile Kullanıcı Giriş Kontrol")
    @Severity(SeverityLevel.CRITICAL)
    public void notValidLogin() throws InterruptedException {
        loginPage.clickLogin();
        loginPage
                .fillEmail(email)
                .fillPassword("aaaaaa")
                .clickLoginButton();
        sleep(4000);
        loginPage.errorMessageControl(errorMessage);
    }

    @Test(description = "Sistemde Kayıtlı Olmayan Email ile Kullanıcı Girişi")
    @Severity(SeverityLevel.CRITICAL)
    public void notValidWithEmail() throws InterruptedException {
        loginPage.clickLogin();
        loginPage
                .fillEmail("zeliha@gmail.com")
                .fillPassword(password)
                .clickLoginButton();
        sleep(4000);
        loginPage.errorMessageControl(errorMessage);
    }

    @Test(description = "Bos Karakter Kontrolu")
    @Severity(SeverityLevel.CRITICAL)
    public void requiredBlankControl() throws InterruptedException {
        loginPage.clickLogin();
        loginPage
                .fillEmail("")
                .fillPassword("");
        loginPage.verifyLoginButtonIsDisabled();
        sleep(3000);

        loginPage.fillEmail(email);
        loginPage.verifyLoginButtonIsDisabled();
        sleep(3000);

        loginPage
                .fillPassword(password)
                .clickLoginButton();
        sleep(4000);
        homePage.loginControl();
    }

    @Test(description = "Minumum Karakter Kontrolü")
    @Severity(SeverityLevel.CRITICAL)
    public void minControl() throws InterruptedException {
        loginPage.clickLogin();
        loginPage
                .fillEmail("a")
                .fillPassword("2")
                .clickLoginButton();
        sleep(2000);
        loginPage.errorMessageControl(errorMessage);
        loginPage.emailClear();
        loginPage.passwordClear();
        loginPage.fillEmail(email)
                .fillPassword("2")
                .clickLoginButton();
        loginPage.errorMessageControl(errorMessage);
        sleep(2000);
    }

    @Test(description = "Maximum Karakter Kontrolü")
    @Severity(SeverityLevel.CRITICAL)
    public void maxControl() throws InterruptedException {
        loginPage.clickLogin();
        loginPage
                .fillEmail("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
                .fillPassword(password)
                .clickLoginButton();
        loginPage.errorMessageControl(errorMessage);

    }

    @Test(description = "Continue with Google butonu Kontrolü")
    @Severity(SeverityLevel.CRITICAL)
    public void continueWithGoogle() throws InterruptedException{
        loginPage.clickLogin();
        String mainWindowHandle = driver.getWindowHandle();
        loginPage.continueGoogle();
        sleep(4000);
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        sleep(4000);
        loginPage.controlGoogle();
    }

    @Test(description = "Continue with Clever butonu Kontrolü")
    @Severity(SeverityLevel.CRITICAL)
    public void continueWithClever() throws InterruptedException{
        loginPage.clickLogin();
        loginPage.continueClever();
        homePage.cleverControl();
        sleep(4000);
    }

    @Test(description = "Continue with Facebook butonu Kontrolü")
    @Severity(SeverityLevel.CRITICAL)
    public void continueWithFacebook() throws InterruptedException{
        loginPage.clickLogin();
        String mainWindowHandle = driver.getWindowHandle();
        loginPage.continueFace();
        sleep(4000);
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        sleep(4000);
        loginPage.controlFacebook();
    }

    @Test(description = "Continue with Apple butonu Kontrolü")
    @Severity(SeverityLevel.CRITICAL)
    public void continueWithApple() throws InterruptedException{
        loginPage.clickLogin();
        String mainWindowHandle = driver.getWindowHandle();
        loginPage.continueApple();
        sleep(4000);
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        sleep(4000);
        loginPage.controlApple();
    }

    @Test(description = "Creat An Account ile sign up sayfasına yönlendirme kontrolü")
    @Severity(SeverityLevel.CRITICAL)
    public void redirectAccount() throws InterruptedException{
        loginPage.clickLogin();
        loginPage.clickCreatanAccount();
        sleep(2000);
        homePage.createAccountRedirectControl();
    }

    @Test(description = "Geçersiz Apple Hesabı İle Teacher Kullanıcı Kaydı OLuşturma Kontrolü")
    @Severity(SeverityLevel.CRITICAL)
    public void notValidAppleSignup() throws InterruptedException{
        registerPage.clickRegister();
        sleep(2000);
        String mainWindowHandle = driver.getWindowHandle();
        registerPage.clickTeacher();
        sleep(4000);
        registerPage.clickContinueApple();
        sleep(2000);
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        sleep(4000);
        //registerPage.controlApple();
        registerPage.emailApple("asd@gmail.com");
        sleep(2000);
        registerPage.passwordApple(password);
        sleep(2000);
        registerPage.errorMessageControlA(errorMessage2);
    }

    @Test(description = "Geçersiz Facebook Hesabı ile Teacher Kullanıcı Kaydı OLuşturma Kontrolü")
    @Severity(SeverityLevel.CRITICAL)
    public void notValidFacebookSignup() throws InterruptedException{
        registerPage.clickRegister();
        sleep(2000);
        String mainWindowHandle = driver.getWindowHandle();
        registerPage.clickTeacher();
        sleep(4000);
        registerPage.clickContinueFacebook();
        sleep(2000);
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        sleep(2000);
        //registerPage.controlApple();
        registerPage.emailFacebook("abc@gmail.com");
        registerPage.passwordFacebook(password);
        registerPage.clickFaceGiris();
        sleep(4000);
        registerPage.errorMessageControlF(errorMessage3);
    }

    @Test(description = "Kayıtlı Kullanıcı ile Teacher Kullanıcı Kaydı OLuşturma Kontrolü")
    @Severity(SeverityLevel.CRITICAL)
    public void notValidSignup() throws InterruptedException{
        registerPage.clickRegister();
        sleep(2000);
        registerPage.clickTeacher();
        sleep(4000);
        registerPage.clickContinueSingup();
        sleep(2000);
        registerPage.emailSignup(email);
        sleep(2000);
        registerPage.firsnameSignup(name);
        sleep(2000);
        registerPage.lastnameSignup(lastname);
        sleep(2000);
        registerPage.createPassword(password);
        sleep(2000);
        registerPage.clickSignup();
        sleep(4000);
        registerPage.errorMessageControlS(errorMessage4);
    }

    @Test(description = "Geçersiz Enter Class Code ile Learner Kullanıcı Kaydı Oluşturma Kontrolü")
    @Severity(SeverityLevel.CRITICAL)
    public void notValidEnterClassCode() throws InterruptedException{
        registerPage.clickRegister();
        sleep(2000);
        registerPage.clickLearner();
        registerPage.clickEnterClassCode();
        sleep(2000);
        registerPage.fillClassCode("12345678");
        sleep(2000);
        registerPage.clickContinue();
        sleep(2000);
        registerPage.errorMessageControlE(errorMessage5);
    }



}
