package TestCase;

import PageObject.LoginPage;
import common.BaseTest;
import org.testng.annotations.Test;

public class TCLogin extends BaseTest {
    LoginPage loginPage;
    @Test
    public void loginSuccess(){
        loginPage = new LoginPage(driver);

        //Gọi hàm "login" từ LoginPage để dùng
        loginPage.loginSuccess("admin@example.com","123456");
    }

    @Test
    public void loginTestInvalidEmail() {
        loginPage = new LoginPage(driver);
        loginPage.loginInvalidEmail("admin@example.com123", "123456");
    }
}
