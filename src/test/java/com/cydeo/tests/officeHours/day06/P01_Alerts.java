package com.cydeo.tests.officeHours.day06;

import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class P01_Alerts extends TestBase {

    @Test
    public void htmlAlerts() {
        // - Open "https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=5f126"
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=5f126");

        // - Click Confirm button
        driver.findElement(By.xpath("//span[.='Confirm']")).click();

        // - Click YES from pop up
        driver.findElement(By.xpath("//span[.=\"Yes\"]")).click();

        // - Verify message equals "You have accepted"
        String expected = "You have accepted";

        String actual = driver.findElement(By.xpath("//p[.='You have accepted']")).getText();

        Assert.assertEquals(actual,expected);

    }

    @Test
    public void jsAlerts() {
        /*
        Task 2  -- INFORMATION
			- Open "http://www.uitestpractice.com/Students/Switchto"
			- Click Alert
			- Click OK button from Alert
			- Verify message equals "You have clicked on ok button in alert window"
         */
        driver.get("http://www.uitestpractice.com/Students/Switchto");

        //Alert alert=driver.switchTo().alert();  -- if there is no alert it will throw NoAlertPresentException: no such alert
        System.out.println("---- INFORMATION-----");
        driver.findElement(By.cssSelector("#alert")).click();
        Alert alert=driver.switchTo().alert();
        // use Alert to handle it
        alert.accept();

        // Verify message is "You have clicked on ok button in alert window""
        WebElement message = driver.findElement(By.cssSelector("#demo"));
        String actual = message.getText();
        String expected="You have clicked on ok button in alert window";
        Assert.assertEquals(actual,expected);

        System.out.println("---- CONFIRMATION-----");

        /*
         Task 3  -- CONFIRM
			- Open "http://www.uitestpractice.com/Students/Switchto"
			- Click Confirm
			- Click Cancel button from Alert
			- Verify message equals "You pressed Cancel in confirm window"
         */
        driver.findElement(By.cssSelector("#confirm")).click();

        alert.dismiss();

        expected="You pressed Cancel in confirm window";
        // driver.navigate().refresh(); --> cause of this step message element will give StaleElemenException
        actual= message.getText();
        Assert.assertEquals(actual,expected);



        System.out.println("---- PROMPT-----");

    /*
        Task 4  -- PROMPT
                - Open "http://www.uitestpractice.com/Students/Switchto"
                - Click Prompt
                - Send name as "Mike" into this alert field
                - CLick OK
                - Verify  message contains "Mike"

     */
        driver.findElement(By.cssSelector("#prompt")).click();
        String name ="Mike";
        alert.sendKeys(name);
        alert.accept();
        actual= message.getText();
        Assert.assertTrue(actual.contains(name));
    }

}
