package com.cydeo.tests.officeHours.day07;


import com.cydeo.tests.base.TestBase;
import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class P02_Windows_Tabs extends TestBase {

    @Test
    public void window_test() throws InterruptedException {
        //            - Open "http://automationpractice.com/index.php"
        driver.get("http://automationpractice.com/index.php");
        String currentWindow = driver.getWindowHandle();
        System.out.println(currentWindow);

//            - Click twitter from Follow us
        driver.findElement(By.cssSelector(".twitter")).click();
        currentWindow = driver.getWindowHandle();
        System.out.println(currentWindow); // still the same cause haven't switched \

        // get all window handles
        Set<String> allHandles = driver.getWindowHandles();
        System.out.println(allHandles);


//			- Switch to twitter tab
        for (String eachTab : allHandles) {
            System.out.println(eachTab);
            driver.switchTo().window(eachTab);
            if (driver.getCurrentUrl().contains("twitter")){
                Thread.sleep(6000);
                System.out.println("Driver is here " + driver.getTitle());
                break;
            }
        }

//			- Verify title contains "Selenium Framework"
        String expectedTitle = "Selenium Framework";

        Assert.assertTrue(driver.getTitle().contains(expectedTitle));
//            - Switch to original tab
        driver.switchTo().window(currentWindow);
//			- Verify title equals "My Store"
        String expectedTitle2 = "My Store";
        Assert.assertEquals(driver.getTitle(),(expectedTitle2));

        driver.quit();
    }


}
