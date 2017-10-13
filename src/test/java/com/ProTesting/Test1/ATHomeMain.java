package com.ProTesting.Test1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by Administrator on 13/10/2017.
 */
public class ATHomeMain {

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = WebDriverFactory.getWebDriver("chrome");
        driver.manage().window().maximize();
        driver.navigate().to("https://www.autotrader.co.uk/");
    }
    @After
    public void tearDown() {  driver.close();   }

    @Test
    public void TestSearch(){
        ATHome home = PageFactory.initElements(driver, ATHome.class);
        String homePageUrl = driver.getCurrentUrl();

        home.fillOut("M15 4GB");
        WebElement search = home.getSearch();
        search.click();
        SearchPage sp = PageFactory.initElements(driver, SearchPage.class);
        String nextPage = sp.getSearchTitle().getText();

       // String curPage = driver.navigate().

        try{
            assertEquals("Message","Search Results", nextPage);
            assertNotEquals("Message",homePageUrl,driver.getCurrentUrl());
            System.out.println("Test passed - Right Page");
        }catch(AssertionError e){
            System.out.println("Test failed - Not on right page");
        }
    }


}//class
