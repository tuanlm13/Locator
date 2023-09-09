package PageObject;
import KeyWord.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import static KeyWord.WebUI.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class PageAddCategories {

    By menuProduct = By.xpath("//ul[@id='main-menu']/li[1]/a/span[1][contains(text(),Products)]");
    By menuCategory=By.xpath("//li/a/span[contains(text(),'Category')]");
    By buttonAddCategory=By.xpath("//span[contains(text(),'Add New category')]");
    By headerCreateCategory=By.xpath("//div[@class='card-header']");

    private String categoryUrl="https://cms.anhtester.com/admin/categories";
    private String createCategoryUrl="https://cms.anhtester.com/admin/categories/create";

    By name=By.xpath("//input[@id='name']");
    By parentCategory=By.xpath("//div[2][@class='form-group row']/div/div/button[@data-toggle='dropdown']");
    By selectCategory=By.xpath("//a[@id='bs-select-1-1']");
    By orderNumber=By.xpath("//input[@id='order_level']");
    By type=By.xpath("//div[4][@class='form-group row']/div/div/button[@data-toggle='dropdown']");
    By selectType=By.xpath("//a[@id='bs-select-2-1']");
    By banner=By.xpath("//div[5]/div/div/div[contains(text(),'Choose File')]");
    By icon=By.xpath("//div[6]/div/div/div[contains(text(),'Choose File')]");
    By metaTitle=By.xpath("//input[@name='meta_title']");
    By metaDescription=By.xpath("//textarea[@name='meta_description']");

    By attribute=By.xpath("//div[9][@class='form-group row']/div/div/button[@data-toggle='dropdown']");
    By selectAttribute=By.xpath("//a[@id='bs-select-3-1']");
    By buttonSave=By.xpath("//button[@type='submit']");

    private String URL = "https://cms.anhtester.com/login";
    private String categoryName="Category 20230909";
    By inputEmail = By.xpath("//input[@id='email']");
    By inputPassword = By.xpath("//input[@id='password']");
    By buttonLogin = By.xpath("//button[@type='submit']");

    private WebDriver driver;
    public PageAddCategories(WebDriver _driver){
        driver = _driver;
        new WebUI(driver);

    }
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

    public void verifyUrlCategory(){
        Assert.assertEquals(categoryUrl,driver.getCurrentUrl());
    }

    public void verifyButtonVisible(){
        Assert.assertTrue(getWebElement(buttonAddCategory).isDisplayed());
    }

    //move to category screen:
    public void moveCategory() throws InterruptedException {
        clickElement(menuProduct);
        Thread.sleep(3000);
        clickElement(menuCategory);
        Thread.sleep(3000);
    }

    //action add category:
    public void clickAddCategory(){
        clickElement(buttonAddCategory);
    }

    //input data category:
    public void selectParent() throws InterruptedException {
        clickElement(parentCategory);
        Thread.sleep(3000);
        clickElement(selectCategory);


//        Actions action = new Actions(driver);
//        action.sendKeys(Keys.DOWN);
//        action.sendKeys(Keys.ENTER);
//        Thread.sleep(10000);

    }
    public void inputCategory() throws InterruptedException {
        setText(name,categoryName);
        selectParent();

        setText(orderNumber,"1");

        clickElement(type);
        clickElement(selectType);

        setText(metaTitle,"meta title for testing");
        setText(metaDescription,"meta Description for testing");

        clickElement(attribute);
        clickElement(selectAttribute);

        clickElement(buttonSave);

    }

    By tbx_search=By.xpath("//input[@id='search']");
    By list_category_name=By.xpath("//tbody/tr[1]/td[2]");
    public void searchCategory() throws InterruptedException {
        setText(tbx_search,categoryName);
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        String actualName=driver.findElement(list_category_name).getText();
        Assert.assertEquals(actualName,categoryName);

    }



}
