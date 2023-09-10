package TestCase;

import PageObject.PageAddCategories;
import PageObject.PageAddContact;
import PageObject.PageLogin;
import common.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TCAddContact extends BaseTest {
    PageAddContact addContact;

    @BeforeMethod
    public void logined(){
        addContact = new PageAddContact(driver);
        addContact.login("admin@example.com","123456");
    }

    @Test
    public void addContact() throws InterruptedException {
        addContact.moveCompany();
        addContact.clickAddNewContact();
        Thread.sleep(3000);
        //addContact.selectImage();
        addContact.createContact();
        addContact.verifyContact();

    }
}
