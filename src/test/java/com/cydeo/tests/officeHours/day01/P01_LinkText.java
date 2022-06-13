package com.cydeo.tests.officeHours.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P01_LinkText {
    public static void main(String[] args) throws InterruptedException {
/*

    1- Open a chrome browser
    2- Go to: https://practice.cydeo.com/
    3- Click to Multiple Buttons   (by using linkText locator)
    4- Verify title equals:
       Expected: Multiple Buttons
    5- Go back to home page by using the .back();
    6- Verify title equals:
       Expected: Practice

 */

        /*
        When you got the task

        1. Read and try to understand the requirements
        2. Manually execute this task

            - Functionality should not be broken (needs to work well)
            - Is this automatable
            - If yes then automate it
         */

        /*
        Locators -> milestones of selenium

        How many types of locators do we have?
        8
            1. ID
            2. Name
            3. ClassName
            4. TagName
            5. LinkText
            6. PartialLinkText
            7. XPath
            8. CSS
         */

        // first i need to set up the driver
        WebDriverManager.chromedriver().setup();

        // create an instance
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com");

        WebElement multiple_buttons = driver.findElement(By.linkText("Multiple Buttons"));
        multiple_buttons.click();

       // driver.findElement(By.linkText("Multiple Buttons")).click(); can also do chaining

        Thread.sleep(3000);

        String expectedTitle = "Multiple Buttons";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }

        driver.navigate().back();

        Thread.sleep(3000);

        expectedTitle = "Practice";
        actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Passed");
        }else {
            System.out.println("failed");
        }

        Thread.sleep(3000);

        driver.quit();

    }


}
