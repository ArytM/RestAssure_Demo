package SeleniumTest;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage {
    @FindBy(xpath = "//button[text()='Log in']")
    private SelenideElement loginButton;

    @FindBy(xpath = "//input[@id='loginusername']")
    private SelenideElement loginUserNameInput;

    @FindBy(xpath = "//input[@id='loginpassword']")
    private SelenideElement loginPasswordInput;

    @FindBy(xpath = "//button[text()='Log in']")
    private SelenideElement submitLoginButton;

    public LoginPage() {
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void fillLoginUserName(String userName) {
        loginUserNameInput.setValue(userName);
    }

    public void fillLoginPassword(String password) {
        loginPasswordInput.setValue(password);
    }

    public void clickSubmitLogin() {
        submitLoginButton.click();
    }
}