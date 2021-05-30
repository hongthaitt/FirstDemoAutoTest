package HT;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;


public class Demo {
    public static void main(String[] args) throws InterruptedException {
        String key = "TeSter";
        String baseUrl = "https://www.google.com.vn/";
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl);

        WebElement textField = driver.findElement(By.xpath("//input[@type='text' and @name='q'] "));
        textField.sendKeys(key);
        textField.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='result-stats']")));

        ArrayList<WebElement> listResult = new ArrayList<>(driver.findElements(By.xpath("//div[@class='yuRUbf']/a/h3")));
        for (WebElement element : listResult) {
            String result = element.getText();
            if (result.toUpperCase().contains(key.toUpperCase())) {
                System.out.println("Verify pass  ");
            }
            else System.out.println("Verify fail");
        }
        driver.close();
    }

    }

