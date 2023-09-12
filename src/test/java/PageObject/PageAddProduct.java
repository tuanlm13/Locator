package PageObject;

import KeyWord.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import static KeyWord.WebUI.*;
public class PageAddProduct {
    private WebDriver driver;
    PageAddCategories categories;

    public PageAddProduct(WebDriver _driver) {
        driver = _driver;
        new WebUI(driver);

    }

    By menuProduct = By.xpath("//ul[@id='main-menu']/li[1]/a/span[1][contains(text(),Products)]");
    By menuAddProduct = By.xpath("//ul[@id='main-menu']/li/ul//a/span[contains(text(),'Add New Product')]");
    By productName = By.xpath("//input[@placeholder='Product Name']");
    String product="product for testing 123";
    By category = By.xpath("//button[@data-id='category_id']");
    By searchCategory = By.xpath("//div[@id='category']//input[@type='search']");
    By unit = By.xpath("//input[@name='unit']");
    By tag = By.xpath("//span[@aria-placeholder='Type and hit enter to add a tag']");
    By activeColor= By.xpath("//div[@class='card-body']/div/div[3]/label/span");
    By buttonColors= By.xpath("//button[@data-id='colors']");
    By colors= By.xpath("//div[@id='bs-select-4']/ul/li");
    By colorsSelected= By.xpath("//div[@id='bs-select-4']/ul/li[@class='selected']");
    By price = By.xpath("//input[@name='unit_price']");
    By discount = By.xpath("//input[@name='discount']");
    By quantity = By.xpath("//input[@name='current_stock']");
    By submit = By.xpath("//button[@value='unpublish']");

    public int colortNumber=0;
    public void moveProduct(){
        clickElement(menuProduct);
        clickElement(menuAddProduct);
    }

    public void inputProductName(){
        setText(productName,product);
    }

    public void inputCategory() throws AWTException {
        clickElement(category);

        categories=new PageAddCategories(driver);
        setText(searchCategory, categories.categoryName);
        System.out.println("category name================"+categories.categoryName);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
    }

    public void inputUnit(){
        setText(unit,"KG");
    }
    public void inputTag(){
        setText(tag,"tagName");
    }

    public void inputColor() throws AWTException {
        clickElement(activeColor);
        clickElement(buttonColors);
        List<WebElement> elementList = new ArrayList<>();
        elementList=driver.findElements(colors);
        colortNumber= elementList.size();
        System.out.println("Color number ========"+colortNumber);
        //select color:
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);

        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);

        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);

    }

    public void inputPrice(){
        setText(price,"10000");
    }

    public void inputDiscount(){
        setText(discount,"2000");
    }

    public void inputQuantity(){
        setText(quantity,"1");
    }
////button[@value='publish']
    public void submit() throws InterruptedException {

        Thread.sleep(5000);
        clickElement(submit);
        Thread.sleep(2000);
    }

    By messageSuccess=By.xpath("//span[@data-notify='message']");
    public void verifyMessage(){
        verifyElementVisible(messageSuccess,8);
    }

    By banner = By.xpath("//*[@id=\"choice_form\"]/div/div[1]/div[2]/div[2]/div[2]/div/div[1]/div[2]");
    By image = By.xpath("//h6/span[contains(text(),'play')]");
    By addFile = By.xpath("//button[contains(text(),'Add Files')]");

    public void selectImage() throws InterruptedException {
        clickElement(banner);
        Thread.sleep(2000);
        clickElement(image);
        Thread.sleep(1000);
        clickElement(addFile);
        Thread.sleep(2000);
    }



}

