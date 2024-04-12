package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Flipkart;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FlipkartSearchTest extends TestBase
{
    Flipkart flipkart;

    public FlipkartSearchTest(){
        super();
    }
    @BeforeMethod
    public void setUp() {
        TestBase.initialization();
        flipkart = new Flipkart();
    }
    @Test()
    public void flipkartTest(){
        flipkart.setSearchTxtBox();
    }

    @AfterMethod()
    public void tearDown(){
        driver.quit();
    }
}
