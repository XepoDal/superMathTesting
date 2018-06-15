package com.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class game3 extends setUp
{
    By win_close = By.xpath("//*[@id=\"game\"]/div/div[1]/img[1]");
    By num1 = By.id("mo_number_1");
    By num2 = By.id("mo_number_2");
    By result = By.id("mo_result");
    public int result1;
    boolean test;
    //WebDriverWait waitDriver = new WebDriverWait(driver, 10);


    public game3(WebDriver driver)
    {
        this.driver = driver;
    }

    public void WinClose()
    {
        driver.findElement(win_close).click();
    }

    public void checkResult() throws InterruptedException {

        (new WebDriverWait(driver,180)).until(ExpectedConditions.visibilityOfElementLocated(By.id("mo_smile_img_id")));
        String str1 = driver.findElement(num1).getText();
        String str2 = driver.findElement(num2).getText();
        String str3 = driver.findElement(result).getText();
        String str4 = driver.findElement(By.id("mo_operation")).getText();
        if (str4.equals("x")) {
            result1 = Integer.parseInt(str1.trim()) * Integer.parseInt(str2.trim());
        }
        if ((str3.equals(String.valueOf(result1)))) {
            test = true;
            System.out.println("Success");
        }
        else {
            test = false;
            System.out.println("Error");
            throw new AssertionError();
        }
        System.out.println("Game 3");
        System.out.println(str1 +" "+ str4 + str2 + " = " + str3);
        System.out.println("correctly?:" + test);
        //public void
        //System.out.print(test);

    }

}
