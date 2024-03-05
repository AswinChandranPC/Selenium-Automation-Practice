package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

   HomePage homePage ;
   LoginPage loginPage;

   public HomePageTest(){
       super();
   }

   @BeforeMethod
    public void setUp(){
       TestBase.initialization();
       homePage =new HomePage();
       loginPage = new LoginPage();
       homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password") );
   }

    @Test(priority = 1)
    public void homeMenuTest() throws InterruptedException {
       String homePageTitle = homePage.clickHomeMenu();
       Assert.assertEquals(homePageTitle,"Home");
   }

   @Test(priority = 2)
   public void calendarMenuTest() throws InterruptedException {
      String calendarPageTitle = homePage.clickCalendarMenu();
      Assert.assertEquals(calendarPageTitle,"Calendar");
   }

   @Test(priority = 3)
   public void contactsMenuTest() throws InterruptedException {
      String contactsPageTitle = homePage.clickContactsMenu();
      Assert.assertEquals(contactsPageTitle,"Contacts");
   }

   @Test(priority = 4)
   public void companiesMenuTest() throws InterruptedException {
      String companiesPageTitle = homePage.clickCompaniesMenu();
      Assert.assertEquals(companiesPageTitle,"Companies");
   }

   @Test(priority = 5)
   public void dealsMenuTest() throws InterruptedException {
      String dealsPageTitle = homePage.clickDealsMenu();
      Assert.assertEquals(dealsPageTitle,"Deals");
   }

   @Test(priority = 6)
   public void tasksMenuTest() throws InterruptedException {
      String tasksPageTitle = homePage.clickTasksMenu();
      Assert.assertEquals(tasksPageTitle,"Tasks");
   }

   @Test(priority = 7)
   public void casesMenuTest() throws InterruptedException {
      String casesPageTitle = homePage.clickCasesMenu();
      Assert.assertEquals(casesPageTitle,"Cases");
   }

   @Test(priority = 8)
   public void callsMenuTest() throws InterruptedException {
      String callsPageTitle = homePage.clickCallsMenu();
      Assert.assertEquals(callsPageTitle,"Calls");
   }

   @Test(priority = 9)
   public void documentsMenuTest() throws InterruptedException {
      String documentsPageTitle = homePage.clickDocumentsMenu();
      Assert.assertEquals(documentsPageTitle,"Documents");
   }

   @Test(priority = 10)
   public void emailMenuTest() throws InterruptedException {
      String emailPageTitle = homePage.clickEmailMenu();
      Assert.assertEquals(emailPageTitle,"Email");
   }

   @Test(priority = 11)
   public void campaignsMenuTest() throws InterruptedException {
      String campaignsPageTitle = homePage.clickCampaignsMenu();
      Assert.assertEquals(campaignsPageTitle,"Campaigns");
   }

   @Test(priority = 12)
   public void formsMenuTest() throws InterruptedException {
      String formsPageTitle = homePage.clickFormsMenu();
      Assert.assertEquals(formsPageTitle,"Forms");
   }

   @AfterMethod
   public void tearDown(){
      driver.close();
   }
}
