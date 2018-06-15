package com.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class mainPage extends setUp{

    By help_element = By.id("header_help_id");
    By about_element = By.id("header_aboutus_id");
    By sign_in_element = By.id("header_login_id");
    By open_reg = By.id("login_registration_button_id");
    By game1 = By.id("banner_2_img");
    By game2 = By.id("banner_3_img");
    By game3 = By.id("banner_4_img");
    By game4 = By.id("banner_5_img");
    By game5 = By.id("banner_1_img");


    public mainPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void helpClick()
    {
        (new WebDriverWait(driver,10)).until(ExpectedConditions.visibilityOfElementLocated(help_element));
        driver.findElement(help_element).click();
    }

    public void aboutClick()
    {
        (new WebDriverWait(driver,10)).until(ExpectedConditions.visibilityOfElementLocated(about_element));
        driver.findElement(about_element).click();
    }

    public void signInClick()
    {
        (new WebDriverWait(driver,10)).until(ExpectedConditions.visibilityOfElementLocated(sign_in_element));
        driver.findElement(sign_in_element).click();
    }

    public void regOpen()
    {
        (new WebDriverWait(driver,10)).until(ExpectedConditions.visibilityOfElementLocated(open_reg));
        driver.findElement(open_reg).click();
    }

    public void game1Open()
    {
        (new WebDriverWait(driver,10)).until(ExpectedConditions.visibilityOfElementLocated(game1));
        driver.findElement(game1).click();
    }

    public void game2Open()
    {
        (new WebDriverWait(driver,10)).until(ExpectedConditions.visibilityOfElementLocated(game2));
        driver.findElement(game2).click();
    }

    public void game3Open()
    {
        (new WebDriverWait(driver,10)).until(ExpectedConditions.visibilityOfElementLocated(game3));
        driver.findElement(game3).click();
    }

    public void game4Open()
    {
        (new WebDriverWait(driver,10)).until(ExpectedConditions.visibilityOfElementLocated(game4));
        driver.findElement(game4).click();
    }

    public void game5Open()
    {
        (new WebDriverWait(driver,10)).until(ExpectedConditions.visibilityOfElementLocated(game5));
        driver.findElement(game5).click();
    }

}
