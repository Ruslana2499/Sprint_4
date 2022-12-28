package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class HomePageObject {
    private final WebDriver driver;
    private final By dropDownListItem = By.className("accordion__button");
    private final By dropDownListText = By.className("accordion__panel");
    private final By orderButtonInHeader = By.cssSelector(".Header_Header__214zg .Button_Button__ra12g");
    private final By orderButtonInBody = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    private final By acceptCookiesButton = By.className("App_CookieButton__3cvqF");

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    private String getDropDownListItemId(WebElement item) {
        String buttonId = item.getAttribute("id");
        return buttonId.substring(buttonId.indexOf('-') + 1);
    }

    public List<String> getDropDownListIds() {
        List<String> result = new ArrayList<String>();
        List<WebElement> buttons = driver.findElements(dropDownListItem);
        for (WebElement button : buttons) {
            String buttonId = getDropDownListItemId(button);
            result.add(buttonId);
        }
        return result;
    }

    public void clickDropDownListItem(String id) {
        List<WebElement> buttons = driver.findElements(dropDownListItem);
        for (WebElement button : buttons) {
            String buttonId = getDropDownListItemId(button);
            if (buttonId.equals(id)) {
                button.click();
                return;
            }
        }
    }

    public String getVisibleDropDownListTextBlockId() {
        List<WebElement> panels = driver.findElements(dropDownListText);
        for (WebElement panel : panels) {
            if (panel.isDisplayed()) {
                return getDropDownListItemId(panel);
            }
        }
        return null;
    }

    public void clickOrderButtonInHeader() {
        driver.findElement(orderButtonInHeader).click();
    }

    public void clickOrderButtonInBody() {
        driver.findElement(orderButtonInBody).click();
    }

    public void clickAcceptCookiesButton() {
        driver.findElement(acceptCookiesButton).click();
    }
}
