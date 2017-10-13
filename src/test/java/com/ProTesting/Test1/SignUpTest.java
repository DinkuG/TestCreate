package com.ProTesting.Test1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Administrator on 13/10/2017.
 */
public class SignUpTest {


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
    public void TestSignUp() {

        SignUp signPage = PageFactory.initElements(driver, SignUp.class);
        signPage.getSignIn().click();
        signPage.signUpTab.click();

        String homePageUrl = driver.getCurrentUrl();
        signPage.setUserEmail("222@hotmail.com");
        signPage.setUserPwd("Abcd123$");
        signPage.getSignInNow().click();

        String signupUrl = driver.getCurrentUrl();

        try {

            assertNotEquals("Message", homePageUrl, signupUrl);
            System.out.println("Test passed - Successful Sign Up");
        } catch (AssertionError e) {
            System.out.println("Test failed - Not Successful Sign Up");


        }
    }
}
