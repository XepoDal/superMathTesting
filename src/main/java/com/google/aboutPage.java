package com.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class aboutPage extends setUp{

    By close_button = By.xpath("//*[@id=\"about_us\"]/div/a/img");

    public aboutPage(WebDriver miandriver)
    {
        this.driver = miandriver;
    }

    public void aboutPageClose()
    {
        driver.findElement(close_button).click();
    }
}
