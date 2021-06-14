package com.baris.methods;
import com.baris.hook.hook;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class methods extends hook{
    Logger logger = Logger.getLogger(methods.class);


    public WebElement findElementByby(By by){
        WebElement element=null;

        try{
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
            element=driver.findElement(by);

        }catch (Exception e){
            Assert.fail(by+" Elementi sayfada bulunamadı!!!");

        }

        return element;
    }
    public void hoverElementByBy(By by){
        Actions action = new Actions(driver);
        WebElement element =findElementByby(by);
        action.moveToElement(element).build().perform();

    }

    public boolean doesElementExistByBy(By by){
        WebElement element=null;

        try{
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
            element=driver.findElement(by);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public void waitForSec(int sure) {

        try {
            Thread.sleep(sure * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info(sure+" saniye beklendi");
    }

    public void getScreenShot(){
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(scrFile, new File("./ScreenShots/homePageScreenshot "+getDate()+".png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        return dtf.format(now).toString().replaceAll("/","-");
    }

}
