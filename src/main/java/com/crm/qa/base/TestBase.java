package com.crm.qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

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
        if(prop.getProperty("browser").equals("chrome"))
        {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));

            driver.get(prop.getProperty("url"));
        }
        else if(prop.getProperty("browser").equals("fireFox"))
        {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));

            driver.get(prop.getProperty("url"));

        } else if (prop.getProperty("browser").equals("edgeBrowser"))
        {
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));

            driver.get(prop.getProperty("url"));

        } else if (prop.getProperty("browser").equals("internetExplorer"))
        {
            driver = new InternetExplorerDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));

            driver.get(prop.getProperty("url"));

        }
    }

}

