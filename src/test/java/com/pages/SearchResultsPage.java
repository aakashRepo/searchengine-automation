package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//div[@id='rso']/div[1]//a/h3")
    WebElement googleFirstResult;
    @FindBy(xpath = "(//ol[@id='b_results']/li[@class='b_algo']//h2/a)[1]")
    WebElement bingFirstResult;
    @FindBy(xpath = "//div[@id='main']//ol//a[@data-ebf]")
    WebElement yahooFirstResult;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Boolean verifyFirstSearchResultIsCorrect(String searchEngine, String expected) {
        switch (searchEngine) {
            case "google":
                return googleFirstResult.getText().equalsIgnoreCase(expected);
            case "bing":
                return bingFirstResult.getText().equalsIgnoreCase(expected);
            case "yahoo":
                return yahooFirstResult.getText().equalsIgnoreCase(expected);
        }
        return false;
    }

}
