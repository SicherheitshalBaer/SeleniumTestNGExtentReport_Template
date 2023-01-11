package com.demo.coffeeshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = http://10.40.226.38:8080/jarno/userprofile.php
public class ProfilePage {
    @FindBy(xpath = "//*[@id='udinput-vorname']")
    public WebElement inputUdinputVorname;

    @FindBy(xpath = "//*[@id='udinput-nachname']")
    public WebElement inputUdinputNachname;

    @FindBy(xpath = "//*[@id='udinput-email']")
    public WebElement inputUdinputEmail;

    /*
     * Slider
     */
    //@FindBy(xpath = "//div[@class='udsection'][.//*[@id='ud-showage']]")
    @FindBy(xpath = "//form[@id='udinput-form']")
    public WebElement frame;
    
    @FindBy(xpath = "//*[@id='udinput-age']")
    public WebElement slider;

    /*
     * Gender Radio Buttons
     */

    @FindBy(xpath = "//label[@for='udradio-1']")
    public WebElement labelMaennlich;

    @FindBy(xpath = "//label[@for='udradio-2']")
    public WebElement labelWeiblich;

    @FindBy(xpath = "//label[@for='udradio-3']")
    public WebElement labelDivers;

    @FindBy(xpath = "//label[@for='udradio-4']")
    public WebElement labelKeineAngabe;

    @FindBy(xpath = "//*[@id='udinput-adress']")
    public WebElement inputUdinputAdress;

    @FindBy(xpath = "//*[@id='udinput-plz']")
    public WebElement inputUdinputPLZ;

    @FindBy(xpath = "//*[@id='udinput-city']")
    public WebElement inputUdinputCity;

    @FindBy(xpath = "//*[@id='udinput-land']")
    public WebElement selectUdinputLand;

    @FindBy(xpath = "//*[@id='udsavebtn']")
    public WebElement saveBtn;

    @FindBy(xpath = "//*[@id='udcancelbtn']")
    public WebElement cancelBtn;

    @FindBy(xpath = "//button[contains(@onclick, 'php')]")
    public WebElement confirmationPopUpBtn;

    

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}