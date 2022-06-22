package com.cydeo.tests.avengerHours.day1;

import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class P01_isDisplayed extends TestBase {

    @Test
    public void isDisplayed(){
        // Task 1  -- isDisplayed/isEnabled

        //1-Navigate to "http://www.uitestpractice.com/"
        driver.get("http://www.uitestpractice.com/");

        //2-Verify main page is launched;
            //"Testing Controls" Tab should be displayed on left top (visible and enabled)
        WebElement tab = driver.findElement(By.cssSelector(".navbar-brand"));
        Assert.assertTrue(tab.isDisplayed());
        Assert.assertTrue(tab.isEnabled());
    }

}
