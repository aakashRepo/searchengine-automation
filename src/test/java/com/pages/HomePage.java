package com.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@aria-label=\"Search\"]")
    WebElement searchBox_Google;
    @FindBy(xpath = "//input[@id='sb_form_q']")
    WebElement searchBox_Bing;
    @FindBy(xpath = "//input[@id='yschsp']")
    WebElement searchBox_Yahoo;
    WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean verifyUserLandedOnHomePage(String engine) {
        switch (engine) {
            case "google":
                if (searchBox_Google.isDisplayed())
                    return true;
                break;
            case "bing":
                if (searchBox_Bing.isDisplayed())
                    return true;
                break;
            case "yahoo":
                if (searchBox_Yahoo.isDisplayed())
                    return true;
                break;
        }
        return false;
    }

    public void searchTerm(String engine, String search) {
        switch (engine) {
            case "google":
                searchBox_Google.sendKeys(search);
                searchBox_Google.sendKeys(Keys.ENTER);
                break;
            case "bing":
                searchBox_Bing.sendKeys(search);
                searchBox_Bing.sendKeys(Keys.ENTER);
                break;
            case "yahoo":
                searchBox_Yahoo.sendKeys(search);
                searchBox_Yahoo.sendKeys(Keys.ENTER);
                break;
        }
    }
}
