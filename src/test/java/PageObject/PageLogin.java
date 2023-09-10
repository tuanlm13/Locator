package PageObject;

import KeyWord.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static KeyWord.WebUI.*;
import static KeyWord.WebUI.openURL;

public class PageLogin {
    private String URL = "https://cms.anhtester.com/login";
    private String PAGETEXT = "Login";

    //Lưu Object của trang Login
    //Dùng đối tượng By trong Selenium để khai báo tên Object cùng giá trị Locator tương ứng
    By headerPage = By.xpath("//h1");
    By inputEmail = By.xpath("//input[@id='email']");
    By inputPassword = By.xpath("//input[@id='password']");
    By buttonLogin = By.xpath("//button[@type='submit']");
    By messageErrorEmail = By.xpath("//div[@class='text-center alert alert-danger']");
    By userProfile = By.xpath("//li[@class='icon header-user-profile']");


    //Hàm xây dựng để truyền vào driver
    private WebDriver driver;

    public PageLogin(WebDriver _driver){
        driver = _driver;
        new WebUI(driver);
    }

    //verify title:
    public void verifyUrl(){
        String currentUrl=driver.getCurrentUrl();

        Assert.assertEquals(currentUrl,URL);
    }

    //input mail on login page:
    public void enterEmail(String email){
        setText(inputEmail,email);
    }

    //input password:
    public void enterPassword(String password){
        setText(inputPassword,password);
    }

    //Click submit button:
    public void clickOnLoginButton(){
        clickElement(buttonLogin);
    }


    public void loginSuccess(String email, String password){
        openURL(URL);
        enterEmail(email);
        enterPassword(password);
        clickOnLoginButton();
        verifyElementVisible(userProfile,5);
        logConsole(userProfile+"_is visible on page, login successful");
    }

    public void loginInvalidEmail(String email, String password){
        openURL(URL);
        enterEmail(email);
        enterPassword(password);
        clickOnLoginButton();
        verifyUrl();

    }


}
