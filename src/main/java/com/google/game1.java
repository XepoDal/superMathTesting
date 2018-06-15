package com.google;

import com.google.setUp;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Formatter;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class game1 extends setUp
{
    By win_close = By.xpath("//*[@id=\"game\"]/div/div[1]/img[1]");////*[@id="results"]/div/div[1]/img
    By num1 = By.id("mo_number_1");
    By num2 = By.id("mo_number_2");
    By result = By.id("mo_result");
    By tasks_remain = By.id("tasks_remain");
    By tasks_all = By.id("tasks_all");
    By tasks_passed = By.id("tasks_passed");
    By tasks_failed = By.id("tasks_failed");
    By stars_counter_id = By.id("stars_counter_id");
    By clock_for_time_out = By.id("mo_smile_img_id");
    By clock_img = By.id("time_icon");
    By clock = By.id("circles");
    By keys_img = By.id("kbrd_icon");
    By keys = By.id("keys_wrapper");
    By image_img = By.id("hero_icon");
    By image = By.id("hero_img");
    //String
    public int result1;
    boolean test;
   // int breakpointForPositiveTesting = 1;
   // int qtyOfIterationsForTimeOut = 10;
    //int getQtyOfIterationsForWrongAnswers = 10;

    //WebDriverWait waitDriver = new WebDriverWait(driver, 10);


    public game1(WebDriver driver)
    {
        this.driver = driver;
    }

    public void WinClose()
    {
        driver.findElement(win_close).click();
    }

    public void checkResult()  {

        (new WebDriverWait(driver,180)).until(ExpectedConditions.visibilityOfElementLocated(By.id("mo_smile_img_id")));
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
        System.out.println("Game 1");
        System.out.println(str1 +" "+ str4 + str2 + " = " + str3);
        System.out.println("correctly?:" + test);



    }

    /*public void detailedTest() throws InterruptedException {
        (new WebDriverWait(driver,180)).until(ExpectedConditions.visibilityOfElementLocated(By.id("mo_smile_img_id")));
        String str1 = driver.findElement(num1).getText();
        String str2 = driver.findElement(num2).getText();
        String str3 = driver.findElement(result).getText();
        String str4 = driver.findElement(By.id("mo_operation")).getText();
        int actualResult = 0;
        if (str4.equals("+")) {
            actualResult = Integer.parseInt(str1.trim()) + Integer.parseInt(str2.trim());
        }
        else{ if (str4.equals("-")){
            actualResult = Integer.parseInt(str1.trim()) - Integer.parseInt(str2.trim());
        }
            else {
            System.out.println("Incorrect operator");
        }
        }
        Assert.assertTrue(actualResult == Integer.parseInt(str3));
        String strActualResult = new Integer(actualResult).toString();
        StringBuilder testStringBuilder = new StringBuilder();
        Formatter testFormatter = new Formatter(testStringBuilder);
        for(int i = 0; i < strActualResult.length(); i++){
            testFormatter.format("key_%s",strActualResult.substring(i));
            driver.findElement(By.id(testStringBuilder.toString())).click();
            Thread.sleep(1000);
            System.out.println(strActualResult.substring(i));
        }
    }*/

    public void positiveTestCorrectAnswers(int breakpointForPositiveTesting) throws InterruptedException {

        (new WebDriverWait(driver, 80)).until(ExpectedConditions.visibilityOfElementLocated(tasks_remain));
        int qtyTasks = Integer.parseInt(driver.findElement(tasks_all).getText());
        while(!((driver.findElement(tasks_remain).getText()).equals(String.valueOf(breakpointForPositiveTesting)))) {
            //while((Integer.parseInt(driver.findElement(num1).getText())) > 0) {
            (new WebDriverWait(driver, 80)).until(ExpectedConditions.visibilityOfElementLocated(num1));
            Thread.sleep(500);
            int varTasks_passed_Begin = Integer.parseInt(driver.findElement(tasks_passed).getText());
            int varTasks_failed_Begin = Integer.parseInt(driver.findElement(tasks_failed).getText());
            int varTasks_remain_Begin = Integer.parseInt(driver.findElement(tasks_remain).getText());
            int stars_counter_id_Begin = Integer.parseInt(driver.findElement(stars_counter_id).getText());
            String str1 = driver.findElement(num1).getText();
            String str2 = driver.findElement(num2).getText();
            String str4 = driver.findElement(By.id("mo_operation")).getText();
            int actualResult = 0;
            if (str4.equals("+")) {
                actualResult = Integer.parseInt(str1.trim()) + Integer.parseInt(str2.trim());
            } else {
                if (str4.equals("-")) {
                    actualResult = Integer.parseInt(str1.trim()) - Integer.parseInt(str2.trim());
                } else {
                    System.out.println("Incorrect operator");
                }
            }
            String strActualResult = new Integer(actualResult).toString();
            System.out.println(str1 + " " + str4 + " " + str2 + " = " + strActualResult);
            StringBuilder testStringBuilder = new StringBuilder();
            Formatter testFormatter = new Formatter(testStringBuilder);
            for (int i = 0; i < strActualResult.length(); i++) {
                String subStr = strActualResult.substring(i, i + 1);
                testFormatter.format("key_%s", subStr);
                //System.out.println();
                driver.findElement(By.id(testStringBuilder.toString())).click();
                testStringBuilder.setLength(0);
            }
            int varTasks_passed_End = Integer.parseInt(driver.findElement(tasks_passed).getText());
            int varTasks_failed_End = Integer.parseInt(driver.findElement(tasks_failed).getText());
            int varTasks_remain_End = Integer.parseInt(driver.findElement(tasks_remain).getText());
            int stars_counter_id_End = Integer.parseInt(driver.findElement(stars_counter_id).getText());
            //assert stars_counter_id_End == stars_counter_id_Begin + 1 : "positiveTestCorrectAnswers: звёзды не инкриментятся" ;
            assert varTasks_remain_End == varTasks_remain_Begin - 1 : "positiveTestCorrectAnswers: дикримент оставшихся заданий не корректен";//ассерт на правильнось дикримента оставшихся заданий
            assert varTasks_failed_Begin == varTasks_failed_End : "positiveTestCorrectAnswers: есть ошибки";
            assert varTasks_passed_End == varTasks_passed_Begin + 1 : "positiveTestCorrectAnswers: правильные ответы не инкриментятся";
        }
       // int iterationsDone = qtyTasks - breakpointForPositiveTesting;
        int varTasks_passed_AfterCycle  = Integer.parseInt(driver.findElement(tasks_passed).getText());
        int varTasks_failed_AfterCycle = Integer.parseInt(driver.findElement(tasks_failed).getText());
        int varTasks_remain_AfterCycle = Integer.parseInt(driver.findElement(tasks_remain).getText());
        assert (varTasks_passed_AfterCycle + varTasks_failed_AfterCycle + varTasks_remain_AfterCycle) == qtyTasks : "positiveTestCorrectAnswers: не корректное соотношение правильных, не правильных и оставшихся заданий относительно суммы";// ассерт на правильность
        System.out.println("Positive test passed");
    }
    public void negativeTestTimeOut(int getQtyOfIterationsForWrongAnswers) throws Exception {

        (new WebDriverWait(driver, 80)).until(ExpectedConditions.visibilityOfElementLocated(tasks_remain));
        int qtyTasks_Before_Cycle = Integer.parseInt(driver.findElement(tasks_all).getText());int varTasks_passed_Before_Cycle  = Integer.parseInt(driver.findElement(tasks_passed).getText());
        int varTasks_failed_Before_Cycle = Integer.parseInt(driver.findElement(tasks_failed).getText());
        int varTasks_remain_Before_Cycle = Integer.parseInt(driver.findElement(tasks_remain).getText());
        for(int iter = 0; iter < getQtyOfIterationsForWrongAnswers; iter++) {
            (new WebDriverWait(driver, 80)).until(ExpectedConditions.visibilityOfElementLocated(num1));
            Thread.sleep(500);
            int varTasks_passed_Begin = Integer.parseInt(driver.findElement(tasks_passed).getText());
            int varTasks_failed_Begin = Integer.parseInt(driver.findElement(tasks_failed).getText());
            int varTasks_remain_Begin = Integer.parseInt(driver.findElement(tasks_remain).getText());
            //int stars_counter_id_Begin = Integer.parseInt(driver.findElement(stars_counter_id).getText());
            int qtyTasksInLoop_Begin = Integer.parseInt(driver.findElement(tasks_all).getText());
            StringBuilder testStringBuilder = new StringBuilder();
            Formatter testFormatter = new Formatter(testStringBuilder);
            (new WebDriverWait(driver, 80)).until(ExpectedConditions.visibilityOfElementLocated(clock_for_time_out));
            String CorrectAnswer = driver.findElement(result).getText();
            for (int b = 0; b < CorrectAnswer.length(); b++) {
                String subStr = CorrectAnswer.substring(b, b + 1);
                testFormatter.format("key_%s", subStr);
                driver.findElement(By.id(testStringBuilder.toString())).click();
                testStringBuilder.setLength(0);
            }
            int varTasks_passed_End = Integer.parseInt(driver.findElement(tasks_passed).getText());
            int varTasks_failed_End = Integer.parseInt(driver.findElement(tasks_failed).getText());
            int varTasks_remain_End = Integer.parseInt(driver.findElement(tasks_remain).getText());
            //int stars_counter_id_End = Integer.parseInt(driver.findElement(stars_counter_id).getText());
            int qtyTasksInLoop_End = Integer.parseInt(driver.findElement(tasks_all).getText());
           // assert stars_counter_id_End == stars_counter_id_Begin : "negativeTestTimeOut: stars error" ;
            assert varTasks_remain_Begin == varTasks_remain_End  : "negativeTestTimeOut: дикримент оставшихся заданий не корректен";//ассерт на правильнось дикримента оставшихся заданий
            assert varTasks_failed_End == (varTasks_failed_Begin + 1) : "negativeTestTimeOut: есть ошибки";
            assert varTasks_passed_End == varTasks_passed_Begin : "negativeTestTimeOut: правильные ответы не инкриментятся";
            assert qtyTasksInLoop_End == qtyTasksInLoop_Begin + 1 : "negativeTestTimeOut: инкримент \"всего заданий\" не корректен";
        }
        // int iterationsDone = qtyTasks - breakpointForPositiveTesting;
        int varTasks_passed_After_Cycle  = Integer.parseInt(driver.findElement(tasks_passed).getText());
        int varTasks_failed_After_Cycle = Integer.parseInt(driver.findElement(tasks_failed).getText());
        int varTasks_remain_After_Cycle = Integer.parseInt(driver.findElement(tasks_remain).getText());
        int qtyTasks_After_Cycle = Integer.parseInt(driver.findElement(tasks_all).getText());
        //assert ((varTasks_passed_After_Cycle - varTasks_passed_Before_Cycle) + (varTasks_failed_After_Cycle - varTasks_failed_Before_Cycle) + (varTasks_remain_After_Cycle)) == qtyTasks + (varTasks_failed_After_Cycle - varTasks_failed_Before_Cycle) : "negativeTestTimeOut: не корректное соотношение правильных, не правильных и оставшихся заданий относительно суммы";//
        assert varTasks_failed_After_Cycle - varTasks_failed_Before_Cycle == qtyTasks_After_Cycle - qtyTasks_Before_Cycle : "negativeTestTimeOut: не корректное соотношение правильных, не правильных и оставшихся заданий относительно суммы";//
        System.out.println("Time out test passed");
    }

    public void negativeTestWrongAnswers(int getQtyOfIterationsForWrongAnswers) throws Exception {

        (new WebDriverWait(driver, 80)).until(ExpectedConditions.visibilityOfElementLocated(tasks_remain));
        int qtyTasks_Before_Cycle = Integer.parseInt(driver.findElement(tasks_all).getText());
        int varTasks_passed_Before_Cycle  = Integer.parseInt(driver.findElement(tasks_passed).getText());
        int varTasks_failed_Before_Cycle = Integer.parseInt(driver.findElement(tasks_failed).getText());
        //int varTasks_remain_Before_Cycle = Integer.parseInt(driver.findElement(tasks_remain).getText());
        for(int iter = 0; iter < getQtyOfIterationsForWrongAnswers; iter++) {
            (new WebDriverWait(driver, 80)).until(ExpectedConditions.visibilityOfElementLocated(num1));
            Thread.sleep(500);
            int varTasks_passed_Begin = Integer.parseInt(driver.findElement(tasks_passed).getText());
            int varTasks_failed_Begin = Integer.parseInt(driver.findElement(tasks_failed).getText());
            int varTasks_remain_Begin = Integer.parseInt(driver.findElement(tasks_remain).getText());
           // int stars_counter_id_Begin = Integer.parseInt(driver.findElement(stars_counter_id).getText());
            int qtyTasksInLoop_Begin = Integer.parseInt(driver.findElement(tasks_all).getText());
            String str1 = driver.findElement(num1).getText();
            String str2 = driver.findElement(num2).getText();
            String str4 = driver.findElement(By.id("mo_operation")).getText();
            int actualResult = 0;
            if (str4.equals("+")) {
                actualResult = Integer.parseInt(str1.trim()) + Integer.parseInt(str2.trim());
            } else {
                if (str4.equals("-")) {
                    actualResult = Integer.parseInt(str1.trim()) - Integer.parseInt(str2.trim());
                } else {
                    System.out.println("Incorrect operator");
                }
            }
            String strActualResult = new Integer(actualResult + 1).toString();
            System.out.println(str1 + " " + str4 + " " + str2 + " = " + strActualResult);
            StringBuilder testStringBuilder = new StringBuilder();
            Formatter testFormatter = new Formatter(testStringBuilder);
            for (int i = 0; i < strActualResult.length(); i++) {
                String subStr = strActualResult.substring(i, i + 1);
                testFormatter.format("key_%s", subStr);
                //System.out.println();
                driver.findElement(By.id(testStringBuilder.toString())).click();
                testStringBuilder.setLength(0);
            }
            String CorrectAnswer = driver.findElement(result).getText();
            for (int b = 0; b < CorrectAnswer.length(); b++) {
                String subStr = CorrectAnswer.substring(b, b + 1);
                testFormatter.format("key_%s", subStr);
                driver.findElement(By.id(testStringBuilder.toString())).click();
                testStringBuilder.setLength(0);
            }
            int varTasks_passed_End = Integer.parseInt(driver.findElement(tasks_passed).getText());
            int varTasks_failed_End = Integer.parseInt(driver.findElement(tasks_failed).getText());
            int varTasks_remain_End = Integer.parseInt(driver.findElement(tasks_remain).getText());
           // int stars_counter_id_End = Integer.parseInt(driver.findElement(stars_counter_id).getText());
            int qtyTasksInLoop_End = Integer.parseInt(driver.findElement(tasks_all).getText());
           // assert stars_counter_id_End == stars_counter_id_Begin : "negativeTestWrongAnswers: stars error" ;
            assert varTasks_remain_Begin == varTasks_remain_End  : "negativeTestWrongAnswers: дикримент оставшихся заданий не корректен";//ассерт на правильнось дикримента оставшихся заданий
            assert varTasks_failed_End == (varTasks_failed_Begin + 1) : "negativeTestWrongAnswers: есть ошибки";
            assert varTasks_passed_End == varTasks_passed_Begin : "negativeTestWrongAnswers: правильные ответы не инкриментятся";
            assert qtyTasksInLoop_End == qtyTasksInLoop_Begin + 1 : "negativeTestWrongAnswers: инкримент \"всего заданий\" не корректен";
        }
        // int iterationsDone = qtyTasks - breakpointForPositiveTesting;
        int varTasks_passed_After_Cycle  = Integer.parseInt(driver.findElement(tasks_passed).getText());
        int varTasks_failed_After_Cycle = Integer.parseInt(driver.findElement(tasks_failed).getText());
        int qtyTasks_After_Cycle = Integer.parseInt(driver.findElement(tasks_all).getText());
        int varTasks_remain_After_Cycle = Integer.parseInt(driver.findElement(tasks_remain).getText());
        //assert ((varTasks_passed_After_Cycle - varTasks_passed_Before_Cycle) + (varTasks_failed_After_Cycle - varTasks_failed_Before_Cycle) + (varTasks_remain_After_Cycle)) == qtyTasks_Before_Cycle + (varTasks_failed_After_Cycle - varTasks_failed_Before_Cycle) : "negativeTestWrongAnswers: не корректное соотношение правильных, не правильных и оставшихся заданий относительно суммы";//
        assert varTasks_failed_After_Cycle - varTasks_failed_Before_Cycle == qtyTasks_After_Cycle - qtyTasks_Before_Cycle : "negativeTestWrongAnswers: не корректное соотношение правильных, не правильных и оставшихся заданий относительно суммы";//
        System.out.println("Wrong Answers test passed");
    }

    public void checkButtonShowHideTime() throws InterruptedException {

        (new WebDriverWait(driver,100)).until(ExpectedConditions.visibilityOfElementLocated(num1));
        assert (driver.findElement(clock).isDisplayed()) : "time on/off function error";
        driver.findElement(clock_img).click();
        driver.findElement(clock_img).click();
        Thread.sleep(1000);
        //(new WebDriverWait(driver, 120)).until()
        assert  (!(driver.findElement(clock).isDisplayed())) : "time on/off function error";
        driver.findElement(clock_img).click();
        System.out.println("checkButtonShowHideTime: success");

    }

    public void checkButtonShowHideKeys() throws InterruptedException {

        (new WebDriverWait(driver,100)).until(ExpectedConditions.visibilityOfElementLocated(num1));
        assert (driver.findElement(keys).isDisplayed()) : "time on/off function error";
        driver.findElement(keys_img).click();
        driver.findElement(keys_img).click();
        Thread.sleep(1000);
        //(new WebDriverWait(driver, 120)).until()
        assert  (!(driver.findElement(keys).isDisplayed())) : "time on/off function error";
        driver.findElement(keys_img).click();
        System.out.println("checkButtonShowHideKeys: success");

    }

    public void checkButtonShowHideHero() throws InterruptedException {

        (new WebDriverWait(driver,100)).until(ExpectedConditions.visibilityOfElementLocated(num1));
        assert (driver.findElement(image).isDisplayed()) : "time on/off function error";
        driver.findElement(image_img).click();
        driver.findElement(image_img).click();
        Thread.sleep(1000);
        //(new WebDriverWait(driver, 120)).until()
        assert  (!(driver.findElement(image).isDisplayed())) : "time on/off function error";
        driver.findElement(image_img).click();
        System.out.println("checkButtonShowHideHero: success");

    }


}


