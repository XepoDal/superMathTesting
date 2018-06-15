package com.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class helpPage extends setUp{

    //WebDriver driver;


    public helpPage(WebDriver miandriver)
    {
        this.driver = miandriver;
    }



    public void helpPageClose()
    {
        (new WebDriverWait(driver,10)).until(ExpectedConditions.visibilityOfElementLocated(By.className("close_window_div")));
        driver.findElement(By.className("close_window_div")).findElement(By.tagName("img")).click();
    }
}
