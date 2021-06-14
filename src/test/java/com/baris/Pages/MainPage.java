package com.baris.Pages;

import com.baris.methods.methods;
import com.thoughtworks.gauge.Step;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MainPage extends methods {
    Logger logger = Logger.getLogger(MainPage.class);
    private By homePageTodaySpacialBtn=By.xpath("//*[.='Bugüne Özel']");
    private By loginBtnBAr=By.xpath("//*[@title='veya üye ol' or @title='Hesabım']");
    private By loginBtn=By.xpath("//*[@id='login']");
    private By loginPageConf=By.xpath("//*[@id='btnLogin']");
    private By searchBar=By.xpath("//*[@placeholder=\"Ürün, kategori veya marka ara\"]");
    private By searchBtn =By.xpath("//*[@class=\"SearchBoxOld-buttonContainer\"]");
    private By confirimSearch=By.xpath("//*[@class=\"keyword\"]");
    private By pageTwo=By.xpath("//*[@class=\"page-2 \"]");
    private By pageTwoConf=By.xpath("//*[@class=\"page-2 active\"]");
    private By thirdProd=By.xpath("(//*[@id=\"heartWrapper\"])[3]");
    private By myFavorites=By.xpath("//*[@title=\"Beğendiklerim\"]");
    private By selectAllBtn=By.id("StickActionHeader-SelectAll");
    private By delete=By.xpath("//*[@id='StickActionHeader-RemoveSelected' and .='Seçilenleri Sil']");
    private By popUpDelete=By.id("DeleteConfirmationModal-ActionButton");
    private By empty=By.xpath("//*[.=\", listen şu an boş.\"]");


    @Step("Confirim The Main Page")
    public void confTheMainPage(){
        logger.info("Confiriming The Main Page...");
        Assert.assertTrue("Confiriming mainpage failed!!!",doesElementExistByBy(homePageTodaySpacialBtn));
        logger.info("Confiriming The Main Page is succused");

    }

    @Step("Go to login Page")
    public void goToLloginPage(){
        hoverElementByBy(loginBtnBAr);
        waitForSec(2);
        findElementByby(loginBtn).click();
        Assert.assertTrue("Confiriming login Page failed!!!",doesElementExistByBy(loginPageConf));

    }

    @Step("Search <text>")
    public void search(String text){
        findElementByby(searchBar).sendKeys(text);
        findElementByby(searchBtn).click();
        System.out.println(findElementByby(confirimSearch).getText());
        Assert.assertTrue("Unsuccuesfull search!!!",findElementByby(confirimSearch).getText().contains("Huawei"));
    }

    @Step("Go to Page 2")
    public void goToPageTwo(){
        findElementByby(pageTwo).click();
        Assert.assertTrue("2. page did not open",doesElementExistByBy(pageTwoConf));
    }

    @Step("Add fow the third product")
    public void addFov(){
        waitForSec(3);
        driver.findElement(By.xpath("(//*[@id=\"heartWrapper\"])[3]")).click();
        waitForSec(2);
    }

    @Step("Go to My favorite")
    public void goToMyFavorite(){
        hoverElementByBy(loginBtnBAr);
        waitForSec(2);
        findElementByby(myFavorites).click();
        Assert.assertTrue("My fav page did not open",doesElementExistByBy(selectAllBtn));
    }

    @Step("UnFav The Product")
    public void unFav(){
        findElementByby(selectAllBtn).click();
        findElementByby(delete).click();
        findElementByby(popUpDelete).click();
        waitForSec(2);
        Assert.assertTrue("Product could not delete!!!",doesElementExistByBy(empty));
        getScreenShot();
    }

}
