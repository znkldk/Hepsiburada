package com.baris.Pages;

import com.baris.methods.methods;
import com.thoughtworks.gauge.Step;
import org.apache.log4j.Logger;
import org.asynchttpclient.util.HttpConstants;
import org.junit.Assert;
import org.openqa.selenium.By;


public class LoginPage extends methods {
    private final By emailAdress=By.id("txtUserName");
    private final By password=By.id("txtPassword");
    private final By loginBtn=By.id("btnLogin");
    private By homePageTodaySpacialBtn=By.xpath("//*[.='Bugüne Özel']");

    Logger logger = Logger.getLogger(LoginPage.class);


    @Step("Enter <email> and <password> and login")
    public void enterEmailAndPass(String email,String pass){
        logger.info("Loging...");
        findElementByby(emailAdress).sendKeys(email);
        findElementByby(password).sendKeys(pass);
        findElementByby(loginBtn).click();
        confTheSuccessLogin();

    }

    public void confTheSuccessLogin(){
        logger.info("Confiriming The Success Login...");
        Assert.assertTrue("Confiriming mainpage failed!!!",doesElementExistByBy(homePageTodaySpacialBtn));
        logger.info("Confiriming The Login is succused");

    }

}
