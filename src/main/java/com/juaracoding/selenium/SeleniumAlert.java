package com.juaracoding.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumAlert {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\juaracoding\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://demoqa.com/alerts");
        System.out.println("Get URL");
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");

        String title = driver.findElement(By.className("main-header")).getText();
        System.out.println("Title Page : " +title);

        driver.findElement(By.id("alertButton")).click();
        driver.switchTo().alert().accept();
        System.out.println("Alert Ok Clicked");
        //SwitchTo cuma pakai pas ada Alert atau Frame

        driver.findElement(By.id("timerAlertButton")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.switchTo().alert().accept();
        System.out.println("Timer Alert Ok Clicked");


        driver.findElement(By.id("confirmButton")).click();
        driver.switchTo().alert().accept();
        System.out.println("Confirm Ok Clicked");

        driver.findElement(By.id("promtButton")).click();
        driver.switchTo().alert().sendKeys("JuaraCoding");
        driver.switchTo().alert().accept();
        System.out.println("Promt Ok Clicked");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }
}
