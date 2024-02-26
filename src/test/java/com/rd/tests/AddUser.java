package com.rd.tests;

import com.rd.drivers.Driver;
import com.rd.utils.PropertyManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.net.MalformedURLException;


public class AddUser {

    public static WebDriver driver;
    Driver webDriver = new Driver();
    PropertyManager propertyManager= new PropertyManager();
    String url =propertyManager.getProperty("Link_Webtables");



    @BeforeMethod(alwaysRun = true)
    public void before() throws MalformedURLException {
        driver = webDriver.initializeDriver();
        driver.get(url);
    }

    @Test(priority = 1)
    public void addNewUser() throws InterruptedException {
        Thread.sleep(11000);
        WebElement popUp= driver.findElement ( new By.ByCssSelector ( ".fc-button.fc-cta-consent.fc-primary-button" ) );
        popUp.click ();
        WebElement addButton = driver.findElement( new By.ByCssSelector ( "button#addNewRecordButton" ) );
        addButton.click();
        driver.findElement( new By.ByCssSelector ( "input#firstName" )).sendKeys ( "Ali Isa" );
        driver.findElement( new By.ByCssSelector ( "input#lastName" )).sendKeys ( "Tas" );
        driver.findElement( new By.ByCssSelector ( "input#userEmail" )).sendKeys ( "blabla@gmail.com" );
        driver.findElement( new By.ByCssSelector ( "input#age" )).sendKeys ( "31" );
        driver.findElement( new By.ByCssSelector ( "input#salary" )).sendKeys ( "3500" );
        driver.findElement( new By.ByCssSelector ( "input#department" )).sendKeys ( "QA Engineer" );
        WebElement saveButton= driver.findElement ( new By.ByCssSelector("button#submit") );
        saveButton.click ();
    }

    @Test(priority = 2)
    public void editTest() throws InterruptedException {
        Thread.sleep(9000); // Hocam burada baska metod yazilabilir simdilik bu sekilde gecmek istedim

        // Sayfadaki sorundan dolayi varolan kaydi editledim.
        WebElement popUp= driver.findElement ( new By.ByCssSelector ( ".fc-button.fc-cta-consent.fc-primary-button" ) );
        popUp.click ();
        WebElement editButton = driver.findElement( new By.ByCssSelector ( "span#edit-record-3 >svg" ) );
        editButton.click();
        driver.findElement( new By.ByCssSelector ( "input#firstName" )).clear ();
        driver.findElement( new By.ByCssSelector ( "input#firstName" )).sendKeys ( "Ali" );
        driver.findElement( new By.ByCssSelector ( "input#lastName" )).clear ();
        driver.findElement( new By.ByCssSelector ( "input#lastName" )).sendKeys ( "Beli" );
        driver.findElement( new By.ByCssSelector ( "input#userEmail" )).clear ();
        driver.findElement( new By.ByCssSelector ( "input#userEmail" )).sendKeys ( "yeni@gmail.com" );
        driver.findElement( new By.ByCssSelector ( "input#age" )).clear ();
        driver.findElement( new By.ByCssSelector ( "input#age" )).sendKeys ( "32" );
        driver.findElement( new By.ByCssSelector ( "input#salary" )).clear ();
        driver.findElement( new By.ByCssSelector ( "input#salary" )).sendKeys ( "3600" );
        driver.findElement( new By.ByCssSelector ( "input#department" )).clear ();
        driver.findElement( new By.ByCssSelector ( "input#department" )).sendKeys ( "Test Engineer" );
        WebElement saveButton= driver.findElement ( new By.ByCssSelector("button#submit") );
        saveButton.click ();
    }

    @AfterMethod(alwaysRun = true)
    public void  after(){
        webDriver.quitDriver();
    }
}
