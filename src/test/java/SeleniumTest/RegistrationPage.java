package SeleniumTest;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage {
    @FindBy(xpath = "//button[text()='Sign up']")
    private SelenideElement signUpButton;

    @FindBy(xpath = "//input[@id='sign-username']")
    private SelenideElement userNameInput;

    @FindBy(xpath = "//input[@id='sign-password']")
    private SelenideElement passwordInput;

    @FindBy(xpath = "//button[text()='Sign up']")
    private SelenideElement submitButton;

    @FindBy(xpath = "//div[@class='sweet-alert']")
    private SelenideElement successAlert;

    public RegistrationPage() {
    }

    public void clickSignUp() {
        signUpButton.click();
    }

    public void fillUserName(String userName) {
        userNameInput.setValue(userName);
    }

    public void fillUserPassword(String password) {
        passwordInput.setValue(password);
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public String getSuccessAlertText() {
        return successAlert.getText();
    }
}