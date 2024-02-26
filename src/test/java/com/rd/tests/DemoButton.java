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
    public void openGooglePageTest() {
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle,"DEMOQA");
    }

    @Test(priority = 1)
    public void clickButtons(){
        WebElement userName = driver.findElement( new By.ByXPath  ( "//span[contains(text(),'Buttons')]" ) );
        userName.click ();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://demoqa.com/buttons" );

    }

    @Test(priority = 2)
    public void checkMessage() throws InterruptedException {
        Thread.sleep(7000); // Hocam burada baska metod yazilabilir simdilik bu sekilde gecmek istedim
        WebElement popUp= driver.findElement ( new By.ByCssSelector ( ".fc-button.fc-cta-consent.fc-primary-button" ) );
        popUp.click ();
        WebElement userName = driver.findElement( new By.ByXPath ( "//span[contains(text(),'Buttons')]" ) );
        userName.click ();
        WebElement clickMeButton = driver.findElement( new By.ByXPath ("(//*[contains(text(),'Click Me')])[3]"));
        clickMeButton.click ();
        WebElement getTextMessage= driver.findElement (new By.ById ("dynamicClickMessage"));
        String actualElement = getTextMessage.getText ();
        String expectedElementText = "You have done a dynamic click";
        Assert.assertEquals(actualElement,expectedElementText,"Expected and Actual are not same");
    }

    @AfterMethod(alwaysRun = true)
    public void  after(){
        webDriver.quitDriver();
    }
}
