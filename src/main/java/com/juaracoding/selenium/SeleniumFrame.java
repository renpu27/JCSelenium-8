package com.juaracoding.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumFrame {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\juaracoding\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String url = "https://demoqa.com/frames";
        driver.get(url);
        System.out.println("Get URL : " + url);
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");

        String titleHeader = driver.findElement(By.className("main-header")).getText();
        System.out.println("Title Page : " + titleHeader);

        WebElement frameSamplePage = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frameSamplePage);
        //SwitchTo cuma pakai pas ada Alert atau Frame

        String txtFrame = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(txtFrame);

        //keluar dari frame
        driver.switchTo().defaultContent();
        String descFrame = driver.findElement(By.xpath("//*[@id='framesWrapper']/div[1]")).getText();
        System.out.println(descFrame);

        js.executeScript("window.scrollBy(0, 500)");
        System.out.println("=== Scroll ===");

        driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-4']")).click();
        //baca xpath cheat sheet.. atau copy full xpath.. atau pakai xpather dengan copy outerHTML
        //atau pakai SelectorsHub
        System.out.println("Click Modal Dialogs");

        driver.findElement(By.id("showSmallModal")).click();
        String txtTitleModal = driver.findElement(By.xpath("//div[@id='example-modal-sizes-title-sm'][1]")).getText();
        System.out.println(txtTitleModal);
        String txtBodyModal = driver.findElement(By.xpath("//div[@class='modal-body'][1]")).getText();
        System.out.println(txtBodyModal);
        driver.findElement(By.xpath("//button[@id='closeSmallModal'][1]")).click();
        System.out.println("Small Modal Closed");

        System.out.println("=== Delay 3 seconds ===");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
        System.out.println("Quit Browser");
    }
}
