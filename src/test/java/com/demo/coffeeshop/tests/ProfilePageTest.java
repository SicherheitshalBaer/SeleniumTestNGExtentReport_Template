package com.demo.coffeeshop.tests;

import com.demo.coffeeshop.base.TestBase;
import com.demo.coffeeshop.base.StaticHelper;
import com.demo.coffeeshop.pages.Header;
import com.demo.coffeeshop.pages.ProfilePage;
import com.demo.coffeeshop.util.ConfigReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ProfilePageTest extends TestBase {

    private WebDriver driver;

    private ProfilePage profilePage;
    private LoginPopUpTest loginPopUpTest;
    private Header header;


    @BeforeTest
    public void setUp() {
        System.out.println("Before Method ProfilePageTest");
        try {
            loginPopUpTest = new LoginPopUpTest();
            loginPopUpTest.setUp();
            loginPopUpTest.login();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void changeProfileSettings() throws InterruptedException, IOException {


        this.driver = StaticHelper.driver;
        this.header = new Header(this.driver);
        this.profilePage = new ProfilePage(driver);

        this.header.linkProfile.click();

        this.profilePage.inputUdinputVorname.clear();
        //TimeUnit.SECONDS.sleep(2);
        this.profilePage.inputUdinputVorname.sendKeys(ConfigReader.getValue("firstname"));
        //TimeUnit.SECONDS.sleep(2);
        this.profilePage.inputUdinputNachname.clear();
        //TimeUnit.SECONDS.sleep(2);
        this.profilePage.inputUdinputNachname.sendKeys(ConfigReader.getValue("lastname"));
        //TimeUnit.SECONDS.sleep(2);
        this.profilePage.inputUdinputEmail.clear();
        this.profilePage.inputUdinputEmail.sendKeys(ConfigReader.getValue("email"));


        for(int i = 18; i < 100; i++){
            this.profilePage.slider.sendKeys(Keys.LEFT);
        }
        for(int i = 18; i < Integer.parseInt(ConfigReader.getValue("age")); i++){
            this.profilePage.slider.sendKeys(Keys.RIGHT);
        }

        String gender = ConfigReader.getValue("gender");
        if ( gender.equals("male")) {
            this.profilePage.labelMaennlich.click();
        } else if (gender.equals("female")) {
            this.profilePage.labelWeiblich.click();
        } else if ( gender.equals("divers")) {
            this.profilePage.labelDivers.click();
        } else {
            this.profilePage.labelKeineAngabe.click();
        }
        this.profilePage.inputUdinputAdress.clear();
        this.profilePage.inputUdinputAdress.sendKeys(ConfigReader.getValue("address"));
        this.profilePage.inputUdinputPLZ.clear();
        this.profilePage.inputUdinputPLZ.sendKeys(ConfigReader.getValue("plz"));
        this.profilePage.inputUdinputCity.clear();
        this.profilePage.inputUdinputCity.sendKeys(ConfigReader.getValue("city"));
        this.profilePage.selectUdinputLand.sendKeys(ConfigReader.getValue("country"));
        this.profilePage.selectUdinputLand.click();
        this.profilePage.saveBtn.click();
        //TimeUnit.SECONDS.sleep(5);

        this.profilePage.confirmationPopUpBtn.click();
    }

}
