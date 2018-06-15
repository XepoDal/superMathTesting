package com.google;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class setUp {
    public WebDriver driver;
    public mainPage m_page;
    public helpPage help_pg;
    public aboutPage about_pg;
    public signInPage sign_in;
    public game1 game1_obj;
    public game2 game2_obj;
    public game3 game3_obj;
    public game4 game4_obj;
    public game5 game5_obj;
    public WebDriverWait driverWait;


    @Before
    public void setUp ()
    {
    System.setProperty("webdriver.chrome.driver","C:/Users/ddzheber/Downloads/chromedriver_win32/chromedriver.exe");
    driver = new ChromeDriver();
   // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get("http://supermath.ru");
    m_page = new mainPage(driver);
    help_pg = new helpPage(driver);
    about_pg = new aboutPage(driver);
    sign_in = new signInPage(driver);
    game1_obj = new game1(driver);
    game2_obj = new game2(driver);
    game3_obj = new game3(driver);
    game4_obj = new game4(driver);
    game5_obj = new game5(driver);
    driverWait = new WebDriverWait(driver,180);

    }

    @After
    public void close() {
        if (driver != null)
            driver.quit();
    }



}
