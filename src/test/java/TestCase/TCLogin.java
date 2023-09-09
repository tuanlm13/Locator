package TestCase;

import PageObject.PageLogin;
import common.BaseTest;
import org.testng.annotations.Test;

public class TCLogin extends BaseTest {
    PageLogin pageLogin;
    @Test
    public void loginSuccess(){
        pageLogin = new PageLogin(driver);

        //Gọi hàm "login" từ LoginPage để dùng
        pageLogin.loginSuccess("admin@example.com","123456");
    }

    @Test
    public void loginTestInvalidEmail() {
        pageLogin = new PageLogin(driver);
        pageLogin.loginInvalidEmail("admin@example.com123", "123456");
    }
}
