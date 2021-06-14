package com.baris.hook;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.ExecutionContext;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class hook {
    protected static WebDriver driver;
    protected static WebDriverWait webDriverWait;

    Logger logger = Logger.getLogger(hook.class);
    private final String baseUrl = "https://www.hepsiburada.com/";

    @BeforeScenario
    public void setUp(ExecutionContext executionContext){
        String currentScenarioName=executionContext.getCurrentScenario().getName();
        logger.info("---------------- "+currentScenarioName+" ----------------");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        logger.info("Senaryo başlıyor...");

        int timeOutInSeconds =10; //Bir elementin sayfada yüklenmesi için beklenicek maksimum saniye
        webDriverWait = new WebDriverWait(driver, timeOutInSeconds);

    }


    @AfterScenario
    public void afterSenario(ExecutionContext exexutionContext) throws IOException, GeneralSecurityException {

        driver.quit();

    }

}


