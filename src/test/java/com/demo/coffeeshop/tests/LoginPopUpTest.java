package com.demo.coffeeshop.tests;

import com.demo.coffeeshop.base.TestBase;
import com.demo.coffeeshop.base.StaticHelper;
import com.demo.coffeeshop.pages.Header;
import com.demo.coffeeshop.pages.LoginPopUp;
import com.demo.coffeeshop.util.ConfigReader;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


public class LoginPopUpTest extends TestBase{

    private WebDriver driver;
    private LoginPopUp loginPopUp;
    private Header header;

    @BeforeMethod
    public void setUp() {

        System.out.println("Before Method LoginTest");
        this.driver = StaticHelper.driver;
        driver.get("http://10.40.226.38:8080/jarno/index.php");
        this.header = new Header(driver);
        this.loginPopUp = new LoginPopUp(driver);
    }

    @Test
    public void login() throws IOException, InterruptedException {

        header.linkLogin.click();
        loginPopUp.inputLoginUsername.sendKeys(ConfigReader.getUsername());
        //TimeUnit.SECONDS.sleep(2);
        loginPopUp.inputLoginPassword.sendKeys(ConfigReader.getPassword());
        //TimeUnit.SECONDS.sleep(2);
        loginPopUp.inputLoginSubmit.click();
        //TimeUnit.SECONDS.sleep(2);
        System.out.println("After login Test");
    }
}
