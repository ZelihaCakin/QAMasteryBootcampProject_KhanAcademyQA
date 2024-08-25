package pages;

import base.BaseLibrary;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePage extends BaseLibrary {
    public HomePage loginControl()
    {
        String value = driver.findElement(By.cssSelector("[class=\"_196uhwmj _13hnk7qk\"]")).getText();
        screenshot();
        Assert.assertEquals("Zeliha Çakın", value);
        return this;
    }

    public HomePage cleverControl()
    {
        String value= driver.findElement (By.xpath("/html/body/div[4]/footer/div[1]")).getText();
        screenshot();
        Assert.assertEquals("Clever", value);
        return this;
    }
    public HomePage createAccountRedirectControl()
    {
        String value= driver.findElement(By.cssSelector("[class=\"_19ikyyfd\"]")).getText();
        screenshot();
        Assert.assertEquals("Sign up", value);
        return this;
    }

}
