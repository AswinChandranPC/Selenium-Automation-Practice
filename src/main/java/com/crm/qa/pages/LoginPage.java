package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.Objects;
import java.util.Set;


public class LoginPage extends TestBase {

    //Page Factory - OR:
    @FindBy(name = "email")
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//div[contains(text(),'Login')]")
    WebElement loginBtn;

    @FindBy(xpath = "/html/body/div/div/div/div[1]/div/div")
    WebElement signinWithGoogleBtn;
    @FindBy(linkText = "Forgot your password?")
    WebElement forgotPassword;

    @FindBy(xpath = "//h2[contains(text(),'Forgot my password')]")
    WebElement forgotPasswordTitle;

    @FindBy(xpath = "//div[contains(text(),'Something went wrong...')]")
    WebElement errorMsg;

    //Initializing the Page Objects:
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    //Actions:
    public String validateLoginPageTitle() {
        return driver.getTitle();
    }

    public HomePage login(String un, String pwd) {
        username.sendKeys(un);
        password.sendKeys(pwd);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", loginBtn);
        return new HomePage();
    }

    public WebElement invalidLogin(String un, String pwd) throws InterruptedException {
        username.sendKeys(un);
        password.sendKeys(pwd);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", loginBtn);
        Thread.sleep(5000);

        return errorMsg;
    }

    public WebDriver signInWithGoogle() throws InterruptedException {
        System.out.println(signinWithGoogleBtn.getText());
        Objects.requireNonNull(TestUtil.waitForElement(signinWithGoogleBtn)).click();
        Thread.sleep(5000);
        String parent = driver.getWindowHandle();
        Set<String> s = driver.getWindowHandles();
        for (String child_window : s) {

            if (!parent.equals(child_window)) {
                driver.switchTo().window(child_window);
                System.out.println(driver.switchTo().window(child_window).getTitle());
                return driver.switchTo().window(child_window);
            }
        }
        driver.switchTo().window(parent);
        driver.close();
        return null;
    }

    public WebElement forgotPassword() {
        TestUtil.waitForElement(forgotPassword).click();
        System.out.println(TestUtil.waitForElement(forgotPasswordTitle).getText());
        return TestUtil.waitForElement(forgotPasswordTitle);
    }


}
