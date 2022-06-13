package com.cydeo.tests.officeHours.day05;

import com.cydeo.tests.base.TestBase;;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class P03_MoneyGaming extends TestBase {

    @Test
    public void moneyGaming(){

//        1. Navigate to: https://moneygaming.qa.gameaccount.com/
        driver.get("https://moneygaming.qa.gameaccount.com/");

//        2. Click the JOIN NOW button to open the registration page
        driver.findElement(By.xpath("//a[.='Join Now!']")).click();

//        3. Select a title value from the dropdown
        WebElement titleDropdown = driver.findElement(By.xpath("//select[@id='title']"));
        Select select = new Select(titleDropdown);
        select.selectByVisibleText("Mr");

//        4. Enter your first name and surname in the form
        WebElement firstName = driver.findElement(By.id("forename"));
        firstName.sendKeys("Mike");
        WebElement surname = driver.findElement(By.xpath("//input[@name='map(lastName)']"));
        surname.sendKeys("Smith");

//        5. Check the tick box with text "I accept the Terms and Conditions and certify that I am over the age of 18.
        WebElement checkBox = driver.findElement(By.id("checkbox"));
        checkBox.click();

//        6. Submit the form by clicking the JOIN NOW button
        WebElement joinNow = driver.findElement(By.id("form"));
        joinNow.click();

//        7. Validate that a validation message with text "This field is required" appears under the date of birth box
        WebElement validationMsg = driver.findElement(By.xpath("//label[@for='dob']"));
        Assert.assertEquals(validationMsg.getText(), "This field is required", "Message is wrong");

//        8. Validate that 18 "This field is required" messages  appears
        List<WebElement> allErrorMsg = driver.findElements(By.xpath("//label[.='This field is required']"));
        Assert.assertEquals(allErrorMsg.size(), 18, "wrong size");


    }
}
