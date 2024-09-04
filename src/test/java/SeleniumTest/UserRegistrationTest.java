package SeleniumTest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class UserRegistrationTest {

    private static final String BASE_URL = "https://www.demoblaze.com/";
    private static final String USERNAME = "pofirjo";
    private static final String PASSWORD = "firjapri4";

    @BeforeAll
    public static void setUp() {
        open(BASE_URL);
    }

    @Test
    public void testRegistrationAndLogin() {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.clickSignUp();
        registrationPage.fillUserName(USERNAME);
        registrationPage.fillUserPassword(PASSWORD);
        registrationPage.clickSubmit();

        String alertText = registrationPage.getSuccessAlertText();
        assert alertText.contains("register successfully");

        LoginPage loginPage = new LoginPage();
        loginPage.clickLogin();
        loginPage.fillLoginUserName(USERNAME);
        loginPage.fillLoginPassword(PASSWORD);
        loginPage.clickSubmitLogin();
    }
}