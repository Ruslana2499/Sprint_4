package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPageObject {
    private WebDriver driver;
    private By nameField = By.cssSelector("input[placeholder*='Имя']");
    private By lastNameField = By.cssSelector("input[placeholder*='Фамилия']");
    private By addressField = By.cssSelector("input[placeholder*='Адрес']");
    private By metroStationField = By.cssSelector("input[placeholder*='метро']");
    private By metroButton = By.cssSelector(".select-search__option");
    private By phoneField = By.cssSelector("input[placeholder*='Телефон']");
    private By dateField = By.cssSelector("input[placeholder*='Когда привезти самокат']");
    private By rentalPeriodField = By.className("Dropdown-control");
    private By rentalPeriodOption = By.className("Dropdown-option");
    private By continueButton = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    private By orderButton = By.xpath(".//*[text()='Заказать' and contains(@class,'Button_Middle__1CSJM')]");
    private By confirmOrderCreationButton = By.xpath(".//*[text()='Да']");
    private By orderCreatedModalHeader = By.xpath(".//*[text()='Заказ оформлен']");

    public OrderPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void setLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void setAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void setPhone(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }

    public void continueButtonClick() {
        driver.findElement(continueButton).click();
    }

    public void setMetroStation() {
        driver.findElement(metroStationField).click();
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(metroButton));
        driver.findElement(metroButton).click();
    }

    public void setDate(String date) {
        WebElement dateFieldElement = driver.findElement(dateField);
        dateFieldElement.sendKeys(date);
        dateFieldElement.sendKeys(Keys.ENTER);
    }

    public void setRentalPeriod() {
        driver.findElement(rentalPeriodField).click();
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(rentalPeriodOption));
        driver.findElement(rentalPeriodOption).click();
    }

    public void orderButtonClick() {
        driver.findElement(orderButton).click();
    }

    public void confirmOrderCreationButtonClick() {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(confirmOrderCreationButton));
        driver.findElement(confirmOrderCreationButton).click();
    }

    public boolean isOrderCreatedModalHeaderVisible() {
        return driver.findElement(orderCreatedModalHeader).isDisplayed();
    }

    public void fill(String name, String lastName, String address, String phone, String date){
        this.setName(name);
        this.setLastName(lastName);
        this.setAddress(address);
        this.setMetroStation();
        this.setPhone(phone);
        this.continueButtonClick();
        this.setDate(date);
        this.setRentalPeriod();
    }
}
