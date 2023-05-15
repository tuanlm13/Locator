package common;

import KeyWord.WebUI;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    public static WebDriver driver;

    @BeforeMethod
    @Parameters({"browser"})
    public static void createDriver(@Optional("chrome") String browser) {
        setupDriver(browser);

    }

    //Function call detail open browser:
    public static WebDriver setupDriver(@Optional("chrome") String browserName) {
        switch (browserName.trim().toLowerCase()) {
            case "chrome":
                driver = initChromeDriver();
                break;
            case "edge":
                driver = initEdgeDriver();
                break;
            case "firefox":
                driver = initFirefoxDriver();
                break;
            case "safari":
                driver = initSafari();
                break;

            default:
                System.out.println("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver();
        }
        return driver;
    }

    //Detail open browser:
    //Chrome:
    private static WebDriver initChromeDriver() {
        System.out.println("Opening Chrome Browser...");
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    //Edge:
    private static WebDriver initEdgeDriver() {
        System.out.println("Opening Edge Browser...");
        WebDriverManager.edgedriver().setup();
        WebDriver driver=new EdgeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    //Firefox:
    private static WebDriver initFirefoxDriver() {
        System.out.println("Opening Firefox Browser...");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }

    //Safari:
    private static WebDriver initSafari() {
        System.out.println("Opening Safari Browser...");
        WebDriverManager.safaridriver().setup();
        WebDriver driver=new SafariDriver();
        driver.manage().window().maximize();
        return driver;
    }

    //Run alfter Method:
    @AfterMethod
    public static void closeDriver() {
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0)); //Reset timeout
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (driver != null) {
            driver.quit();
        }
    }
}
