package HT;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import org.junit.Assert;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        String key = "TeSter";

        String baseUrl = "https://www.google.com.vn/";
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl);

        WebElement textField = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        textField.sendKeys(key);
        textField.sendKeys(Keys.ENTER);
        Thread.sleep(5000);

        ArrayList<WebElement> list = new ArrayList<>(driver.findElements(By.xpath("//div[@class='yuRUbf']/a/h3")));
        for (int i = 1; i < list.size(); i++) {
            String xpath = "//*[@id='rso']/div[" + i + "]/div/div/div[1]/a/h3";
            String result = driver.findElement(By.xpath(xpath)).getText();
            String key1 = key.toUpperCase();
            String result2 = result.toUpperCase();
            Assert.assertTrue(result2.contains(key1));
        }
        driver.close();

    }
}
