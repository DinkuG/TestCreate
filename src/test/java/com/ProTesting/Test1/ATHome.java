package com.ProTesting.Test1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Administrator on 13/10/2017.
 */
public class ATHome {


    @FindBy(xpath = "//*[@id=\"postcode\"]")
    WebElement postcode;

    @FindBy(css = "#searchVehiclesCount")
    WebElement search;

    @FindBy(css = "#js-header-nav > ul > li.header__nav-listing.header__nav-my-at > div > a")
    WebElement signin;


    public WebElement getSearch(){
        return search;
    }

    public void fillOut(String info){
        postcode.sendKeys(info);
    }

    public WebElement getSignin(){
        return signin;
    }

}
