package com.google;

import org.junit.Assert;
import org.junit.Test;

public class testClass extends setUp{
   // WebDriver driver;

    @Test
    public void test () throws InterruptedException
    {
        System.out.println("Success");
       /* String title = driver.getTitle();
        Assert.assertTrue(title.equals("SuperMath - Математика, обучение сложению, вычитанию, умножению и делению"));
        m_page.helpClick();
        help_pg.helpPageClose();
        m_page.aboutClick();
        about_pg.aboutPageClose();
        m_page.signInClick();
        sign_in.typeEmail();
        sign_in.typePassword();
        sign_in.ClosePage();
        System.out.println("Success");*/

    }

    @Test
    public void test1 () throws InterruptedException
    {
        //Game 1 Сложение\Вычетание одноразрядных чисел
        m_page.game1Open();
        game1_obj.checkResult();
        game1_obj.WinClose();
        //Game 2 Сложение\Вычетание двуразрядных чисел
        m_page.game2Open();
        game2_obj.checkResult();
        game2_obj.WinClose();
        //Game 3 Умножение одноразрядных чисел
        m_page.game3Open();
        game3_obj.checkResult();
        game3_obj.WinClose();
        //Game 4 Сложение\вычитания чисел с разными знаками
        m_page.game4Open();
        game4_obj.checkResult();
        game4_obj.WinClose();
        //Game 5 Больше\Меньше
        m_page.game5Open();
        game5_obj.checkResult();
        game5_obj.WinClose();

    }

    @Test
    public void test2 () throws Exception
    {

        m_page.game1Open();
        game1_obj.negativeTestTimeOut(10);
        //  game1_obj.WinClose();
        game1_obj.negativeTestWrongAnswers(10);
        //game1_obj.WinClose();
        game1_obj.positiveTestCorrectAnswers(1);
        // game1_obj.WinClose();
        game1_obj.checkButtonShowHideTime();
        game1_obj.checkButtonShowHideKeys();
        game1_obj.checkButtonShowHideHero();

    }




}

