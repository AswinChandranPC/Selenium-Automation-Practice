package com.crm.qa.util;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class TestUtil extends TestBase {
    public static long PAGE_LOAD_TIMEOUT = 120;
    public static long IMPLICIT_WAIT = 60;
    public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));

    public static WebElement waitForElement(WebElement element) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        if (wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled())
            return element;
        return null;
    }

    public static void highlightElement(WebDriver driver, WebElement element) throws InterruptedException {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", element);
        Thread.sleep(5000);
    }

    public static void hoverMouseOnWebelement(WebDriver driver, WebElement element){

        //Creating object of an Actions class
        Actions action = new Actions(driver);

        //Performing the mouse hover action on the target element.
        action.moveToElement(element).perform();
    }

}
