package com.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class game5 extends setUp
{
    By win_close = By.xpath("//*[@id=\"game\"]/div/div[1]/img[1]");
    By num1 = By.id("co_number_1");
    By num2 = By.id("co_number_2");
    By result = By.id("co_result");
    public int result1;
    String answer;


    public game5(WebDriver driver)
    {
        this.driver = driver;
    }

    public void WinClose()
    {
        driver.findElement(win_close).click();
    }

    public void checkResult() throws InterruptedException {
        (new WebDriverWait(driver,180)).until(ExpectedConditions.visibilityOfElementLocated(By.id("co_smile_img_id")));
        String str1 = driver.findElement(num1).getText();
        String str2 = driver.findElement(num2).getText();
        String str3 = driver.findElement(result).getText();
        //String str4 = driver.findElement(By.id("mo_operation")).getText();
        if (Integer.parseInt(str1.trim()) > Integer.parseInt(str2.trim())){
            answer = ">";
        }
        else{
            if (Integer.parseInt(str1.trim()) < Integer.parseInt(str2.trim())){
                answer = "<";
            }
            else {
                if (Integer.parseInt(str1.trim()) == Integer.parseInt(str2.trim())){
                    answer = "=";
                }
                else {
                    System.out.println("Error");
                }
            }
        }
        if ((str3.equals(String.valueOf(answer)))) {
            System.out.println("Success");
        }
        else {
            System.out.println("Error");
            throw new AssertionError();
        }
        System.out.println("Game 5");
        System.out.println(str1 +" "+ str3 +" "+ str2);
       // System.out.println("correctly?:" + test);
        //public void
        //System.out.print(test);

    }

}
