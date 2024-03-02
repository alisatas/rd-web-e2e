package com.rd.tests;

import com.rd.drivers.Driver;
import com.rd.utils.PropertyManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class DemoButton {

    public static WebDriver driver;
    Driver webDriver = new Driver();
    PropertyManager propertyManager= new PropertyManager();
    String url =propertyManager.getProperty("APP_URL");



    @BeforeMethod(alwaysRun = true)
    public void before() throws MalformedURLException {
        driver = webDriver.initializeDriver();
        driver.get(url);
    }

    @Test
    public void openDemoQAPage() {
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle,"DEMOQA");
    }

    @Test(priority = 1)
    public void clickButtons() throws InterruptedException {
        Thread.sleep(7000); // Hocam burada baska metod yazilabilir simdilik bu sekilde gecmek istedim
        WebElement popUp= driver.findElement ( new By.ByCssSelector ( ".fc-button.fc-cta-consent.fc-primary-button" ) );
        popUp.click ();

        WebElement buttonsButton = driver.findElement( new By.ById  ( "div[class='element-list collapse show'] li[class='btn btn-light ']:nth-child(5)" ) );
        buttonsButton.click ();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://demoqa.com/buttons" );
    }

    @Test(priority = 2)
    public void checkMessage() throws InterruptedException {
        Thread.sleep(7000); // Hocam burada baska metod yazilabilir simdilik bu sekilde gecmek istedim
        WebElement popUp= driver.findElement ( new By.ByCssSelector ( ".fc-button.fc-cta-consent.fc-primary-button" ) );
        popUp.click ();
        WebElement buttonsButton = driver.findElement( new By.ByCssSelector  ( "div[class='element-list collapse show'] li[class='btn btn-light ']:nth-child(5)" ) );
        buttonsButton.click ();
        WebElement clickMeButton = driver.findElement( new By.ByCssSelector ("div[class='col-12 mt-4 col-md-6'] div:nth-child(4) button"));
        clickMeButton.click ();
        WebElement getTextMessage= driver.findElement (new By.ByCssSelector ("p[id='dynamicClickMessage']"));
        String actualElement = getTextMessage.getText ();
        String expectedElementText = "You have done a dynamic click";
        Assert.assertEquals(actualElement,expectedElementText,"Actual message is the same with the expected");
    }

    @AfterMethod(alwaysRun = true)
    public void  after(){
        webDriver.quitDriver();
    }
}
