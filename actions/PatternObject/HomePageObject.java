import org.openqa.selenium.WebDriver;

public class HomePageObject extends BasePage{

    private WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToRegisterButton() {
        clickToElement(driver,HomePageUI.REGISTER_LINK);
    }
}
