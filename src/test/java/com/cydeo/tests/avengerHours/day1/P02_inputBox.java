package com.cydeo.tests.avengerHours.day1;

import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class P02_inputBox extends TestBase {

    @Test
    public void searchName(){
        /*
        Task 2  -- SearchName inputBox

            1-Navigate to website "http://www.uitestpractice.com/";
            2-Click on Home tab
            3-Search for the name "Mike Johnson"
            4-Verify "There are zero students with this search text Page 0 of 0" msg displayed on page

         */
        driver.get("http://www.uitestpractice.com/");
        driver.findElement(By.xpath("//a[.='Home']")).click();
        driver.findElement(By.id("Search_Data")).sendKeys("Mike Johnson" + Keys.ENTER);
        WebElement msg = driver.findElement(By.xpath("//div[2]/div[1]"));
        String expected = "There are zero students with this search text Page 0 of 0";
        Assert.assertTrue(msg.getText().contains(expected));



    }
}
