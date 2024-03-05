package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.crm.qa.util.TestUtil.highlightElement;

public class LoginPageTest extends TestBase {
    static LoginPage loginPage;
    HomePage homePage;

    public LoginPageTest() {
        super();
    }

    @Test(priority = 4)
    public static void signInWithGoogleTest() throws InterruptedException {
        String signInPageTitle = loginPage.signInWithGoogle().getTitle();
        Assert.assertEquals(signInPageTitle, "Sign in - Google Accounts");
    }

    @Test(priority = 5)
    public static void forgotPasswordTest() throws InterruptedException {
        WebElement forgotPasswordPageTitle = loginPage.forgotPassword();
        highlightElement(driver,forgotPasswordPageTitle);
        Assert.assertEquals(forgotPasswordPageTitle.getText(), "Forgot my password");
    }

    @BeforeMethod
    public void setUp() {
        TestBase.initialization();
        loginPage = new LoginPage();
        homePage = new HomePage();
    }

    @Test(priority = 1)
    public void loginPageTitleTest() {
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title, "Cogmento CRM");
    }

    @Test(priority = 2)
    public void loginTest() throws InterruptedException {
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        WebElement title = homePage.getPageTitle();
        System.out.println(title.getText());
        highlightElement(driver,title);
        Assert.assertEquals(title.getText(), "Aswin PC");
    }

    @Test(priority = 3)
    public void invalidLoginTest() throws InterruptedException {
        WebElement errorMsg = loginPage.invalidLogin(prop.getProperty("username"), prop.getProperty("wrongpass"));
        String errorText = errorMsg.getText();
        highlightElement(driver,errorMsg);
        Assert.assertEquals(errorText, "Something went wrong...");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
