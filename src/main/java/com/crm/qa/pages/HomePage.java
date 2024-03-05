package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.crm.qa.util.TestUtil.highlightElement;
import static com.crm.qa.util.TestUtil.hoverMouseOnWebelement;

public class HomePage extends TestBase {

    @FindBy(xpath = "//body/div[@id='ui']/div[1]/div[1]/div[1]/a[1]/i[1]")
    private WebElement mainMenu;

    @FindBy(xpath = "//div[1]/a[1]/span[1]")
    private WebElement homeMenu;

    @FindBy(xpath = "//div[2]/a[1]/span[1]")
    private WebElement calendarMenu;

    @FindBy(xpath = "//div[3]/a[1]/span[1]")
    private WebElement contactsMenu;

    @FindBy(xpath = "//div[4]/a[1]/span[1]")
    private WebElement companiesMenu;

    @FindBy(xpath = "//div[5]/a[1]/span[1]")
    private WebElement dealsMenu;

    @FindBy(xpath = "//div[6]/a[1]/span[1]")
    private WebElement tasksMenu;

    @FindBy(xpath = "//div[7]/a[1]/span[1]")
    private WebElement casesMenu;

    @FindBy(xpath = "//div[8]/a[1]/span[1]")
    private WebElement callsMenu;

    @FindBy(xpath = "//div[9]/a[1]/span[1]")
    private WebElement documentsMenu;

    @FindBy(xpath = "//div[10]/a[1]/span[1]")
    private WebElement emailMenu;

    @FindBy(xpath = "//div[11]/a[1]/span[1]")
    WebElement campaignsMenu;

    @FindBy(xpath = "//div[12]/a[1]/span[1]")
    private WebElement formsMenu;

    @FindBy(xpath = "//div[13]/a[1]/span[1]")
    private WebElement reportsMenu;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }
    public WebElement getPageTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Aswin PC')]")));
        if (e.isDisplayed()){
            return e;
        }
        return null;
    }

    public String clickHomeMenu() throws InterruptedException
    {
        hoverMouseOnWebelement(driver, mainMenu);
        highlightElement(driver,homeMenu);
        return homeMenu.getText();
    }

    public String clickCalendarMenu() throws InterruptedException
    {
        hoverMouseOnWebelement(driver, mainMenu);
        highlightElement(driver,calendarMenu);
        return calendarMenu.getText();
    }

    public String clickContactsMenu() throws InterruptedException
    {
        hoverMouseOnWebelement(driver, mainMenu);
        highlightElement(driver,contactsMenu);
        return contactsMenu.getText();
    }

    public String clickCompaniesMenu() throws InterruptedException
    {
        hoverMouseOnWebelement(driver, mainMenu);
        highlightElement(driver,companiesMenu);
        return companiesMenu.getText();
    }

    public String clickDealsMenu() throws InterruptedException
    {
        hoverMouseOnWebelement(driver, mainMenu);
        highlightElement(driver,dealsMenu);
        return dealsMenu.getText();
    }

    public String clickTasksMenu() throws InterruptedException
    {
        hoverMouseOnWebelement(driver, mainMenu);
        highlightElement(driver,tasksMenu);
        return tasksMenu.getText();
    }

    public String clickCasesMenu() throws InterruptedException
    {
        hoverMouseOnWebelement(driver, mainMenu);
        highlightElement(driver,casesMenu);
        return casesMenu.getText();
    }

    public String clickCallsMenu() throws InterruptedException
    {
        hoverMouseOnWebelement(driver, mainMenu);
        highlightElement(driver,callsMenu);
        return callsMenu.getText();
    }

    public String clickDocumentsMenu() throws InterruptedException
    {
        hoverMouseOnWebelement(driver, mainMenu);
        highlightElement(driver,documentsMenu);
        return documentsMenu.getText();
    }

    public String clickEmailMenu() throws InterruptedException
    {
        hoverMouseOnWebelement(driver, mainMenu);
        highlightElement(driver,emailMenu);
        return emailMenu.getText();
    }

    public String clickCampaignsMenu() throws InterruptedException
    {
        hoverMouseOnWebelement(driver, mainMenu);
        highlightElement(driver,campaignsMenu);
        return campaignsMenu.getText();
    }

    public String clickFormsMenu() throws InterruptedException
    {
        hoverMouseOnWebelement(driver, mainMenu);
        highlightElement(driver,formsMenu);
        return formsMenu.getText();
    }
}
