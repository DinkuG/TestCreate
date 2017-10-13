package com.ProTesting.Test1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 13/10/2017.
 */
public class SignUp {

   // @FindBy(id="js-header-nav/ul/li[5]/div/a")
    @FindBy(linkText = "Sign in")
    WebElement signIn;

    @FindBy(css = "#js-social__signup-tab > span")
    WebElement signUpTab;

    @FindBy(css = "#email")
    WebElement userEmail;     //#email #email

    @FindBy(css = "#password")  //#password
    WebElement userPwd;

    @FindBy(css = "#social--signup--submit")   //#social--signup--submit  //#social--signup--submit
    WebElement signUpNow;

    public WebElement getSignIn() {
        return signIn;
    }

    public void setUserEmail(String info) {
        //this.userEmail = userEmail;
        userEmail.sendKeys(info);
    }

    public void setUserPwd(String info) {
       // this.userPwd = userPwd;
        userPwd.sendKeys(info);
    }

    public WebElement getSignInNow() {
        return signUpNow;
    }
}
