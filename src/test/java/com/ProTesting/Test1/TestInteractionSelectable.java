package com.ProTesting.Test1;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.Point;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.io.File;

/**
 * Created by Administrator on 12/10/2017.
 */
public class TestInteractionSelectable {

    private WebDriver driver;
    private static ExtentReports report;

    @BeforeClass
    public static void init() {
        report = new ExtentReports();
        String fileName = "MyDemoQAReport" + ".html";
        String filePath = System.getProperty("user.dir") + File.separatorChar + fileName;
        report.attachReporter(new ExtentHtmlReporter(filePath));
    }

    @AfterClass
    public static void cleanUp() {
        report.flush();
    }

    @Before
    public void setUp() throws Exception {
        //driver = new ChromeDriver();
        driver = WebDriverFactory.getWebDriver("chrome");
        driver.manage().window().maximize();
        driver.navigate().to("http://demoqa.com ");
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void SelectableDefault(){

        WebElement mDrop = driver.findElement(By.id("menu-item-142"));
        mDrop.click();
        WebElement selectView = driver.findElement(By.cssSelector("#ui-id-1"));
        selectView.click();
        //#selectable > li:nth-child(1)
        WebElement firstItem = driver.findElement(By.cssSelector("#selectable > li:nth-child(1)"));

        String beforeColor = firstItem.getCssValue("color");

        Actions builder = new Actions(driver);
       // builder.dragAndDropBy(dragStyle, 300, 200).perform();
         builder.moveByOffset(200,20).clickAndHold().moveByOffset(380,200).release().perform();

        String afterColor = firstItem.getCssValue("color");

        try{
            assertTrue(beforeColor != afterColor);
            System.out.println("Test passed - Item Selected");
        }catch (AssertionError e){
            System.out.println("Test failed - Item not selected");
        }
        try{
            TimeUnit.SECONDS.sleep(5);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

    }//test
}//class
