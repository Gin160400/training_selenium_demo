import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {
    WebDriver driver;

    /*Web Element*/

    public WebElement getWebElement(WebDriver driver, String location){
        return driver.findElement(getByCssSelector(location));
    }

    public By getByCssSelector(String location){
        return By.cssSelector(location);
    }

    public void openURL(String url) {
        driver.get(url);
    }

    public void waitForElementSelected(WebDriver driver, String location){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.invisibilityOfElementLocated(getByCssSelector(location)));
    }

    public void clickToElement(WebDriver driver, String location) {
        getWebElement(driver,location).click();
    }

    public void sendKeyToElement(WebDriver driver, String location, String valueToString) {
        getWebElement(driver,location).clear();
        getWebElement(driver,location).sendKeys(valueToString);
    }

    public String getElementText(WebDriver driver, String location){
        return getWebElement(driver,location).getText();
    }

    public void selectItemInDropdown(WebDriver driver, String location, String itemValue){
        new Select(getWebElement(driver, location)).selectByVisibleText(itemValue);
    }

    public String getSelectedOptionInDropdown(WebDriver driver, String location){
        return new Select(getWebElement(driver, location)).getFirstSelectedOption().getText();
    }

    public boolean isDropdownMultiple(WebDriver driver, String location){
        return new Select(getWebElement(driver, location)).isMultiple();
    }

    public void sleepInSecond(long timeInSecond){
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
        getWebElement(driver, parentLocator).click();
        sleepInSecond(1);

        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByCssSelector(childItemLocator)));

        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {
                sleepInSecond(1);

                item.click();
                sleepInSecond(1);
                break;
            }
        }
    }

    public String getElementAttribute(WebDriver driver, String locator, String attributeName){
        return getWebElement(driver, locator).getAttribute(attributeName);
    }

    public String getElementCssValue(WebDriver driver, String locator, String propertyName){
        return getWebElement(driver, locator).getCssValue(propertyName);
    }

    public void switchToWindowByID(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
            if (!runWindow.equals(parentID)) {
                driver.switchTo().window(runWindow);
                break;
            }
        }
    }

    public void switchToWindowByTitle(WebDriver driver, String title) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            driver.switchTo().window(runWindows);
            String currentWin = driver.getTitle();
            if (currentWin.equals(title)) {
                break;
            }
        }
    }

    public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            if (!runWindows.equals(parentID)) {
                driver.switchTo().window(runWindows);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }
}
