package com.demo.coffeeshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = http://10.40.226.38:8080/jarno/index.php
public class Header {

    @FindBy(xpath = "//a[@href='index.php']")
    public WebElement linkHome;

    @FindBy(xpath = "//a[@href='about.php']")
    public WebElement linkAbout;

    @FindBy(xpath = "//a[@href='shop.php']")
    public WebElement linkShop;

    @FindBy(xpath = "//a[@href='#footer']")
    public WebElement linkContact;

    @FindBy(xpath = "//*[@id='shoppingcart']")
    public WebElement svg;

    @FindBy(xpath = "//a[@class='mpshopbtn']")
    public WebElement linkAufZumKaffee;

    @FindBy(xpath = "//a[@href='#']")
    public WebElement linkLogin;

    /*
     * After Login
     */
    @FindBy(xpath = "//a[@href='userprofile.php']")
    public WebElement linkProfile;
    
    

    
    public Header(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

}