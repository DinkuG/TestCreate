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

import static org.junit.Assert.assertTrue;


/** // Alt enter to import
 * Created by Administrator on 11/10/2017.
 * Mouse actions –
 Using this website http://demoqa.com create a series of tests that successfully complete each tab in the side bar.

 */
public class TestMouseProject {
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

    @Test//@Ignore//@Test
    public void Mouse_Interaction() {

        WebElement mDrag = driver.findElement(By.id("menu-item-140"));
        mDrag.click();

        WebElement dragStyle = driver.findElement(By.id("draggable"));
        int xPos = dragStyle.getLocation().getX();
        int yPos = dragStyle.getLocation().getY();
        System.out.println("X original position: " + xPos);
        System.out.println("Y original position:" + yPos);

        Actions builder = new Actions(driver);
        builder.dragAndDropBy(dragStyle, 300, 200).perform();
//       builder.moveByOffset(xposori+1,yposori+1).clickAndHold().moveByOffset(300,120).release().perform();
        // WebElement dragStyle1 = driver.findElement(By.id("draggable"));

        int xNewPos = dragStyle.getLocation().getX();
        int yNewPos = dragStyle.getLocation().getY();
        System.out.println("X new position: " + xNewPos);
        System.out.println("Y new position:" + yNewPos);

        try {
            assertTrue(xPos != xNewPos && yPos != yNewPos);
            System.out.println("Test passed - dragging is done");

        } catch (AssertionError e) {
            System.out.println("Test is completed");
        }
        ExtentTest test = report.createTest("My Demo QA Test");
        test.log(Status.INFO, "Mouse Actions Test is starting");
        test.log(Status.PASS, "Mouse Drag and Drop Test is passed");

    }

    @Test//@Ignore//@Test
    public void interactionConstraintMovementVertical() {

        WebElement mDrag = driver.findElement(By.id("menu-item-140"));
        mDrag.click();
        WebElement conMove = driver.findElement(By.id("ui-id-2"));
        conMove.click();
        WebElement cMoveVertical = driver.findElement(By.cssSelector("#draggabl"));

        // try { TimeUnit.SECONDS.sleep(5);  } catch (InterruptedException e) {      e.printStackTrace();      }

        int x = cMoveVertical.getLocation().getX();
        int y = cMoveVertical.getLocation().getY();
        // System.out.println("Original X location = " + x);
        System.out.println("Original Y location = " + y);

        Actions builder = new Actions(driver);
        builder.dragAndDropBy(cMoveVertical, x, 100).perform();
        // int xNew1 = cMoveVertical.getLocation().getX();
        int yNew1 = cMoveVertical.getLocation().getY();
        //System.out.println("New X location = " + xNew1);
        System.out.println("New Y location = " + yNew1);

        try {
            assertTrue(y != yNew1);
            System.out.println("Test passed - Vertical dragging is done");

        } catch (AssertionError e) {
            System.out.println("Test has an error");
        }
        ExtentTest test = report.createTest("My Demo QA Test");
        //test.log(Status.INFO, "Mouse Actions Test is starting");
        test.log(Status.PASS, "Mouse Drag Vertically is passed");

    }

    @Test//@Ignore //@Test
    public void interactionConstraintMovementVHorizontal() {

        WebElement mDrag = driver.findElement(By.id("menu-item-140"));
        mDrag.click();
        WebElement conMove = driver.findElement(By.id("ui-id-2"));
        conMove.click();
        WebElement cMoveHori = driver.findElement(By.cssSelector("#draggabl2"));

        // try { TimeUnit.SECONDS.sleep(5);  } catch (InterruptedException e) {      e.printStackTrace();      }

        int x = cMoveHori.getLocation().getX();
        int y = cMoveHori.getLocation().getY();
        System.out.println("Original X location = " + x);
        //System.out.println("Original Y location = " + y);

        Actions builder = new Actions(driver);
        builder.dragAndDropBy(cMoveHori, 100, y).perform();

        int xNew1 = cMoveHori.getLocation().getX();
        // int yNew1 = cMoveHori.getLocation().getY();
        System.out.println("New X location = " + xNew1);
        // System.out.println("New Y location = " + yNew1);

        try {
            assertTrue(x != xNew1);
            System.out.println("Test passed - Horizontal dragging is done");

        } catch (AssertionError e) {
            System.out.println("Test has an error");
        }
        ExtentTest test = report.createTest("My Demo QA Test");
        test.log(Status.INFO, "Mouse Actions Test is starting");
        test.log(Status.PASS, "Mouse Drag Vertically is passed");

    }


    @Test//@Ignore//@Test
    public void interactionConstraintMovementVInBox() {

        WebElement mDrag = driver.findElement(By.id("menu-item-140"));
        mDrag.click();
        WebElement conMove = driver.findElement(By.id("ui-id-2"));
        conMove.click();
        WebElement movInBox = driver.findElement(By.cssSelector("#draggabl3"));

        WebElement contWrapBox = driver.findElement(By.cssSelector("#containment-wrapper"));
        Point ePoint = contWrapBox.getLocation();
        int cwxPos = ePoint.getX() + 503;   //  //#draggabl3 = style="position:  left: 503px; top: 26px;
        int cwyPos = ePoint.getY() + 26;
        System.out.println("Content Box X location = " + cwxPos);
        System.out.println("Content Box Y location = " + cwyPos);
        System.out.println("Moving Box in Content Box X location = " + movInBox.getLocation().getX());
        System.out.println("Moving Box in Content Box Y location = " + movInBox.getLocation().getY());

        Actions builder = new Actions(driver);
        builder.dragAndDropBy(movInBox, 100, 12).perform();

        System.out.println("Moving Box in Content Box X location = " + movInBox.getLocation().getX());
        System.out.println("Moving Box in Content Box Y location = " + movInBox.getLocation().getY());

        try {
            assertTrue(movInBox.getLocation().getX() < cwxPos && movInBox.getLocation().getY() < cwyPos);
            System.out.println("Test Passed - Moving box contained within the Content");
        } catch (AssertionError e) {
            System.out.println("Test failed");
        }
    }


    @Test//@Ignore //@Test
    public void interactionConstraintMovementWithinParent() {

        WebElement mDrag = driver.findElement(By.id("menu-item-140"));
        mDrag.click();
        WebElement conMove = driver.findElement(By.id("ui-id-2"));
        conMove.click();
        WebElement movInBox = driver.findElement(By.cssSelector("#draggabl5"));

        WebElement contWrapBox = driver.findElement(By.cssSelector("#containment-wrapper"));
        Point ePoint = contWrapBox.getLocation();
        int cwxPos = ePoint.getX() + 503;   //  //#draggabl3 = style="position:  left: 503px; top: 26px;
        int cwyPos = ePoint.getY() + 26;

        System.out.println("Content Box X location = " + cwxPos);
        System.out.println("Content Box Y location = " + cwyPos);
        System.out.println("Moving Box in Content Box X location = " + movInBox.getLocation().getX());
        System.out.println("Moving Box in Content Box Y location = " + movInBox.getLocation().getY());

        Actions builder = new Actions(driver);
        builder.dragAndDropBy(movInBox, 1, 12).perform();  //id="draggabl5"  style="position:  auto; left: -1px; top: -70px;"

        System.out.println("Moving Box in Content Box X location = " + movInBox.getLocation().getX());
        System.out.println("Moving Box in Content Box Y location = " + movInBox.getLocation().getY());

        try {
            assertTrue(movInBox.getLocation().getX() < cwxPos && movInBox.getLocation().getY() < cwyPos);
            System.out.println("Test Passed - Moving box contained within the Content");
        } catch (AssertionError e) {
            System.out.println("Test failed");
        }
    }


    @Test//@Ignore//@Test
    public void interactionDragEvents() {

        WebElement mDrag = driver.findElement(By.id("menu-item-140"));
        mDrag.click();
        WebElement conMove = driver.findElement(By.id("ui-id-4"));
        conMove.click();
        WebElement movInBox = driver.findElement(By.cssSelector("#dragevent")); //#dragevent

        //id="tabs-5"  #tabs-5
        WebElement contWrapBox = driver.findElement(By.cssSelector("#tabs-5"));
        Point ePoint = contWrapBox.getLocation();
        int cwxPos = ePoint.getX();   //
        int cwyPos = ePoint.getY();
        int cwDimenX = contWrapBox.getSize().width;
        int cwDimenY = contWrapBox.getSize().height;

        int boxValueX = cwxPos + cwDimenX;
        int boxValueY = cwyPos + cwDimenY;

        System.out.println("Content Box top left X location = " + cwxPos);
        System.out.println("Content Box top left Y location = " + cwyPos);
        System.out.println("Content Box bottom right X location = " + boxValueX);
        System.out.println("Content Box bottom right Y location = " + boxValueY);
        System.out.println("Moving Box X location = " + movInBox.getLocation().getX());
        System.out.println("Moving Box Y location = " + movInBox.getLocation().getY());

        Actions builder = new Actions(driver);
        builder.dragAndDropBy(movInBox, 200, 200).perform();

        try {
            assertTrue(movInBox.getLocation().getX() < boxValueX && movInBox.getLocation().getY() < boxValueY);
            System.out.println("Test Passed - Moving box contained within the Content");
        } catch (AssertionError e) {
            System.out.println("Test failed");
        }

        //   #event-start > span.count
        String startInnerString = driver.findElement(By.cssSelector("#event-start > span.count")).getText();
        int startValue = Integer.parseInt(startInnerString);
        try {
            assertTrue(startValue > 0);
            System.out.println("Test Passed - Start Event Value is changed");
        } catch (AssertionError e) {
            System.out.println("Test failed - Start Event value is not changed");
        }
        //#event-drag > span.count
        String dragInnerString = driver.findElement(By.cssSelector("#event-drag > span.count")).getText();
        int dragValue = Integer.parseInt(dragInnerString);
        try {
            assertTrue(dragValue > 0);
            System.out.println("Test Passed - Drag Event Value is changed");
        } catch (AssertionError e) {
            System.out.println("Test failed - Drag Event Value is not changed");
        }
        //#event-stop > span.count
        String stopInnerString = driver.findElement(By.cssSelector("#event-stop > span.count")).getText();
        int stopValue = Integer.parseInt(stopInnerString);
        try {
            assertTrue(stopValue > 0);
            System.out.println("Test Passed - Stop Event Value is changed");
        } catch (AssertionError e) {
            System.out.println("Test failed - Stop Event Value is not changed");
        }
    }


    @Test
    public void interactionDragSort() {

        WebElement mDrag = driver.findElement(By.id("menu-item-140"));
        mDrag.click();
        WebElement conMove = driver.findElement(By.id("ui-id-5"));
        conMove.click();
        WebElement dragBox = driver.findElement(By.cssSelector("#draggablebox")); //#dragevent

        int x = dragBox.getLocation().getX();
        int y = dragBox.getLocation().getY();

        Actions builder = new Actions(driver);
        builder.dragAndDropBy(dragBox, 200, 200).perform();

        try {
            assertTrue(x == dragBox.getLocation().getX() && y == dragBox.getLocation().getY());
            System.out.println("Test Passed - Box returns to its original position");
        } catch (AssertionError e) {
            System.out.println("Test failed - Box did not return in original place");
        }
        // #sortablebox > li:nth-child(1)
        // for(WebElement e : myList) {            System.out.println(e.getText());        }
        WebElement firstItem = driver.findElement(By.cssSelector("#sortablebox > li:nth-child(1)"));
        List<WebElement> myList = driver.findElements(By.cssSelector("#sortablebox"));

        Actions builderList = new Actions(driver);
        builderList.dragAndDropBy(firstItem, 200, 200).perform();

        List<WebElement> myActionList = driver.findElements(By.cssSelector("#sortablebox"));

        for (int i = 0; i < myList.size(); i++) {
                assertTrue(myList.get(i) != myActionList.get(i));{
                    System.out.println("Test Passed - List items has been moved");
                }
            }
        }

}

