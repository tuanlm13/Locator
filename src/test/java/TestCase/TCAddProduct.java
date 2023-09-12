package TestCase;

import PageObject.PageAddCategories;
import PageObject.PageAddProduct;
import common.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;

public class TCAddProduct extends BaseTest {
    PageAddCategories categories;
    PageAddProduct product;

    @BeforeMethod
    public void login(){
        categories = new PageAddCategories(driver);
        categories.login("admin@example.com","123456");
    }

    @Test
    public void addCategory() throws AWTException, InterruptedException {
        product=new PageAddProduct(driver);
        product.moveProduct();
        product.inputProductName();

        product.inputCategory();
        product.inputUnit();
        product.inputTag();
        product.inputColor();
        product.inputPrice();
        product.inputDiscount();
        product.inputQuantity();

        product.submit();


        product.verifyMessage();
    }
}
