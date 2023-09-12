package TestCase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;

import static java.lang.Thread.sleep;

public class debug {
    private static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.seleniumeasy.com/javascript-alert-box-demo.html");
        sleep(3000);
        driver.findElement(By.xpath("(//button[text()='Click me!'])[1]")).click();

        sleep(3000);
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();

        driver.switchTo().newWindow(WindowType.WINDOW);

    }
}
