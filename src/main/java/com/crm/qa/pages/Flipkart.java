package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;


public class Flipkart extends TestBase
{

    @FindBy(xpath = "//input[@placeholder='Search for Products, Brands and More']")
    WebElement searchTxtBox;
    @FindBy(xpath = "//button[@type='submit']//*[name()='svg']")
    WebElement searchBtn;
    public Flipkart() {
        PageFactory.initElements(driver, this);
    }


    public void setSearchTxtBox(){
        searchTxtBox.sendKeys("Iphone 15");
        searchBtn.click();
        List<WebElement> list = new ArrayList<>();
                list=driver.findElements(By.xpath("//div[normalize-space()='Apple iPhone 15 (Blue, 128 GB)']"));
        System.out.println(list);
        driver.findElement(By.xpath(list.get(0).getText()));
    }



}
