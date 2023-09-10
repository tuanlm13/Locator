package TestCase;

import PageObject.PageLogin;
import common.BaseTest;
import PageObject.PageAddCategories;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class TCCategory extends BaseTest {
    PageAddCategories category;
    PageLogin pageLogin;

    @BeforeMethod
    public void login(){
        category = new PageAddCategories(driver);
        category.login("admin@example.com","123456");
    }

    @Test
    public void createCategory() throws InterruptedException {
        category = new PageAddCategories(driver);
        //category.login("admin@example.com","123456");
        Thread.sleep(3000);
        category.moveCategory();
        Thread.sleep(3000);
        category.clickAddCategory();
        Thread.sleep(3000);
        category.inputCategory();
        //search category:
        category.searchCategory();

    }
    @Test
    public void removeCategory() throws InterruptedException {
        category = new PageAddCategories(driver);
        category.moveCategory();
        category.removeCategory();

    }




}
