package com.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class game2 extends setUp
{
    By win_close = By.xpath("//*[@id=\"game\"]/div/div[1]/img[1]");
    By num1 = By.id("mo_number_1");
    By num2 = By.id("mo_number_2");
    By result = By.id("mo_result");
    public int result1;
    boolean test;
    //WebDriverWait waitDriver = new WebDriverWait(driver, 10);


    public game2(WebDriver driver)
    {
        this.driver = driver;
    }

    public void WinClose()
    {
        driver.findElement(win_close).click();
    }

    public void checkResult() throws InterruptedException {
        //driverWait.w until(ExpectedConditions.visibilityOfElementLocated(By.id("mo_number_1")));circles
        //driver.manage().timeouts().implicitlyWait() //(10, TimeUnit.SECONDS);
        //Thread.sleep(Long.parseLong("15000"));
        //(new WebDriverWait(driver,10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("mo_number_1")));
        (new WebDriverWait(driver,180)).until(ExpectedConditions.visibilityOfElementLocated(By.id("mo_smile_img_id")));
        //waitDriver.until(ExpectedConditions.attributeContains(driver,By.id("")))
        /*List<WebElement> circlesList = driver.findElements(By.id("circles"));
        System.out.println(circlesList.get(circlesList.size()-1).getAttribute("src"));*/
        String str1 = driver.findElement(num1).getText();
        String str2 = driver.findElement(num2).getText();
        String str3 = driver.findElement(result).getText();
        String str4 = driver.findElement(By.id("mo_operation")).getText();
        if (str4.equals("+")) {
            result1 = Integer.parseInt(str1.trim()) + Integer.parseInt(str2.trim());
        }
        else{ if (str4.equals("-")){
            result1 = Integer.parseInt(str1.trim()) - Integer.parseInt(str2.trim());
        }
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
        System.out.println("Game 2");
        System.out.println(str1 +" "+ str4 + str2 + " = " + str3);
        System.out.println("correctly?:" + test);
        //public void
        //System.out.print(test);

    }

}
