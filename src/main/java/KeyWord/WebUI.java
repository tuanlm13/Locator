package KeyWord;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebUI {
    private static int EXPLICIT_WAIT_TIMEOUT = 10;
    private static int WAIT_PAGE_LEADED_TIMEOUT = 30;

    //khoi tao driver:
    private static WebDriver driver;

    //constructor for WebUI:
    public WebUI(WebDriver _driver) {
        driver=_driver;
    }

    //get Element By custom:
    public static WebElement getWebElement(By by){

        return driver.findElement(by);
    }

    //print msg to Console:
    public static void logConsole(String MSG){
        System.out.println("Content from logConsole: "+MSG);
    }

    //openUrl:
    public static void openURL(String URL){
        driver.get(URL);
        waitForPageLoaded();
        logConsole("Open URL: " + URL);
    }

    public  static void reload(){
        driver.navigate().refresh();
    }
    /**
     * Wait for Page loaded
     * Chờ đợi trang tải xong (Javascript tải xong)
     */
    //Important:
    public static void waitForPageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_PAGE_LEADED_TIMEOUT), Duration.ofMillis(500));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return js.executeScript("return document.readyState").toString().equals("complete");
            }
        };

        //Check JS is Ready
        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if (!jsReady) {
            System.out.println("Javascript is NOT Ready.");
            //Wait for Javascript to load
            try {
                wait.until(jsLoad);
            } catch (Throwable error) {
                error.printStackTrace();
                //Assert.fail ("FAILED. Timeout waiting for page load.");
            }
        }
    }

    //get current url:
    public static String getCurrentUrl() {
        waitForPageLoaded();
        logConsole("Current url "+driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    //setText into textbox:
    public static void setText(By by,String text) {
        waitForPageLoaded();
        logConsole("SetText__"+text+"__into textbox__"+ by);
        getWebElement(by).sendKeys(text);
        logConsole("SetText done");
    }

    public static void clearText(By by){
        waitForPageLoaded();
        logConsole("Clear Text__into textbox__"+ by);
        getWebElement(by).clear();
        logConsole("SetText done");
    }

    //Click on WebElement:
    public static void clickElement(By by) {
        waitForPageLoaded();
        logConsole("Click on element__"+by);
        getWebElement(by).click();
        logConsole("Click on element done");
    }

    //getText Element:
    public static String getTextElement(By by) {
        waitForPageLoaded();
        logConsole("Get text element_"+by+"_"+getWebElement(by).getText());
        return getWebElement(by).getText();

    }

    //check login success ( verify element profile visible on page):
    public static boolean verifyElementVisible(By by, int seconds){
        try{
            WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(seconds), Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        }catch(TimeoutException e){
            e.printStackTrace();
            return false;
        }
    }


}
