package ua.org.autotest;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by nbobulan on 11/20/17.
 */
public class FirstTest {

    private static WebDriver driver;

    @BeforeClass
            public static void setup() {
        System.setProperty ("webdriver.chrome.driver", "/Users/nbobulan/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://lingualeo.com/ru/login");

    }
    @Test
    public void userLogin() {
        WebElement loginField = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        loginField.sendKeys("bobulan.nataliya@gmail.com");
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordField.sendKeys("Natasha");
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[3]/form/input[4]"));
        loginButton.click();

        Assert.assertTrue("Login is successful!", driver.getTitle().contains("Мои задания"));
    }
//        Assert.assertTrue("Login is not successful!", driver.getTitle().contains("Мои задания"));

    @Test
    public void CheckLeo () {
        driver.findElement(By.xpath("//*[@id=\"tabsControl\"]/li[2]/a/div/span"))
                .click();
//        WebElement test = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div[2]/div/div[1]/div"));

        Assert.assertEquals(driver.findElement(By.xpath("///*[@id=\"content\"]/div[2]/div/div[2]/div/div[1]/div")),("Сытость Лео"));
    }


    @AfterClass
    public static void tearDown() {
//        driver.quit();

    }
}

