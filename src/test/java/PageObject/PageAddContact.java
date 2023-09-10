package PageObject;

import KeyWord.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import static KeyWord.WebUI.*;

public class PageAddContact {
    private WebDriver driver;

    public PageAddContact(WebDriver _driver) {
        driver = _driver;
        new WebUI(driver);

    }
    private String URL="https://crm.anhtester.com/admin/authentication";
    By inputEmail = By.xpath("//input[@id='email']");
    By inputPassword = By.xpath("//input[@id='password']");
    By buttonLogin = By.xpath("//button[@type='submit']");

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
    public void login(String email, String password){
        openURL(URL);
        enterEmail(email);
        enterPassword(password);
        clickOnLoginButton();
    }

    By company=By.xpath("//span[@class='menu-text' and contains(text(),'Customers')]");
    By textboxSearch=By.xpath("//div[@class='input-group']/input[@type='search']");
    By dataCompany=By.xpath("//tbody/tr/td[3]/a[contains(text(),'TuanLM Company')]");
    By contacts=By.xpath("//a[@data-group='contacts']");

    public void moveCompany() throws InterruptedException {
        clickElement(company);
        Thread.sleep(2000);
        setText(textboxSearch,"tuanlm");
        Thread.sleep(2000);
        clickElement(dataCompany);
        Thread.sleep(2000);


    }

    By newContact=By.xpath("//a[@class='btn btn-primary new-contact mbot15']");
    By image=By.xpath("//input[@id='profile_image']");
    By firstName=By.xpath("//input[@id='firstname']");
    By lastName=By.xpath("//input[@id='lastname']");
    By email=By.xpath("//input[@id='email']");
    By pass=By.xpath("//input[@name='password']");
    By save=By.xpath("//button[@type='submit']");

    public void clickAddNewContact() throws InterruptedException {
        clickElement(contacts);
        Thread.sleep(2000);
        clickElement(newContact);
    }
    public void selectImage() throws InterruptedException {
        clickElement(image);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='profile_image']")).sendKeys("D:\\Sample img\\play.jpg");



    }
    String fName="FNAME";
    String lName="LNAME";
    String Email="abcd@example.com";

    public void createContact() throws InterruptedException {
        setText(firstName,fName);
        setText(lastName,lName);
        setText(email,Email);
        setText(pass,"123456");
        clickElement(save);
        reload();
        Thread.sleep(4000);


    }

    By contactName=By.xpath("//tbody/tr[1]/td[1]/a");
    By emaill=By.xpath("//tbody/tr[1]/td[2]/a");



    public void verifyContact(){

        Assert.assertEquals(driver.findElement(contactName).getText(),fName+" "+lName);
        Assert.assertEquals(driver.findElement(emaill).getText(),Email);

    }

//    click customer
//    search tuanlm
//    click company
//    click contact
//    click new contact
//    submit


}
