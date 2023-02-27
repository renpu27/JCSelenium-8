package com.juaracoding.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestLogin {
    WebDriver driver;
    String pathChromeDriver = "C:\\juaracoding\\chromedriver.exe";

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", pathChromeDriver);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        driver.get(url);
        System.out.println("Get URL : " + url);
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");
    }

        @Test(priority = 2)
        public void testValidLogin() {
        delay(1);
            //step action
            login("Admin", "admin123");
            //step verify
            String txtDashboard = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")).getText();
            Assert.assertEquals(txtDashboard, "Dashboard");
    }

        @Test(priority = 1)
        public void testInvalidLogin(){
        delay(1);
            login("Edmin", "edmin123");
            String warningMessage = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")).getText();
            Assert.assertEquals(warningMessage, "Invalid credentials");
        }

        @AfterClass
        public void quitBrowser()
        {
            delay(3);
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

    void login(String username, String password) {
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

}
