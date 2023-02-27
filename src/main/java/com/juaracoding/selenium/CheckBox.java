package com.juaracoding.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\juaracoding\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://demoqa.com/checkbox");
        System.out.println("Get URL");
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");

        //inspect, copy, copy xpath
        driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/button")).click();
        driver.findElement(By.xpath("//*[@id='tree-node']/ol/li/ol/li[3]/span/label/span[3]")).click();
        String txtDownloads = driver.findElement(By.xpath("//*[@id='result']/span[2]")).getText();
        System.out.println(txtDownloads);

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
