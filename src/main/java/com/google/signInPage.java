package com.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class signInPage extends setUp{

    By close_button = By.id("login_close_button");
    By open_reg = By.id("login_registration_button_id");
    By type_mail = By.id("login_user_email");
    By type_pass = By.id("login_user_password");

    public signInPage(WebDriver miandriver)
    {
        this.driver = miandriver;
    }

    public void ClosePage()
    {
        driver.findElement(close_button).click();
    }

    public void OpenReg()
    {
        driver.findElement(open_reg).click();
    }

    public void typeEmail()
    {
        driver.findElement(type_mail).sendKeys("test@google.com");
    }

    public void typePassword()
    {
        driver.findElement(type_pass).sendKeys("qwerty123");
    }
}
