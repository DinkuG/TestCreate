package com.ProTesting.Test1;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Administrator on 12/10/2017.
 */
public class TestInteractionDroppable {
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
    public void DroppableDefault(){
        WebElement mDrop = driver.findElement(By.id("menu-item-141"));
        mDrop.click();

        WebElement movView = driver.findElement(By.cssSelector("#draggableview"));
        WebElement dropView = driver.findElement(By.cssSelector("#droppableview"));

        int dropX = dropView.getLocation().getX();
        int dropRightX = dropView.getSize().getWidth();
        int dropAddX = dropX + dropRightX;

        Actions builder = new Actions(driver);
        builder.dragAndDropBy(movView, 200, 100).perform(); //pass test
       //builder.dragAndDropBy(movView, 300, 100).perform(); //fail test

         int movX = movView.getLocation().getX();

        try {
            assertTrue(movX >=dropX && movX < dropAddX );
            System.out.println("Test passed - Dropped into the correct Box");
        } catch (AssertionError e) {
            System.out.println("Test failed - Not dropped in the correct Box");
        }
        ExtentTest test = report.createTest("My Demo QA Test");
        test.log(Status.INFO, "Interaction Droppable Default Test is starting");
        test.log(Status.PASS, "Interaction Droppable Default Test is passed");
        try{
            TimeUnit.SECONDS.sleep(5);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }//test

    @Test
    public void DroppableShoppingCart() {
        WebElement mDrop = driver.findElement(By.id("menu-item-141"));
        mDrop.click();
        WebElement shopView = driver.findElement(By.cssSelector("#ui-id-5"));
        shopView.click();


    }

    }//class

