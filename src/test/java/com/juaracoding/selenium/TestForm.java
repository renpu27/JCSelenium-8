package com.juaracoding.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestForm {
    WebDriver driver;
    String pathChromeDriver = "C:\\juaracoding\\chromedriver.exe";

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", pathChromeDriver);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority = 1)
    public void testUrl(){
        //step action
        delay(3);
        String url = "https://demoqa.com/text-box";
        driver.get(url);
        System.out.println("Get URL : " + url);
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");
        String titleHeader = driver.findElement(By.className("main-header")).getText();
        System.out.println("Title Page : " + titleHeader);
//        driver.navigate().refresh();
        //step verify
        Assert.assertEquals(titleHeader, "Text Box");
    }

    @Test(priority = 2)
    public void testFormIdentity(){
        delay(1);
        driver.findElement(By.id("userName")).sendKeys("JuaraCoding");
        driver.findElement(By.id("userEmail")).sendKeys("info@JuaraCoding.com");
        driver.findElement(By.id("currentAddress")).sendKeys("Jakarta");
        driver.findElement(By.id("permanentAddress")).sendKeys("Jakarta");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");
        driver.findElement(By.id("submit")).click();

        String txtName = driver.findElement(By.xpath("//p[@id='name']")).getText();
        Assert.assertTrue(txtName.contains("JuaraCoding"));
        String txtEmail = driver.findElement(By.xpath("//p[@id='email']")).getText();
        Assert.assertTrue(txtEmail.contains("info@JuaraCoding.com"));
        String txtcurAddress = driver.findElement(By.xpath("//p[@id='currentAddress']")).getText();
        Assert.assertTrue(txtcurAddress.contains("Jakarta"));
        String txtperAddress = driver.findElement(By.xpath("//p[@id='permanentAddress']")).getText();
        Assert.assertTrue(txtperAddress.contains("Jakarta"));
    }

    @AfterClass
    public void quitBrowser()
    {
        driver.quit();
        System.out.println("Quit Browser");
    }
    static void delay(long detik){
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
