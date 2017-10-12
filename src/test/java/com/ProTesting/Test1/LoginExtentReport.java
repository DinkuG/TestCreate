package com.ProTesting.Test1;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

 

public class LoginExtentReport {
	
	private WebDriver driver;
	private static ExtentReports report;
	 private Workbook workbook;
	 
	 
	 	public String take(WebDriver webDri, String fileName) throws IOException{
		File scrfile = ((TakesScreenshot)webDri).getScreenshotAs(OutputType.FILE);
		String pathname = System.getProperty("user.dir") + File.separatorChar + fileName + ".jpg";
		FileUtils.copyFile(scrfile, new File(pathname));
		System.out.println("File saved at: " + pathname);
		return pathname;		
	}
	
	@BeforeClass
	public static void init(){
		report = new ExtentReports();
		String fileName = "MyLoginExtentReport" + ".html";
		String filePath = System.getProperty("user.dir") + File.separatorChar + fileName;
		report.attachReporter(new ExtentHtmlReporter(filePath));			
		
	}
	
	@AfterClass
	public static void cleanUp(){ report.flush();}
	
	@Before
	public void setUp() throws Exception {
		//driver = new ChromeDriver();
		driver = WebDriverFactory.getWebDriver("chrome");
		driver.manage().window().maximize();
		}

	@After
	public void tearDown() throws Exception {
			driver.quit();
	}

	@Test
	public void userlogintest() {
		//fail("Not yet implemented");
		
		driver.navigate().to(" http://thedemosite.co.uk");
		WebElement adduser = driver.findElement(By.cssSelector("body > div:nth-child(1) > center:nth-child(1) > table:nth-child(6) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(1) > div:nth-child(2) > center:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > p:nth-child(1) > small:nth-child(1) > a:nth-child(6)"));
		adduser.click();
		
		WebElement usernamelement = driver.findElement(By.cssSelector(".auto-style1 > form:nth-child(6) > div:nth-child(1) > center:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > center:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > p:nth-child(1) > input:nth-child(1)"));
		usernamelement.sendKeys("ashley");
		
		WebElement pwdelement = driver.findElement(By.cssSelector(".auto-style1 > form:nth-child(6) > div:nth-child(1) > center:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > center:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2) > p:nth-child(1) > input:nth-child(1)"));
		pwdelement.sendKeys("1234");
		
		WebElement savelement = driver.findElement(By.cssSelector(".auto-style1 > form:nth-child(6) > div:nth-child(1) > center:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > center:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(2) > p:nth-child(1) > input:nth-child(1)"));
		savelement.click();
		
		assertTrue("The save button is clicked",driver.findElement(By.cssSelector(".auto-style1 > blockquote:nth-child(5) > blockquote:nth-child(2) > blockquote:nth-child(1) > b:nth-child(1)")).isDisplayed());
		
 		ExtentTest test = report.createTest("MySecondTest");
	    test.log(Status.INFO, "My Second test is starting");
	    
	    assertTrue(true);
	    String imagePath = null;
		try {
			imagePath = take(driver,"image");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    try {
	    	if(imagePath != null){
	    		//test.addScreenCaptureFromPath(imagePath);
	    		test.addScreenCaptureFromPath(imagePath);
	    	}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try{
			TimeUnit.SECONDS.sleep(1);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	
		
		 
	}
	@Test
    public void spreadSheet(){
       Reader sheetReader = new Reader("C:/Users/Administrator/Desktop/testexample/TestCreate/TestBook.xlsx");
        List<String> row = sheetReader.readRow(1, "InputData");

        for(String cell : row){
            System.out.println(cell);
        }


    }
}
