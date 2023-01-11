package com.demo.coffeeshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = http://10.40.226.38:8080/jarno/index.php#
public class LoginPopUp {
    @FindBy(xpath = "//*[@id='login-username']")
    public WebElement inputLoginUsername;

    @FindBy(xpath = "//*[@id='login-password']")
    public WebElement inputLoginPassword;

    @FindBy(xpath = "//*[@id='login-submit']")
    public WebElement inputLoginSubmit;

    @FindBy(xpath = "//a[@href='userprofile.php']")
    public WebElement linkProfil;



    public LoginPopUp(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}