package com.tests;

import com.driver.DriverManager;
import com.utils.EnvConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {

    public static String searchEngine;
    public static WebDriver driver = null;

    @BeforeTest(alwaysRun = true)
    @Parameters({"browser", "engine"})
    public void startUp(String browser, String engine) {
        searchEngine = engine;
        //String browser = System.getProperty("browser");
        //searchEngine = System.getProperty("searchEngine");
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            DriverManager.setWebDriver(driver);
        }
        EnvConfig.loadJson(searchEngine);
        EnvConfig.loadEnvData(searchEngine);
        assert driver != null;
        driver.get(EnvConfig.getEnvJsonElement(searchEngine));
        driver.manage().window().maximize();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
