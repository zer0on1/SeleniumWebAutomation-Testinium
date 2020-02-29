package com.testinium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

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
        driver.findElement(By.id("searchData")).sendKeys("Bilgisayar");
        driver.findElement(By.className("searchBtn")).click();
        driver.findElement(By.xpath("//div[@class='pagination']//a[contains(text(),'2')]")).click();
        Assert.assertEquals(driver.getCurrentUrl().split("=")[2], "2");
        List<WebElement> computers = driver.findElements(By.xpath("//body/div[@id='wrapper']/div[@id='contentListing']/div[@class='container']/div[@class='listingHolder']/div[@class='productArea']/section[@class='group listingGroup resultListGroup import-search-view']/div[@id='view']/ul[@class='clearfix']/li"));
        int random = (int) (Math.random() * computers.size() + 1);
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/section[1]/div[2]/ul[1]/li[" + random + "]/div[1]/div[1]/a[1]/img[1]")).click();
        driver.findElement(By.linkText("Sepete Ekle")).click();
        String price = driver.findElement(By.xpath("//div[@class='newPrice']")).getText().split("TL")[0];
    }
}