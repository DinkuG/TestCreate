package com.ProTesting.Test1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 13/10/2017.
 */
public class SearchPage {

    @FindBy(css = "body > nav > ul > li:nth-child(3)")
    WebElement searchTitle;

    public void setSearchTitle(WebElement searchTitle) {
        this.searchTitle = searchTitle;
    }

    public WebElement getSearchTitle() {
        return searchTitle;
    }
}
