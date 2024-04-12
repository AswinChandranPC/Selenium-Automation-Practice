package com.crm.qa.util;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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

    public static String keystroke(String str, String[] input) {
        if (str != null) {
            input[0] = str;
        }

        // Base case
        if (input[0] == null)
            return null;

        // Pattern to match camel case words
        Pattern pattern = Pattern.compile("[A-Z]?[a-z]+|[A-Z]+(?![a-z])|Test");
        Matcher matcher = pattern.matcher(input[0]);

        StringBuilder output = new StringBuilder();

        // Generating Tokens
        while (matcher.find()) {
            String token = matcher.group();
            // Skip "Test"
            if (!token.equalsIgnoreCase("Test")) {
                output.append(capitalizeFirstLetter(token)).append(" ");
            }
        }

        input[0] = null;
        return output.toString().trim();
    }

    // Function to capitalize the first letter of a string
    public static String capitalizeFirstLetter(String word) {
        return Character.toUpperCase(word.charAt(0)) + word.substring(1);
    }

    // Function to extract words and remove "Test"
    public static String extractWords(String s) {
        StringBuilder newWords = new StringBuilder();
        String[] input = new String[1];
        String ptr = keystroke(s, input);

        // Extract the remaining words
        while (ptr != null) {
            newWords.append(ptr).append(" ");
            ptr = keystroke(null, input);
        }
        return newWords.toString().trim();
    }
}
