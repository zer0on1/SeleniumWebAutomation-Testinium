package com.testinium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testinium {

    protected WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ahmet\\Desktop\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.n11.com/");
    }

    @Test
    public void test() {
        driver.findElement(By.className("btnSignIn")).click();
        driver.findElement(By.id("email")).sendKeys("test_testinium@test.com");
        driver.findElement(By.id("password")).sendKeys("123456a");
        driver.findElement(By.id("loginButton")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//a[@class='menuLink user']")).getText(), "test test");

    }
}