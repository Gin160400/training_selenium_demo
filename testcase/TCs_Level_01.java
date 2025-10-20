import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TCs_Level_01 {
    WebDriver driver;

    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    
    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.nopcommerce.com");

        homePage = new HomePageObject(driver);
    }
    
    @Test
    public void TCs_01_homePage(){
        homePage.clickToRegisterButton();

        registerPage = new RegisterPageObject();
        
    }
    @Test
    public void TCs_02_registerPage(){
        registerPage.genderMaleSelected();
        registerPage.firstNameTextbox();
        registerPage.lastNameTextbox();
        registerPage.emailTextbox();
        registerPage.companyNameTextbox();
        registerPage.passwordTextbox();
        registerPage.confirmPasswordTextbox();
        registerPage.registerButton();
        registerPage.confirmText();
        registerPage.continueButton();
        registerPage.myAccountButton();
        
    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
