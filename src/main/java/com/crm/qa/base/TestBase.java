package com.crm.qa.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import static com.crm.qa.util.TestUtil.IMPLICIT_WAIT;
import static com.crm.qa.util.TestUtil.PAGE_LOAD_TIMEOUT;

public class TestBase {
    public static WebDriver driver;
    public static Properties prop;

    public TestBase()
    {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("src/main/java/com/crm/qa/config/config.properties");
            prop.load(ip);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void initialization()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));

        driver.get(prop.getProperty("url"));
    }

}

