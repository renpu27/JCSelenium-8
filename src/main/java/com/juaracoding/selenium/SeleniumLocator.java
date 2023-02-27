package com.juaracoding.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumLocator {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\juaracoding\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String url = "https://demoqa.com/text-box";
        driver.get(url);
        System.out.println("Get URL : " + url);
//        driver.get("https://demoqa.com/text-box");
//        System.out.println("Get URL");

        driver.manage().window().maximize(); //biar pas dibuka langsung maximized windownya
        System.out.println("Maximize Browser");

        String titleHeader = driver.findElement(By.className("main-header")).getText();
        System.out.println("Title Page : " + titleHeader);
//        driver.getTitle();
//        System.out.println("Title Header : "+driver.getTitle());

        //Locator
        String title = driver.findElement(By.className("main-header")).getText();
        System.out.println("Title Page : "+title);
        driver.findElement(By.id("userName")).sendKeys("JuaraCoding");
        driver.findElement(By.id("userEmail")).sendKeys("info@JuaraCoding.com");
        driver.findElement(By.id("currentAddress")).sendKeys("Jakarta");
        driver.findElement(By.id("permanentAddress")).sendKeys("Jakarta");

        js.executeScript("window.scrollBy(0, 500)"); //scroll by pixel vertical
        driver.findElement(By.id("submit")).click();
        System.out.println("Data Berhasil Disimpan");

        //mengakali verify atau validasi tanpa TestNG
        System.out.print("Test Case Result : ");
        if(title.equals("Text Box")){
            System.out.println("Pass");
        } else {
            System.out.println("Failed");
        }


        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
        System.out.println("Button Login Clicked");

        System.out.println("Delay 3 seconds");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
        System.out.println("Quit Browser");
    }
}
