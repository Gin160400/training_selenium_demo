import org.openqa.selenium.WebDriver;

public class RegisterPageObject extends BasePage {
    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;
    public void genderMaleSelected() {
        selectItemInDropdown(driver,RegisterPageUI.GENDER_LINK,"Male");
    }

    public void firstNameTextbox() {
        sendKeyToElement(driver,RegisterPageUI.FIRSTNAME_TEXTBOX,"Gin");
    }

    public void lastNameTextbox() {
        sendKeyToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX,"Dang");
    }

    public void emailTextbox() {
        sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX,"gina@gmail.com");
    }

    public void companyNameTextbox() {
        sendKeyToElement(driver, RegisterPageUI.COMPANY_TEXTBOX,"GD FC");
    }

    public void passwordTextbox() {
        sendKeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX,"123456");
    }

    public void confirmPasswordTextbox() {
        sendKeyToElement(driver, RegisterPageUI.CONFIRMPASSWORD_TEXTBOX, "123456");
    }

    public void registerButton() {
        clickToElement(driver, RegisterPageUI.REGISTER_LINK);
    }

    public void confirmText() {
    }

    /*public void continueButton() {
        clickToElement(driver, RegisterPageUI.CO);
    }*/

    public void myAccountButton() {
    }
}
