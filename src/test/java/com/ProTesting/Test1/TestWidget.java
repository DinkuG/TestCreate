package com.ProTesting.Test1;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Created by Administrator on 12/10/2017.
 */
public class TestWidget {

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

        WebElement mDrop = driver.findElement(By.cssSelector("#menu-item-97"));
        mDrop.click();
        WebElement selectView = driver.findElement(By.cssSelector("#ui-id-1"));
        selectView.click();

        WebElement numValue = driver.findElement(By.cssSelector("#amount1"));
        String x = numValue.getAttribute("value");
        System.out.println("Slider value = "+ x);

        WebElement firstItem = driver.findElement(By.cssSelector("#slider-range-max > span")); //

        Actions builder = new Actions(driver);
        builder.dragAndDropBy(firstItem, 70, 0).perform();

        String y = numValue.getAttribute("value");
        System.out.println("Slider value = "+ y);


        try{
            assertTrue( x != y);
            System.out.println("Test passed - Slider action is performed");
        }catch (AssertionError e){
            System.out.println("Test failed - Slider action is not performed");
        }
        try{
            TimeUnit.SECONDS.sleep(5);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

    }//test
}//class



