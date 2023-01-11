package com.demo.coffeeshop.tests;

import com.demo.coffeeshop.base.TestBase;
import com.demo.coffeeshop.base.StaticHelper;
import com.demo.coffeeshop.pages.Header;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import java.io.IOException;
import java.time.Duration;
import static org.assertj.core.api.Assertions.*;


public class HeaderTest extends TestBase {

    private WebDriver driver;
    private Header header;

    private SoftAssert softAssert = new SoftAssert();


    @BeforeMethod
    public void setUp() {

        System.out.println("Before Method HeaderTest");
        this.driver = StaticHelper.driver;
        driver.get("http://10.40.226.38:8080/jarno/index.php");
        this.header = new Header(driver);
    }

    @Test
    public void links() {

        header.linkHome.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        assertThat("http://10.40.226.38:8080/jarno/index2.php").contains(driver.getCurrentUrl());
        //softAssert.assertEquals(driver.getCurrentUrl(), "http://10.40.226.38:8080/jarno/index2.php");

        header.linkAbout.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        assertThat("http://10.40.226.38:8080/jarno/about.php").contains(driver.getCurrentUrl());
        //softAssert.assertEquals(driver.getCurrentUrl(), "http://10.40.226.38:8080/jarno/about.php");

        header.linkShop.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        assertThat("http://10.40.226.38:8080/jarno/shop.php").contains(driver.getCurrentUrl());
        //softAssert.assertEquals(driver.getCurrentUrl(), "http://10.40.226.38:8080/jarno/shop.php");

        String currentURL = driver.getCurrentUrl();
        header.linkContact.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        String expectedURL = currentURL + "#footer";
        assertThat(expectedURL).contains(driver.getCurrentUrl());
        //softAssert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }

}
