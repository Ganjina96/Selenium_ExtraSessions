package com.cydeo.tests.officeHours.day07;

import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class P03_WebTables extends TestBase {

    @Test
    public void table1_test(){
//          - Open "http://practice.cydeo.com/tables"
        driver.get("http://practice.cydeo.com/tables");
//          - Print out all table headers
        // we use span child because we want to get the text of the headers
        List<WebElement> allTableHeaders = driver.findElements(By.xpath("//table[@id='table1']//span"));
        System.out.println("allTableHeaders.size() = " + allTableHeaders.size());
        for (WebElement eachHeader : allTableHeaders) {
            System.out.println("eachHeader.getText() = " + eachHeader.getText());
        }
//	        - Verify
//	            - Table has 6 header
        Assert.assertEquals(allTableHeaders.size(),6);

    }

    @Test
    public void getRow(){
//	        - Open "http://practice.cydeo.com/tables"
        driver.get("http://practice.cydeo.com/tables");
//            - Print out all table information
        // we need to do tbody cause we only want the body of the table
        List<WebElement> allTableInfo = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println("allTableInfo.size() = " + allTableInfo.size());

        // there is no index 0, we have to start from 1
        // dynamic locator way
        for (int i = 1; i < allTableInfo.size(); i++) {
            String eachRowPath = "//table[@id='table1']/tbody/tr[" + i + "]";
            System.out.println("driver.findElement(By.xpath(eachRowPath)).getText() = " + driver.findElement(By.xpath(eachRowPath)).getText());
        }
//	        - Verify
//	        		- Table has 4 row
        Assert.assertEquals(allTableInfo.size(),4);

    }

    @Test
    public void getInRelation(){
//	        - Open "http://practice.cydeo.com/tables"
        driver.get("http://practice.cydeo.com/tables");
//            - Print out all information for firstname ="Frank"
        List<WebElement> allInfoFrank = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[2]"));
        for (WebElement eachRow : allInfoFrank){
            System.out.println("eachRow.getText() = " + eachRow.getText());
        }


//            - Verify
//	        		- email equals "fbach@yahoo.com"
        String name = "Frank";
        // dynamic locator to get email for username
        String emailLocator = "//table[@id='table1']//td[.='" + name +"']/../td[contains(.,'@')]";
        WebElement email = driver.findElement(By.xpath(emailLocator));
        Assert.assertEquals(email.getText(),"fbach@yahoo.com");
//
//    NOTE : This task needs to work for
//    firstname = Jason
//    email     = jdoe@hotmail.com
    }


}
